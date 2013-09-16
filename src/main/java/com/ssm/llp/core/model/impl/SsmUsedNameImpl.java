package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmCompanyType;
import com.ssm.llp.core.model.SsmNameType;
import com.ssm.llp.core.model.SsmUsedName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * NAMA LAMA: 1 tahun after change
 *
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Table(name = "SSM_USED_NAME")
@Entity(name = "SsmUsedName")
public class SsmUsedNameImpl extends SsmNameImpl implements SsmUsedName, Serializable {

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "COMPANY_TYPE")
    private SsmCompanyType companyType;

    public SsmUsedNameImpl() {
        setNameType(SsmNameType.USED);
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
