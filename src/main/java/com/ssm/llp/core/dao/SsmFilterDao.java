package com.ssm.llp.core.dao;

import com.ssm.llp.core.model.SsmFilter;
import com.ssm.llp.core.model.SsmFilterType;
import com.ssm.llp.core.model.SsmUser;
import com.ssm.llp.core.model.impl.SsmFilterImpl;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
public interface SsmFilterDao {

    // finders
    SsmFilterImpl findById(Long id);

    SsmFilterImpl findByName(String name);

    List<SsmFilterImpl> findFilters();

    List<SsmFilterImpl> findFilters(SsmFilterType type);

    // cruds

    void save(SsmFilter filter, SsmUser user);

    void update(SsmFilter filter, SsmUser user);

    void deactivate(SsmFilter filter, SsmUser user);

    void remove(SsmFilter filter, SsmUser user);

}
