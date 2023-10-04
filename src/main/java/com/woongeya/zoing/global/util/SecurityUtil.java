package com.woongeya.zoing.global.util;

import com.woongeya.zoing.domain.user.domain.User;
import com.woongeya.zoing.global.error.exception.ErrorCode;
import com.woongeya.zoing.global.error.exception.ZoingException;
import com.woongeya.zoing.global.security.auth.AuthDetails;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtil {

    public static User getCurrentUserOrNull() {
        try {
            return getUser();
        } catch (Exception e) {
            return null;
        }
    }

    private static User getUser() {

        Object principal = SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();

        if (principal instanceof String) {
            throw new ZoingException(ErrorCode.USER_NOT_LOGIN);
        }

        AuthDetails authDetails = (AuthDetails) principal;

        return authDetails.getUser();
    }
}
