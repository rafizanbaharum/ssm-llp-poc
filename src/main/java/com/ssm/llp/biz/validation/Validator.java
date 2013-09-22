package com.ssm.llp.biz.validation;

/**
 * @author rafizan.baharum
 * @since 9/22/13
 */
public interface Validator {

    public boolean validate(String name, ValidatorContext context);
}
