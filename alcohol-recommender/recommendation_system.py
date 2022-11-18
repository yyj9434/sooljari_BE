#!/usr/bin/env python
# coding: utf-8

# # 술 추천 알고리즘
# 
# 도수 유사도는 `euclidean distance`로 구했고, 풍미 및 기타 정보의 유사도는 `cosine similarity`로 구했다.  
# 술의 고유 id를 받아 비슷한 술의 고유 id를 return한다.
# 
# ### general_recommendation():
# 도수 유사도 50% 풍미(6가지) 유사도 50% 고려해 주종 상관 없이 비슷한 술을 찾아줌
# 
# ### wine_recommendation():
# 도수 유사도 50% 기타(category, origin, producer, wine_grape, flavour) 50% 고려해 같은 대분류 내에서 비슷한 와인을 찾아줌
# 
# ### the used variables of each alcohols
# (현재는 wine recommendation만 구축됨! makgeoli, beer, vodka, soju, whisky, korean도 variable만 바꾸어주어 만들면 됨.)  
# 
# all: percent, flavour  
# wine: category, percent, **origin**, **producer**, **wine_grape**, flavour  
# makgeoli: category, percent, **producer**, flavour  
# beer: category, percent, **origin**, **producer**, flavour  
# vodka: **origin**, producer, flavour  
# soju: category, percent, **producer**, flavour  
# whisky: category, **whisky_category**, percent, **origin**, flavour  
# korean: category, percent, flavour  
# 
# ### the explanation of variables
# id: 술의 고유 id  
# class: 주종  
# category: 중분류  
# name: 이름  
# percent: 도수  
# origin: 원산지/생산지  
# producer: 제조사/생산자  
# wine_grape: 포도 품종 (와인만)  
# whisky_category: 위스키 소분류 (위스키만)  
# sweet: 달콤한  
# light: 가벼운  
# soft: 부드러운  
# bitter: 쓴맛이 강한  
# clean: 깔끔한  
# smell: 향이 강한  

# In[1]:


# 여러 주종 내 추천
# 주종에 상관 없이 도수와 풍미만 고려해 비슷한 술을 추천해줌
# 항목: 도수, 풍미 (약 6개 항목)

import numpy as np
import pandas as pd 
from sklearn.metrics.pairwise import cosine_similarity
from sklearn.feature_extraction.text import CountVectorizer
from scipy.spatial import distance_matrix
from scipy.spatial.distance import squareform
from sklearn.preprocessing import MinMaxScaler

# data = pd.read_csv("data/drinksData.csv")

# 확인
# data.head()


# In[2]:


import pymysql

# MySQL Connection
conn = pymysql.connect(host='localhost', user='root', password='1234', db='sooljari', charset='utf8')
curs = conn.cursor()

sql = "select * from product"
curs.execute(sql)

rows = curs.fetchall()

colname = curs.description

col = []

for i in colname :
    col.append(i[0])
    
emp = pd.DataFrame(list(rows), columns=col)
data = emp[['id','area','description','name','price','proof','image','category','sweet','light','soft','bitter','clean','smell']]


# In[3]:


# 도수 유사도 구하기
percent = data['proof']
dist_pair = []

# y축에 임의로 0을 부여한 거리 순서쌍 생성
for i in range(0,len(percent)):
    temp = []
    temp.append(data.loc[i]['proof'])
    temp.append(0)
    dist_pair.append(temp)

# get a distance matrix
df = pd.DataFrame(dist_pair, columns=['x', 'y'])
dist_matrix = distance_matrix(df.values, df.values)

# 정규화
min_max_scaler = MinMaxScaler()
regularised = min_max_scaler.fit_transform(dist_matrix)

# 1에서 빼줘서 더 가까운 것이 우선순위를 갖도록 변경하기
# 데이터 숫자만큼으로 변경해줘야 함
one_matrix = np.ones((24,24))

final_dist = one_matrix - regularised



# In[4]:


# flavour word list 만들기
flavour_list = [] # empty list

for i in range(0, len(data)):
    temp = ""
    
    if data.loc[i]['sweet'] == 1:
        temp = temp + "sweet "
    if data.loc[i]['light'] == 1:
        temp = temp + "light "
    if data.loc[i]['soft'] == 1:
        temp = temp + "soft "
    if data.loc[i]['bitter'] == 1:
        temp = temp + "bitter "
    if data.loc[i]['clean'] == 1:
        temp = temp + "clean "
    if data.loc[i]['smell'] == 1:
        temp = temp + "smell "
    
    flavour_list.append(temp)

