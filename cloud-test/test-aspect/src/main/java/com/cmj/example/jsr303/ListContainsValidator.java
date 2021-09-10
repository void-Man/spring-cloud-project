package com.cmj.example.jsr303;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author mengjie_chen
 * @description
 * @date 2021/9/11
 */
public class ListContainsValidator implements ConstraintValidator<ListContains, String> {
    private Set<String> valsSet = new HashSet<>();

    @Override
    public void initialize(ListContains constraintAnnotation) {
        valsSet = Stream.of(constraintAnnotation.listVals()).collect(Collectors.toSet());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return valsSet.contains(value);
    }
}
