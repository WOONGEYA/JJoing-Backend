package com.woongeya.zoing.domain.project.service;

import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.repository.CustomMemberRepository;
import com.woongeya.zoing.domain.project.domain.repository.MemberRepository;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import com.woongeya.zoing.domain.project.exception.MemberNotFoundException;
import com.woongeya.zoing.domain.project.presetation.dto.request.MemberRequestDto;
import com.woongeya.zoing.domain.user.UserFacade;
import com.woongeya.zoing.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteMemberService {

    private final UserFacade userFacade;
    private final MemberRepository memberRepository;
    private final CustomMemberRepository customMemberRepository;

    @Transactional
    public void execute(Long id, MemberRequestDto request) {
        User user = userFacade.getCurrentUser();
        Member member = customMemberRepository.findByUserIdAndProjectId(user.getId(), id)
                .orElseThrow(() -> MemberNotFoundException.EXCEPTION);

        if (!member.isWriter()) {
            throw new IsNotWriterException();
        }

        memberRepository.delete(
                memberRepository.findById(request.getMemberId())
                        .orElseThrow(() -> MemberNotFoundException.EXCEPTION)
        );
    }
}
