package com.woongeya.zoing.domain.follow.presetation;

import com.woongeya.zoing.domain.follow.service.CreateFollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/follow")
public class FollowController {

    private final CreateFollowService createFollowService;

    @PostMapping("/{id}")
    public void createFollow(@PathVariable Long id) {
        createFollowService.execute(id);
    }
}
