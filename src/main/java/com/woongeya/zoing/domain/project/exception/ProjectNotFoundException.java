package com.woongeya.zoing.domain.project.exception;

import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.JJoingException;

public class ProjectNotFoundException extends JJoingException {

    public static final JJoingException EXCEPTION = new ProjectNotFoundException();

    public ProjectNotFoundException() {
        super(ErrorCode.PROJECT_NOT_FOUND);
    }
}
