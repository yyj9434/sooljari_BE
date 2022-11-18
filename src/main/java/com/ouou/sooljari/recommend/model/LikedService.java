package com.ouou.sooljari.recommend.model;

import com.ouou.sooljari.recommend.dto.LikedRequestDto;
import com.ouou.sooljari.recommend.entity.Liked;
import com.ouou.sooljari.recommend.entity.LikedRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class LikedService {
    private final LikedRepo likedRepo;

    /** Like 생성 **/

    @Transactional
    public void save(final LikedRequestDto params) {
        Liked entity = likedRepo.save(params.toEntity());
//        return entity.getId();
    }

    /** Like 삭제 **/
    @Transactional
    public void delete(final LikedRequestDto params) {
        likedRepo.deleteByProductIdAndUserId(params.getProductId(), params.getUserId());
    }

    @Transactional
    public boolean check(final LikedRequestDto params) {
        boolean result = likedRepo.checkLiked(params.getProductId(), params.getUserId());
        return result;
    }

}