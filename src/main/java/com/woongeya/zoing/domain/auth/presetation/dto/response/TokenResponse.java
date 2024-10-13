package com.woongeya.zoing.domain.auth.presetation.dto.response;

public record TokenResponse (
    String token,
    String validate
) {}
