package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmNameType;
import com.ssm.llp.core.model.SsmSimilarName;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Table(name = "SSM_SIMILAR_NAME")
@Entity(name = "SsmSimilarName")
public class SsmSimilarNameImpl extends SsmNameImpl implements SsmSimilarName, Serializable {

    @Column(name = "SIMILE")
    private String simile;

    public SsmSimilarNameImpl() {
        setNameType(SsmNameType.SIMILAR);
    }

    public String getSimile() {
        return simile;
    }

    public void setSimile(String simile) {
        this.simile = simile;
    }
}
