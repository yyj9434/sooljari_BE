package com.ouou.sooljari.recommend.model;

import com.ouou.sooljari.recommend.dto.LikeRequestDto;
import com.ouou.sooljari.recommend.dto.LikeResponseDto;
import com.ouou.sooljari.recommend.entity.Like;
import com.ouou.sooljari.recommend.entity.LikeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class LikeService {
    private final LikeRepo likeRepo;

    /** Like 생성 **/
    @Transactional
    public Long save(final LikeRequestDto params) {
        Like entity = likeRepo.save(params.toEntity());
        return entity.getId();
    }

    /** Like 삭제 **/
//    @Transactional
//    public Long delete(final LikeRequestDto params) {
//        Like entity = likeRepo.
//    }

}