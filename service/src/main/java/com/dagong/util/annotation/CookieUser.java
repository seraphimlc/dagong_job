package com.dagong.util.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * Created by liuchang on 16/4/3.
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CookieUser {
    @AliasFor("name")
    String value() default "";

    @AliasFor("value")
    String name() default "";

    boolean required() default true;

    String defaultValue() default "";
}