# 해당 리스트 데이터 프레임에 추가
data["flavour"] = pd.DataFrame({"flavour":flavour_list})
flavour = data['flavour']

# flavour 코사인 유사도 구하기
# instantiating and generating the count matrix
count = CountVectorizer()
count_matrix = count.fit_transform(flavour)

# generating the cosine similarity matrix
cosine_sim = cosine_similarity(count_matrix, count_matrix)


# In[5]:


# 도수, flavour를 모두 고려한 similarity 구하기 (weight는 각각 0.5)
new_sim = 0.5 * cosine_sim + 0.5 * final_dist



# In[6]:


# 여러 주종 내 추천
# 주종에 상관 없이 도수와 풍미만 고려해 비슷한 술을 추천해줌
# 항목: 도수, 풍미 (약 6개 항목)

# 고유 id를 넣으면 해당 술과 비슷한 Top 10의 id를 return
def general_recommendation(input_id, new_sim = new_sim):

    input_id = int(input_id)
    # 고유 id로 index 찾기 
    idx = data.index[data['id'] == input_id].tolist() # Int64Index 형식이라 list로 바꾸어줌
    
    # 해당 index의 유사도 리스트 sort in descending order
    score_series = pd.Series(new_sim[idx[0]]).sort_values(ascending = False)
    
    # 유사도 Top 10의 index 추출
    top_10_indexes = list(score_series.iloc[1:11].index)

    # 유사도 1인 항목이 하나 더 있어서 자기 자신이 포함되는 경우에는 자신을 뺀 Top 10의 index 재추출
    if top_10_indexes[0] == idx[0]:
        top_10_indexes = list(score_series.iloc[1:12].index)
        top_10_indexes.remove(idx[0])
    
    # 고유 id를 담기 위한 empty list 생성
    top_10_id = []
    
    # id list
    for i in top_10_indexes:
        id = data.loc[i]['id']
        top_10_id.append(id)
    
    return top_10_id


# In[7]:


# 내가 데어터 가공 해본다 !!!!

def get_counts(seq) :
    counts = {}
    for x in seq :
        if x in counts :
            counts[x] += 1
        else :
            counts[x] = 1
    return counts

def top_n(count_dict, n) :
    val_key = [(v, k) for k, v in count_dict.items()]
    val_key.sort(reverse=True)
    return val_key[:n]

def get_result(userEmail) :
    sql2 = "select product_id from liked where user_id ='" + userEmail + "'"
#    sql2 = "select product_id from liked where user_id = 'dy123'"
    curs.execute(sql2)
    result = [item[0] for item in curs.fetchall()]

    rec_arr = []

    for i in result :
        rec = general_recommendation(i)
        rec_arr.extend(rec)

    counts = get_counts(rec_arr)

    top = top_n(counts, n=10)

    rec_result = []

    for i in range(len(top)) :
        rec_result.append(top[i][1])
        
    return rec_result

#result = get_result()


# In[8]:


#print(result)

# print(is_wine(test_num))

# print(wine_recommendation(test_num))


# In[9]:


def post_result(result) :
    df = data.loc[data['id'].isin(result)]
    df2 = df.reset_index(drop=True)
    df3 = df2.transpose()
    df3.head()
    js = df3.to_json(force_ascii=False)
    return js


# In[10]:


#df = data.loc[data['id'].isin(result)]
#df2 = df.reset_index(drop=True)
#df3 = df2.transpose()
#df3.head()


# In[11]:


#js = df3.to_json(force_ascii=False)
#print(js)


# In[ ]:


from flask import Flask
from flask import request
from flask import jsonify
from flask_cors import CORS

app = Flask(__name__)
cors = CORS(app, resources = {r"/recommend/*": {"origins" : "http://localhost:3000"}})

@app.route("/recommend", methods=['GET', 'POST'])
def test() :
    id = request.args.get('id')
    if(id == None) :
        userEmail = request.cookies.get('userEmail')
        result = get_result(userEmail)
        print("this is recommend for user",userEmail, result, post_result(result))
    else :
        result = general_recommendation(id)
        print("this is dataRecommend", id, result, post_result(result))
    return post_result(result)

# @app.route("/recommendById", methods=['GET'])
# def test2() :
#     id = request.args.get('id')
#     print(id)
#     result = general_recommendation(id)
#     return post_result(result)

if __name__ == "__main__" :
    app.run(debug=True)

