package com.ssm.llp.core.dao;

import com.ssm.llp.core.model.SsmActor;
import com.ssm.llp.core.model.SsmActorType;
import com.ssm.llp.core.model.SsmUser;

import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/15/13
 */
public interface SsmActorDao {

    // finders
    SsmActor findById(Long id);

    SsmActor findByIdentityNo(String identityNo);

    SsmActor findByNricNo(String nricNo);

    List<SsmActor> find(Integer offset, Integer limit);

    List<SsmActor> find(String filter, Integer offset, Integer limit);

    List<SsmActor> find(SsmActorType type, Integer offset, Integer limit);

    List<SsmActor> find(SsmActorType type, String filter, Integer offset, Integer limit);

    Integer count();

    Integer count(String filter);

    Integer count(SsmActorType type);


    // cruds
    void save(SsmActor actor, SsmUser user);

    void update(SsmActor actor, SsmUser user);

    void deactivate(SsmActor actor, SsmUser user);
}
