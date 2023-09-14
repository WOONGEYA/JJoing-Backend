package com.woongeya.zoing.domain.project.presetation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProjectRequestDto {

    @NotNull
    private String name;

    @NotNull
    private String content;

    @NotNull
    private Integer requiredPeople;

    private LocalDate endDate;

    private List<String> skills;

    private List<String> coops;

    private List<String> moods;

    private List<String> positions;

    private List<String> imgUrls;
}
