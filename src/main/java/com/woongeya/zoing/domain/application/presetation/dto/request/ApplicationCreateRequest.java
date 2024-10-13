package com.woongeya.zoing.domain.application.presetation.dto.request;

import com.woongeya.zoing.domain.application.domain.Application;
import com.woongeya.zoing.domain.application.domain.type.ApplicationState;
import com.woongeya.zoing.domain.project.domain.Project;
import com.woongeya.zoing.domain.user.domain.User;

import jakarta.validation.constraints.NotNull;

public record ApplicationCreateRequest (
     @NotNull
     String position,
     @NotNull
     String phone,
     String introduce
) {
    public Application toEntity(User user, Project project) {
        return Application.builder()
            .userId(user.getId())
            .projectId(project.getId())
            .introduce(introduce)
            .phone(phone)
            .state(ApplicationState.PENDING)
            .position(position)
            .build();
    }
}
