package com.example.validForm.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ISBNValidator implements ConstraintValidator<ISBN, String> {
    public void initialize(ISBN constraint) {
    }

    @Override
    public boolean isValid(String isbn, ConstraintValidatorContext constraintValidatorContext) {

        isbn = isbn.replace("-", "");
        int suma = 0;
        for (int i = 0; i < isbn.length(); i++) {
            suma += (i%2==0 ?1 :3) * Character.getNumericValue(isbn.charAt(i));
        }
        return suma % 10 == 0;
    }


}