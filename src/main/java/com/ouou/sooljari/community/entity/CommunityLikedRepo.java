package com.ouou.sooljari.community.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.sql.ResultSet;
import java.util.Optional;

public interface CommunityLikedRepo extends JpaRepository<CommunityLiked, Long> {
    Optional<CommunityLiked> findById(Long id);

    @Transactional
    @Modifying
    @Query(value = "delete from community_liked where community_id = :communityId and user_id= :userId", nativeQuery = true)
    void deleteByCommunityIdAndUserId(@Param("communityId") Long communityId,
                                    @Param("userId") String userId);

    @Transactional
    @Modifying
    @Query(value = "select liked from liked where product_id = :productId and user_id= :userId", nativeQuery = true)
    boolean checkLiked(@Param("productId") Long productId,
                       @Param("userId") String userId);

    Optional<CommunityLiked> countCommunityLikedByCommunityId(Long communityId);
}