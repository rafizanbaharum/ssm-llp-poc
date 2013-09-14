package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmRegistration;
import com.ssm.llp.core.model.SsmRegistrationType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 9/7/13
 */
@Table(name = "SSM_REGISTRATION")
@Entity(name = "SsmRegistration")
@Inheritance(strategy = InheritanceType.JOINED)
public class SsmRegistrationImpl extends SsmDocumentImpl implements Serializable, SsmRegistration {

    @Column(name = "NAME")
    private String name;  // choosen name

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "REGISTRATION_TYPE")
    private SsmRegistrationType type;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public SsmRegistrationType getType() {
        return type;
    }

    @Override
    public void setType(SsmRegistrationType type) {
        this.type = type;
    }
}
