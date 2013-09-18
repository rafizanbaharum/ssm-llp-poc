package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmGazettedName;
import com.ssm.llp.core.model.SsmNameType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Table(name = "SSM_PLURAL_NAME")
@Entity(name = "SsmPluralName")
public class SsmPluralNameImpl extends SsmNameImpl implements SsmGazettedName, Serializable {

    @Column(name = "PLURAL")
    private String plural;

    public SsmPluralNameImpl() {
        setNameType(SsmNameType.PLURAL);
    }

    public String getPlural() {
        return plural;
    }

    public void setPlural(String plural) {
        this.plural = plural;
    }
}
