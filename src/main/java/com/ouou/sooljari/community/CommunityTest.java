package com.ouou.sooljari.community;

import com.ouou.sooljari.community.entity.Community;
import com.ouou.sooljari.community.entity.CommunityRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class CommunityTest {

    @Autowired
    CommunityRepo communityRepo;

    @Test
    void save() {
        Community params = Community.builder()
                .user("user")
                .title("title")
                .image("image")
                .content("content")
                .likes(1)
                .build();

        communityRepo.save(params);

        Community entity = communityRepo.findById((long) 2).orElse(null);
        assertThat(entity.getUser()).isEqualTo("user");
    }

    @Test
    void findAll() {
        long communityCount = communityRepo.count();

        List<Community> community = communityRepo.findAll();
    }

    @Test
    void delete() {
        Community entity = communityRepo.findById((long) 1).get();

        communityRepo.delete(entity);
    }
}
