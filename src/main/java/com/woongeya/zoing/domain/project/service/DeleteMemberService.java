package com.woongeya.zoing.domain.project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.repository.MemberRepository;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import com.woongeya.zoing.domain.project.exception.MemberNotFoundException;
import com.woongeya.zoing.domain.project.presetation.dto.request.MemberRequest;
import com.woongeya.zoing.domain.user.domain.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteMemberService {

    private final AuthRepository authRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void execute(Long id, MemberRequest request) {
        User user = authRepository.getCurrentUser();
        Member member = memberRepository.findByUserIdAndProjectId(user.getId(), id)
                .orElseThrow(MemberNotFoundException::new);

        if (!member.isWriter()) {
            throw new IsNotWriterException();
        }

        member.getProject().decreaseCurrentPeople();
        memberRepository.deleteById(request.memberId());
    }
}
