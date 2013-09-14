package com.ssm.llp.core.dao;

import com.ssm.llp.core.model.SsmActor;
import com.ssm.llp.core.model.SsmGroup;
import com.ssm.llp.core.model.SsmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 */
public interface SsmUserDao {

    SsmUser findById(Long id);

    SsmUser findByUsername(String username);

    SsmUser findByActor(SsmActor actor);

    SsmUser findByRealName(String realname);

    List<SsmUser> find(Integer offset, Integer limit);

    List<SsmUser> find(String filter, Integer offset, Integer limit);

    List<SsmGroup> findUserGroups(SsmUser user);

    Integer count();

    Integer count(String filter);

    boolean isExists(String username);

    // cruds

    void save(SsmUser suser, SsmUser user);

    void update(SsmUser suser, SsmUser user);

    void deactivate(SsmUser suser, SsmUser user);

    void remove(SsmUser suser, SsmUser user);

}
