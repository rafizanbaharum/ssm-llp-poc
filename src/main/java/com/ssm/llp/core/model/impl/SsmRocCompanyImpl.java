package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmCompanyType;
import com.ssm.llp.core.model.SsmRocCompany;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Table(name = "SSM_ROC_COMPANY")
@Entity(name = "SsmRocCompany")
public class SsmRocCompanyImpl extends SsmCompanyImpl implements SsmRocCompany, Serializable {

    public SsmRocCompanyImpl() {
        setCompanyType(SsmCompanyType.LLP);
    }
}
