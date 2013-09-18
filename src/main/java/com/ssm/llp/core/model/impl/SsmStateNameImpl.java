package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmNameType;
import com.ssm.llp.core.model.SsmStateName;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Table(name = "SSM_STATE_NAME")
@Entity(name = "SsmStateName")
public class SsmStateNameImpl extends SsmNameImpl implements SsmStateName, Serializable {

    public SsmStateNameImpl() {
        setNameType(SsmNameType.STATE);
    }
}
