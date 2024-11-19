package com.woongeya.zoing.domain.follow.presetation;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woongeya.zoing.domain.follow.presetation.dto.reponse.FollowResponse;
import com.woongeya.zoing.domain.follow.service.CountFollowerService;
import com.woongeya.zoing.domain.follow.service.CountFollowingService;
import com.woongeya.zoing.domain.follow.service.CreateFollowService;
import com.woongeya.zoing.domain.follow.service.DeleteFollowService;
import com.woongeya.zoing.domain.follow.service.FindFollowerService;
import com.woongeya.zoing.domain.follow.service.FindFollowingService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/follow")
public class FollowController {

    private final CreateFollowService createFollowService;
    private final FindFollowingService findFollowingService;
    private final FindFollowerService findFollowerService;
    private final CountFollowingService countFollowingService;
    private final CountFollowerService countFollowerService;
    private final DeleteFollowService deleteFollowService;

    @PostMapping("/{id}")
    @Operation(summary = "팔로우 생성")
    public void createFollow(@PathVariable Long id) {
        createFollowService.execute(id);
    }

    @GetMapping("/{id}/following")
    @Operation(summary = "유저의 모든 팔로잉 조회")
    public List<FollowResponse> findFollwing(@PathVariable Long id) {
        return findFollowingService.execute(id);
    }

    @GetMapping("/{id}/following/count")
    @Operation(summary = "유저의 팔로잉 수 조회")
    public Integer countFollowing(@PathVariable Long id) {
        return countFollowingService.execute(id);
    }

    @GetMapping("/{id}/follower")
    @Operation(summary = "유저의 모든 팔로워 조회")
    public List<FollowResponse> findFollower(@PathVariable Long id) {
        return findFollowerService.execute(id);
    }

    @GetMapping("/{id}/follower/count")
    @Operation(summary = "유저의 팔로워 수 조회")
    public Integer countFollower(@PathVariable Long id) {
        return countFollowerService.execute(id);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "팔로우 삭제(언팔로우)")
    public void unFollow(@PathVariable Long id) {
        deleteFollowService.execute(id);
    }
}
