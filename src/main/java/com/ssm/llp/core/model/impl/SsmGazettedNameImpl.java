package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmNameType;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Table(name = "SSM_GAZETTED_NAME")
@Entity(name = "SsmGazettedName")
public class SsmGazettedNameImpl extends SsmNameImpl implements Serializable {

    public SsmGazettedNameImpl() {
        setNameType(SsmNameType.GAZETTED);
    }
}
