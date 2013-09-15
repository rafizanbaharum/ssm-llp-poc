package com.ssm.llp.core.dao;

import com.ssm.llp.core.model.SsmFilter;
import com.ssm.llp.core.model.SsmFilterType;
import com.ssm.llp.core.model.SsmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
public interface SsmFilterDao {

    // finders
    SsmFilter findById(Long id);

    SsmFilter findByName(String name);

    List<SsmFilter> find();

    List<SsmFilter> find(SsmFilterType type);

    // cruds

    void save(SsmFilter filter, SsmUser user);

    void update(SsmFilter filter, SsmUser user);

    void deactivate(SsmFilter filter, SsmUser user);

    void remove(SsmFilter filter, SsmUser user);

}
