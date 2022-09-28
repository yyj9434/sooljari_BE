package com.ouou.sooljari.community.model;

import com.ouou.sooljari.community.dto.CommunityRequestDto;
import com.ouou.sooljari.community.dto.CommunityResponseDto;
import com.ouou.sooljari.community.entity.Community;
import com.ouou.sooljari.community.entity.CommunityRepo;
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
}
