package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmNameType;

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
public class SsmReservedNameImpl extends SsmNameImpl implements Serializable {

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    public SsmReservedNameImpl() {
        setNameType(SsmNameType.RESERVED);
    }
}
