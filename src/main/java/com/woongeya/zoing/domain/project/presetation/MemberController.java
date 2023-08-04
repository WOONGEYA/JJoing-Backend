package com.woongeya.zoing.domain.project.presetation;

import com.woongeya.zoing.domain.project.presetation.dto.request.MemberRequestDto;
import com.woongeya.zoing.domain.project.service.DeleteMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("project/member")
public class MemberController {

    private final DeleteMemberService deleteMemberService;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id, @RequestBody MemberRequestDto request) {
        deleteMemberService.execute(id, request);
    }
}
