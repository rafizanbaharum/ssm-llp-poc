package com.ssm.llp.core.dao;

import com.ssm.llp.core.exception.LockedGroupException;
import com.ssm.llp.core.exception.RecursiveGroupException;
import com.ssm.llp.core.model.*;

import java.util.List;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 */
public interface SsmGroupDao {

    // finders

    SsmGroup findById(Long id);

    SsmGroup findByName(String name);

    List<SsmGroup> findAll();

    List<String> findAllGroupName();

    List<SsmPrincipal> findMembers(SsmGroup group);

    List<SsmPrincipal> findMembers(SsmGroup group, SsmPrincipalType type);

    List<SsmGroup> findPrincipalGroups(SsmPrincipal principal);

    List<SsmPrincipal> findMembers(SsmGroup group, Integer offset, Integer limit);

    List<SsmGroup> find(Integer offset, Integer limit);

    List<SsmGroup> find(String filter, Integer offset, Integer limit);

    List<SsmGroup> findParentGroup(SsmGroup group);

    Set<SsmGroup> findHierarchicalGroupAsNative(SsmPrincipal principal);

    List<String> findHierarchicalGroupRoleAsNative(SsmPrincipal principal);

    Set<SsmGroup> findHierarchicalGroupAsView(SsmPrincipal principal);

    SsmGroupMember findGroupMember(SsmGroup group, SsmPrincipal principal);

    Integer count();

    Integer count(String filter);

    //helpers

    boolean isMemberOf(SsmGroup group, SsmPrincipal principal);


    // cruds

    void save(SsmGroup group, SsmUser user);

    void update(SsmGroup group, SsmUser user);

    void deactivate(SsmGroup group, SsmUser user);

    void remove(SsmGroup group, SsmUser user) throws LockedGroupException;

    void addMember(SsmGroup group, SsmPrincipal principal, SsmUser user) throws RecursiveGroupException, LockedGroupException;

    void addMembers(SsmGroup group, List<SsmPrincipal> principals, SsmUser user) throws RecursiveGroupException, LockedGroupException;

    void removeMember(SsmGroup group, SsmPrincipal principal) throws LockedGroupException;

}
