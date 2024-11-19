package com.woongeya.zoing.domain.project.presetation;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woongeya.zoing.domain.project.presetation.dto.request.MemberRequest;
import com.woongeya.zoing.domain.project.presetation.dto.response.MemberResponse;
import com.woongeya.zoing.domain.project.service.CheckMemberService;
import com.woongeya.zoing.domain.project.service.DeleteMemberService;
import com.woongeya.zoing.domain.project.service.FindProjectMemberService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("project/member")
public class MemberController {

    private final DeleteMemberService deleteMemberService;
    private final FindProjectMemberService findProjectMemberService;
    private final CheckMemberService checkMemberService;

    @DeleteMapping("/{id}")
    @Operation(summary = "멤버 삭제")
    public void delete(@PathVariable Long id, @RequestBody MemberRequest request) {
        deleteMemberService.execute(id, request);
    }

    @GetMapping("/{id}")
    @Operation(summary = "프로젝트 멤버 조회")
    public List<MemberResponse> findProjectMember(@PathVariable Long id) {
        return findProjectMemberService.execute(id);
    }

    @GetMapping("/check/{id}")
    @Operation(summary = "프로젝트 멤버 확인")
    public Boolean checkMember(@PathVariable Long id) {
        return checkMemberService.execute(id);
    }
}
