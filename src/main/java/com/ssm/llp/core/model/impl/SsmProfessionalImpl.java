package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmActorType;
import com.ssm.llp.core.model.SsmProfessional;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
@Table(name = "SSM_PROFESSIONAL")
@Entity(name = "SsmProfessional")
public class SsmProfessionalImpl extends SsmActorImpl implements SsmProfessional {

    public SsmProfessionalImpl() {
        setActorType(SsmActorType.PROFESSIONAL);
    }

    public String getNricNo() {
        return getIdentityNo();
    }

    public void setNricNo(String nricNo) {
        setIdentityNo(nricNo);
    }
}
