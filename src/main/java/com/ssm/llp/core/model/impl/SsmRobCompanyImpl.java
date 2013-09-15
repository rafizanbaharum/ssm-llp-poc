package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmCompanyType;
import com.ssm.llp.core.model.SsmRobCompany;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Table(name = "SSM_ROB_COMPANY")
@Entity(name = "SsmRobCompany")
public class SsmRobCompanyImpl extends SsmCompanyImpl implements SsmRobCompany, Serializable {

    public SsmRobCompanyImpl() {
        setCompanyType(SsmCompanyType.LLP);
    }
}
