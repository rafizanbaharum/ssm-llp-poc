package com.ssm.llp.biz.validation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author rafizan.baharum
 * @since 9/19/13
 */
@Component("validatorHelper")
public class ValidatorHelper {

    private Logger log = LoggerFactory.getLogger(ValidatorHelper.class);

    @Autowired
    private ValidatorChain chain;

    public ValidatorContext validate(String name) {
        ValidatorContext context = new ValidatorContext();
        return chain.validate(name, context);
    }
}
