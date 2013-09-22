package com.ssm.llp.core.model;

import java.util.Date;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
public interface SsmReservedName extends SsmName {

    Date getStartDate();

    void setStartDate(Date startDate);

    Date getEndDate();

    void setEndDate(Date endDate);

    // is waiver needed
    boolean isWaived();

    void setWaived(boolean waived);

    SsmCompanyType getCompanyType();

    void setCompanyType(SsmCompanyType companyType);

}

