package com.woongeya.zoing.global.scheduler;

import com.woongeya.zoing.domain.project.service.CloseEndProjectService;
import com.woongeya.zoing.global.scheduler.constants.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProjectScheduler {

    private final CloseEndProjectService closeEndProjectService;

    @Scheduled(cron = Schedule.CLOSE_PROJECT_CRON)
    public void execute() {
        closeEndProjectService.execute();
    }
}
