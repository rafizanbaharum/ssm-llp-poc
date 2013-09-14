package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmNameType;
import com.ssm.llp.core.model.SsmSymbolName;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Table(name = "SSM_SYMBOL_NAME")
@Entity(name = "SsmSymbolName")
public class SsmSymbolNameImpl extends SsmNameImpl implements SsmSymbolName, Serializable{

    public SsmSymbolNameImpl() {
        setNameType(SsmNameType.SYMBOL);
    }
}
