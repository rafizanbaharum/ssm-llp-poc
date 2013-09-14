package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmFilterType;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Table(name = "SSM_POISON_FILTER")
@Entity(name = "SsmPoisonFilter")
public class SsmPoisonFilterImpl extends SsmFilterImpl implements Serializable {

    public SsmPoisonFilterImpl() {
        setFilterType(SsmFilterType.POISON);
    }
}
