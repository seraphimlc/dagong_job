package com.dagong.util;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.Set;

import static com.google.common.collect.Iterables.getFirst;


/**
 * Created by lc on 16/2/3.
 */
public class BeanValidator {

    public static <T> void validate(T object) throws ValidationException{

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<T>> constraintViolations = validator.validate(object);

        ConstraintViolation<T> constraintViolation = getFirst(constraintViolations, null);
        if (constraintViolation != null) {
            throw new ValidationException(constraintViolation.getPropertyPath()+constraintViolation.getMessage());
        }
    }



}
