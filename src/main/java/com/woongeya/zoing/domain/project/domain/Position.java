package com.woongeya.zoing.domain.project.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
@Embeddable
public class Position {

    private int frontCount;

    private int backCount;

    private int designCount;
}
