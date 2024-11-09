package com.woongeya.zoing.domain.auth.annotation;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(METHOD)
@Retention(RetentionPolicy.RUNTIME)
@LoginRequired
public @interface AdminOnly {
}
