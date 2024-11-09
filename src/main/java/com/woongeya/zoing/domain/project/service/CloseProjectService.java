package com.woongeya.zoing.domain.project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.woongeya.zoing.domain.auth.repository.AuthRepository;
import com.woongeya.zoing.domain.project.domain.Member;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.project.domain.repository.MemberRepository;
import com.woongeya.zoing.domain.project.exception.IsNotWriterException;
import com.woongeya.zoing.domain.project.exception.MemberNotFoundException;
import com.woongeya.zoing.domain.project.facade.ProjectFacade;
import com.woongeya.zoing.domain.user.domain.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CloseProjectService {

    private final ProjectFacade projectFacade;
    private final AuthRepository authRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public void execute(Long id) {
        User user = authRepository.getCurrentUser();
        Project project = projectFacade.getProject(id);
        Member member = memberRepository.findByUserIdAndProjectId(user.getId(), project.getId())
                .orElseThrow(MemberNotFoundException::new);

        if (!member.isWriter()) {
            throw new IsNotWriterException();
        }

        project.close();
    }
}
