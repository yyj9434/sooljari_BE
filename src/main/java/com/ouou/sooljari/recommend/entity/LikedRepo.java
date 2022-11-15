package com.ouou.sooljari.recommend.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Optional;

public interface LikedRepo extends JpaRepository<Liked, Long> {
    Optional<Liked> findById(Long id);

    @Transactional
    @Modifying
    @Query(value = "delete from liked where product_id = :productId and user_id= :userId", nativeQuery = true)
    void deleteByProductIdAndUserId(@Param("productId") Long productId,
                                             @Param("userId") String userId);
}