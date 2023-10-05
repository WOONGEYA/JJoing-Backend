package com.woongeya.zoing.global.scheduler;

import com.woongeya.zoing.domain.project.service.CloseEndProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProjectScheduler {

    private final CloseEndProjectService closeEndProjectService;

    @Scheduled(cron = "0/10 * * * * *")
    public void execute() {
        closeEndProjectService.execute();
    }
}
