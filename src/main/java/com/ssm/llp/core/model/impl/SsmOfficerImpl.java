package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmActorType;
import com.ssm.llp.core.model.SsmOfficer;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
@Table(name = "SSM_OFFICER")
@Entity(name = "SsmOfficer")
public class SsmOfficerImpl extends SsmActorImpl implements SsmOfficer {

    public SsmOfficerImpl() {
        setActorType(SsmActorType.OFFICER);
    }

    public String getNricNo() {
        return getIdentityNo();
    }

    public void setNricNo(String nricNo) {
        setIdentityNo(nricNo);
    }
}
