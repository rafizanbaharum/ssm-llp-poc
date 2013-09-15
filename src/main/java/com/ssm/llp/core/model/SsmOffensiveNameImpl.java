package com.ssm.llp.core.model;

import com.ssm.llp.core.model.impl.SsmNameImpl;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Table(name = "SSM_OFFENSIVE_NAME")
@Entity(name = "SsmOffensiveName")
public class SsmOffensiveNameImpl extends SsmNameImpl implements SsmOffensiveName, Serializable {
    public SsmOffensiveNameImpl() {
        setNameType(SsmNameType.OFFENSIVE);
    }
}
