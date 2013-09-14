package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmCountryName;
import com.ssm.llp.core.model.SsmNameType;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Table(name = "SSM_COUNTRY_NAME")
@Entity(name = "SsmCountryName")
public class SsmCountryNameImpl extends SsmNameImpl implements SsmCountryName, Serializable {

    public SsmCountryNameImpl() {
        setNameType(SsmNameType.COUNTRY);
    }
}
