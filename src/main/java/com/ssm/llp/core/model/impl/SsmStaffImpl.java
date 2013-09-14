package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmActorType;
import com.ssm.llp.core.model.SsmStaff;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
@Table(name = "Ssm_STAFF")
@Entity(name = "SsmStaff")
public class SsmStaffImpl extends SsmActorImpl implements SsmStaff {

    public SsmStaffImpl() {
        setActorType(SsmActorType.STAFF);
    }

    public String getStaffNo() {
        return getIdentityNo();
    }

    public void setStaffNo(String StaffNo) {
        setIdentityNo(StaffNo);
    }
}
