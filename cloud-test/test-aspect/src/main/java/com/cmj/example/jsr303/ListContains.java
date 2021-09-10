package com.cmj.example.jsr303;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {ListContainsValidator.class})
public @interface ListContains {
    String[] listVals() default {};

    String message() default "输入的类型不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
