package com.ouou.sooljari.recommend.model;

import com.ouou.sooljari.recommend.dto.LikedRequestDto;
import com.ouou.sooljari.recommend.entity.Liked;
import com.ouou.sooljari.recommend.entity.LikedRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class LikedService {
    private final LikedRepo likedRepo;

    /** Like 생성 **/

    @Transactional
    public Long save(final LikedRequestDto params) {
        Liked entity = likedRepo.save(params.toEntity());
        return entity.getId();
    }

    /** Like 삭제 **/
    @Transactional
    public Long delete(final LikedRequestDto params) {
        likedRepo.delete(params.toEntity());
        return null;
    }

}