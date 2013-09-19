package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmFilterType;
import com.ssm.llp.core.model.SsmSearchFilter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Table(name = "SSM_SEARCH_FILTER")
@Entity(name = "SsmSearchFilter")
public class SsmSearchFilterImpl extends SsmFilterImpl implements SsmSearchFilter, Serializable {


    public SsmSearchFilterImpl() {
        setFilterType(SsmFilterType.SEARCH);
    }

}
