package com.ouou.sooljari.community.model;

import com.ouou.sooljari.community.dto.CommunityLikedRequestDto;
import com.ouou.sooljari.community.dto.CommunityRequestDto;
import com.ouou.sooljari.community.dto.CommunityResponseDto;
import com.ouou.sooljari.community.entity.Community;
import com.ouou.sooljari.community.entity.CommunityLiked;
import com.ouou.sooljari.community.entity.CommunityLikedRepo;
import com.ouou.sooljari.community.entity.CommunityRepo;
import com.ouou.sooljari.recommend.dto.LikedRequestDto;
import com.ouou.sooljari.recommend.entity.Liked;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommunityService {

    private final CommunityRepo CommunityRepo;

    private final CommunityLikedRepo CommunityLikedRepo;

    /**
     * product 생성
     */
    @Transactional
    public Long save(final CommunityRequestDto params) {
        Community entity = CommunityRepo.save(params.toEntity());
        return entity.getId();
    }

    /**
     * Community 리스트 조회
     */
    public List<CommunityResponseDto> findAll() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        List<Community> list = CommunityRepo.findAll(sort);
        return list.stream().map(CommunityResponseDto::new).collect(Collectors.toList());
    }

    /**
     * Community id 검색
     */
    public Optional <Community> findById(Long id) {
        return CommunityRepo.findById(id);
    }

    /**
     * Community name 검색
     */
//    public List<Product> search(String name) {
//        List<Product> ProductList = productRepo.findByTitleContaining(name);
//        return ProductList;
//    }

    /**
     * Community 수정
     */
    @Transactional
    public Long update(final Long id, final CommunityRequestDto params) {
        Community entity = CommunityRepo.findById(id).orElseThrow();
        entity.update(params.getUser(), params.getTitle(), params.getImage(), params.getContent(), params.getLikes());
        return id;
    }

    /** 커뮤니티 좋아요 저장 **/
    @Transactional
    public void likedSave(final CommunityLikedRequestDto params) {
        CommunityLiked entity = CommunityLikedRepo.save(params.toEntity());
//        return entity.getId();
    }

    @Transactional
    public void likedDelete(final CommunityLikedRequestDto params) {
        CommunityLikedRepo.deleteByCommunityIdAndUserId(params.getCommunityId(), params.getUserId());
    }

    @Transactional
    public String countCommunityliked(final CommunityLikedRequestDto params) {

        Long communityId = params.getCommunityId();
        Optional<CommunityLiked> opt = CommunityLikedRepo.countCommunityLikedByCommunityId(communityId);
        String cnt = String.valueOf(opt.get());
        return cnt;
    }

}
