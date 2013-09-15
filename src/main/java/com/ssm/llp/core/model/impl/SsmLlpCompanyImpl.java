package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmCompanyType;
import com.ssm.llp.core.model.SsmLlpCompany;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Table(name = "SSM_LLP_COMPANY")
@Entity(name = "SsmLlpCompany")
public class SsmLlpCompanyImpl extends SsmCompanyImpl implements SsmLlpCompany, Serializable {

    public SsmLlpCompanyImpl() {
        setCompanyType(SsmCompanyType.LLP);
    }
}
