package com.woongeya.zoing.domain.follow.presetation;

import com.woongeya.zoing.domain.follow.presetation.dto.reponse.FollowResponseDto;
import com.woongeya.zoing.domain.follow.service.CountFollowingService;
import com.woongeya.zoing.domain.follow.service.CreateFollowService;
import com.woongeya.zoing.domain.follow.service.FindFollowerService;
import com.woongeya.zoing.domain.follow.service.FindFollowingService;
import lombok.RequiredArgsConstructor;
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

    @PostMapping("/{id}")
    public void createFollow(@PathVariable Long id) {
        createFollowService.execute(id);
    }

    @GetMapping("/{id}/following")
    public List<FollowResponseDto> findFollwing(@PathVariable Long id) {
        return findFollowingService.execute(id);
    }

    @GetMapping("/following/{id}/count")
    public Long countFollowing(@PathVariable Long id) {
        return countFollowingService.execute(id);
    }

    @GetMapping("/{id}/follower")
    public List<FollowResponseDto> findFollower(@PathVariable Long id) {
        return findFollowerService.execute(id);
    }

}
