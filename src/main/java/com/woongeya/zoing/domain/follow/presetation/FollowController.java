package com.woongeya.zoing.domain.follow.presetation;

import com.woongeya.zoing.domain.follow.presetation.dto.reponse.FollowResponseDto;
import com.woongeya.zoing.domain.follow.service.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<List<FollowResponseDto>> findFollwing(@PathVariable Long id) {
        return ResponseEntity.ok(findFollowingService.execute(id));
    }

    @GetMapping("/{id}/following/count")
    @Operation(summary = "유저의 팔로잉 수 조회")
    public Integer countFollowing(@PathVariable Long id) {
        return countFollowingService.execute(id);
    }

    @GetMapping("/{id}/follower")
    @Operation(summary = "유저의 모든 팔로워 조회")
    public ResponseEntity<List<FollowResponseDto>> findFollower(@PathVariable Long id) {
        return ResponseEntity.ok(findFollowerService.execute(id));
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
