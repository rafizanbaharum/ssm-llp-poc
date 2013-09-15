package com.ssm.llp.core.dao;

import com.ssm.llp.core.model.SsmName;
import com.ssm.llp.core.model.SsmNameType;
import com.ssm.llp.core.model.SsmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
public interface SsmNameDao {

    // finders

    SsmName findById(Long id);

    List<SsmName> find(String filter);

    List<SsmName> find(SsmNameType type);

    List<SsmName> findByOwner(SsmNameType type, SsmUser owner);


    // helpers
    boolean hasName(String name);

    boolean hasName(String name, SsmNameType typeSsm);

    boolean hasName(String name, int type);

    // cruds

    void save(SsmName name, SsmUser user);

    void update(SsmName name, SsmUser user);

    void deactivate(SsmName name, SsmUser user);

    void remove(SsmName name, SsmUser user);

}
