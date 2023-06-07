package com.example.demo1.Validator;

import com.example.demo1.Validator.annotation.ValidUserId;
import com.example.demo1.entity.User;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User User, ConstraintValidatorContext context){
        if(User == null)
            return true;
        return User.getId() != null;
    }
}
