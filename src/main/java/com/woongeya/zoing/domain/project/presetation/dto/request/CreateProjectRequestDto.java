package com.woongeya.zoing.domain.project.presetation.dto.request;

import java.time.LocalDate;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public record CreateProjectRequestDto (
    @NotNull String name,
    @NotNull String content,
    @NotNull Integer requiredPeople,
    @NotNull LocalDate endDate,
    String imgUrl,
    List<String> skills,
    List<String> coops,
    List<String> moods,
    List<String> positions
) {
}
