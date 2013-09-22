package com.ssm.llp.biz.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationAwareOrderComparator;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/22/13
 */
@Component("validatorChain")
public class ValidatorChain {

    @Autowired
    private List<Validator> validators;

    @PostConstruct
    public void init() {
        Collections.sort(validators, AnnotationAwareOrderComparator.INSTANCE);
    }

    public ValidatorContext validate(String name, ValidatorContext context) {
        for (Validator validator : validators) {
            if (validator.validate(name, context)) break;
        }
        return context;
    }
}
