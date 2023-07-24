package com.woongeya.zoing.domain.follow.presetation;

import com.woongeya.zoing.domain.follow.presetation.dto.reponse.FollowResponseDto;
import com.woongeya.zoing.domain.follow.service.*;
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
    public void createFollow(@PathVariable Long id) {
        createFollowService.execute(id);
    }

    @GetMapping("/{id}/following")
    public ResponseEntity<List<FollowResponseDto>> findFollwing(@PathVariable Long id) {
        return ResponseEntity.ok(findFollowingService.execute(id));
    }

    @GetMapping("/{id}/following/count")
    public Long countFollowing(@PathVariable Long id) {
        return countFollowingService.execute(id);
    }

    @GetMapping("/{id}/follower")
    public ResponseEntity<List<FollowResponseDto>> findFollower(@PathVariable Long id) {
        return ResponseEntity.ok(findFollowerService.execute(id));
    }

    @GetMapping("/{id}/follower/count")
    public Long countFollower(@PathVariable Long id) {
        return countFollowerService.execute(id);
    }

    @DeleteMapping("/{id}")
    public void unFollow(@PathVariable Long id) {
        deleteFollowService.execute(id);
    }
}
