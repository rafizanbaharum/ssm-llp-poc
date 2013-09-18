package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmControlledName;
import com.ssm.llp.core.model.SsmNameType;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Table(name = "SSM_CONTROLLED_NAME")
@Entity(name = "SsmControlledName")
public class SsmControlledNameImpl extends SsmNameImpl implements SsmControlledName, Serializable {

    public SsmControlledNameImpl() {
        setNameType(SsmNameType.CONTROLLED);
    }
}
