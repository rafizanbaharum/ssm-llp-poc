package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmCompanyType;
import com.ssm.llp.core.model.SsmNameType;
import com.ssm.llp.core.model.SsmReservedName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Table(name = "SSM_RESERVED_NAME")
@Entity(name = "SsmReservedName")
public class SsmReservedNameImpl extends SsmNameImpl implements SsmReservedName, Serializable {

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "COMPANY_TYPE")
    private SsmCompanyType companyType;

    public SsmReservedNameImpl() {
        setNameType(SsmNameType.RESERVED);
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public SsmCompanyType getCompanyType() {
        return companyType;
    }

    public void setCompanyType(SsmCompanyType companyType) {
        this.companyType = companyType;
    }
}
