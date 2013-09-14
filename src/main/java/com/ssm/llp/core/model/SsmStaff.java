package com.ssm.llp.core.model;

import com.ssm.llp.core.model.SsmActor;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
public interface SsmStaff extends SsmActor {

    String getStaffNo();

    void setStaffNo(String StaffNo);

    String getNricNo();

    void setNricNo(String nricNo);
}
