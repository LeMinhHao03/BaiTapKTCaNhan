package com.example.demo1.Validator;

import com.example.demo1.Validator.annotation.ValidPhongBanId;
import com.example.demo1.entity.PhongBan;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidPhongBanValidator implements ConstraintValidator<ValidPhongBanId, PhongBan> {
    @Override
    public boolean isValid(PhongBan phongBan, ConstraintValidatorContext context){
        return phongBan != null && phongBan.getMa_Phong() != null;
    }
}
