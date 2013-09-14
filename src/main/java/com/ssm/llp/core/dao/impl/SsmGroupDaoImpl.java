package com.ssm.llp.core.dao.impl;

import com.ssm.llp.core.dao.SsmGroupDao;
import com.ssm.llp.core.exception.LockedGroupException;
import com.ssm.llp.core.exception.RecursiveGroupException;
import com.ssm.llp.core.model.*;
import com.ssm.llp.core.model.impl.SsmGroupImpl;
import com.ssm.llp.core.model.impl.SsmGroupMemberImpl;
import org.apache.commons.lang.Validate;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 */
@Repository("groupDao")
public class SsmGroupDaoImpl extends DaoSupport<Long, SsmGroup, SsmGroupImpl> implements SsmGroupDao {

    private static final Logger log = Logger.getLogger(SsmGroupDaoImpl.class);
    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public SsmGroup findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (SsmGroup) session.get(SsmGroupImpl.class, id);
    }

    @Override
    public List<SsmGroup> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from SsmGroup g order by g.name");
        return (List<SsmGroup>) query.list();
    }

    @Override
    public List<String> findAllGroupName() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g.name from SsmGroup g");
        return (List<String>) query.list();
    }

    @Override
    public SsmGroup findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from SsmGroup g where g.name = :name");
        query.setString("name", name);
        return (SsmGroup) query.uniqueResult();
    }

    @Override
    public List<SsmPrincipal> findMembers(SsmGroup group) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select gm.principal from SsmGroupMember gm where " +
                "gm.group = :group " +
                "order by gm.principal.name");
        query.setEntity("group", group);
        return (List<SsmPrincipal>) query.list();
    }

    /**
     * XXX: ClassCastException issues
     * XXX: select gm.principal wil get you abstract SsmPrincipal
     * XXX: not extension classes
     *
     * @param group
     * @param type
     * @return
     */
    @Override
    public List<SsmPrincipal> findMembers(SsmGroup group, SsmPrincipalType type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = null;

        String selectGroup = "select g from SsmGroup g where " +
                "id in (select gm.principal.id from SsmGroupMember gm where " +
                "gm.group = :group " +
                "and gm.principal.principalType = :type )" +
                "order by g.name";
        String selectUser = "select u from SsmUser u where " +
                "id in (select gm.principal.id from SsmGroupMember gm where " +
                "gm.group = :group " +
                "and gm.principal.principalType = :type )" +
                "order by u.name";
        switch (type) {
            case USER:
                query = session.createQuery(selectUser);
                break;
            case GROUP:
                query = session.createQuery(selectGroup);
                break;
        }
        query.setEntity("group", group);
        query.setInteger("type", type.ordinal());
        return (List<SsmPrincipal>) query.list();
    }

    @Override
    public List<SsmGroup> findPrincipalGroups(SsmPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select gm.group from SsmGroupMember gm inner join gm.principal where " +
                "gm.principal = :principal");
        query.setEntity("principal", principal);
        return (List<SsmGroup>) query.list();
    }

    @Override
    public List<SsmPrincipal> findMembers(SsmGroup group, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select gm.principal from SsmGroupMember gm where " +
                "gm.group = :group " +
                "order by gm.principal.name");
        query.setEntity("group", group);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<SsmPrincipal>) query.list();
    }

    @Override
    public List<SsmGroup> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from SsmGroup g order by g.name");
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<SsmGroup>) query.list();
    }


    @Override
    public List<SsmGroup> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct g from SsmGroup g where " +
                "g.name like upper(:filter) " +
                "and g.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", SsmMetaState.ACTIVE.ordinal());
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<SsmGroup>) query.list();
    }

    @Override
    public List<SsmGroup> findParentGroup(SsmGroup group) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from SsmGroup g inner join g.groupMembers m where m.principal = :group");
        query.setEntity("group", group);
        return (List<SsmGroup>) query.list();
    }

    @Override
    public Set<SsmGroup> findHierarchicalGroupAsNative(SsmPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        String sqlQuery = "SELECT /*+ USE_NL(U) IGNORE_OPTIM_EMBEDDED_HINTS */ CONNECT_BY_ROOT p.id parent " +
                "FROM fs_principal p, fs_group g, fs_group_member m, fs_principal u " +
                "WHERE p.id = g.id " +
                "AND m.group_id = g.id " +
                "AND m.principal_id = u.id " +
                "and u.name = '" + principal.getName() + "' " +
                "connect by prior m.principal_id = m.group_id";
        sqlQuery = "SELECT DISTINCT parent FROM ( " + sqlQuery + ")";
        SQLQuery query = session.createSQLQuery(sqlQuery);
        query.addScalar("parent", LongType.INSTANCE);
        List<Long> results = (List<Long>) query.list();
        Set<SsmGroup> groups = new HashSet<SsmGroup>();
        for (Long result : results) {
            groups.add(findById(result));
        }
        return groups;
    }

    @Override
    public List<String> findHierarchicalGroupRoleAsNative(SsmPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        String sqlQuery = "SELECT /*+ USE_HASH(U,M,G) ORDERED IGNORE_OPTIM_EMBEDDED_HINTS */ 'X' \n" +
                "FROM fs_principal p, " +
                "fs_group g, " +
                "fs_group_member m, " +
                "fs_principal u " +
                "WHERE p.id = g.id " +
                "AND m.group_id = g.id " +
                "AND m.principal_id = u.id " +
                "and u.name = '" + principal.getName() + "' " +
                "AND CONNECT_BY_ROOT p.id = FS_GROUP_ROLE.group_id \n" +
                "connect by prior m.principal_id = m.group_id";
        sqlQuery = "select role from fs_group_role where exists ( " + sqlQuery + " )";
        SQLQuery query = session.createSQLQuery(sqlQuery);
        query.addScalar("role", StringType.INSTANCE);
        return (List<String>) query.list();
    }

    @Override
    public Set<SsmGroup> findHierarchicalGroupAsView(SsmPrincipal principal) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(g) from SsmGroup g where " +
                "g.metadata.state = :state");
        query.setInteger("state", SsmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(g) from SsmGroup g where " +
                "g.name like upper(:filter) " +
                "and g.metadata.state = :state");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setInteger("state", SsmMetaState.ACTIVE.ordinal());
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isMemberOf(SsmGroup group, SsmPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(g) from SsmGroupMember g where " +
                "g.group = :group " +
                "and g.principal = :principal");
        query.setEntity("group", group);
        query.setEntity("principal", principal);
        return ((Long) query.uniqueResult()).intValue() >= 1;
    }

    @Override
    public SsmGroupMember findGroupMember(SsmGroup group, SsmPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from SsmGroupMember g where " +
                "g.group = :group " +
                "and g.principal = :principal");
        query.setEntity("group", group);
        query.setEntity("principal", principal);
        return (SsmGroupMember) query.uniqueResult();
    }

// =============================================================================
    // CRUD METHODS
    // =============================================================================

    @Override
    public void addMember(SsmGroup group, SsmPrincipal member, SsmUser user) throws RecursiveGroupException, LockedGroupException {

        // validate
        Validate.notNull(group, "Group should not be null");
        Validate.notNull(member, "Group member should not be null");

        // check locked group
        if (group.isLocked()) {
            log.error("Group is locked");
            throw new LockedGroupException("Locked group");
        }

        // check recursive add
        if (member instanceof SsmGroup) {
            if (isInRecursive(group, (SsmGroup) member))
                throw new RecursiveGroupException("Recursive user group detected");
        }

        // session
        Session session = sessionFactory.getCurrentSession();

        // populate
        SsmGroupMember groupMember = new SsmGroupMemberImpl();
        groupMember.setGroup(group);
        groupMember.setMember(member);

        // prepare metadata
        SsmMetadata metadata = new SsmMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        groupMember.setMetadata(metadata);
        session.save(groupMember);
    }

    @Override
    public void addMembers(SsmGroup group, List<SsmPrincipal> principals, SsmUser user) throws RecursiveGroupException, LockedGroupException {
        List<SsmPrincipal> principalGroups = findMembers(group);
        List<SsmPrincipal> newPrincipals = new ArrayList<SsmPrincipal>();

        for (SsmPrincipal principal : principals) {
            newPrincipals.add(principal);
        }

        for (SsmPrincipal principalGroup : principalGroups) {
            if (!newPrincipals.contains(principalGroup)) {
                removeMember(group, principalGroup);
            }
        }

        for (SsmPrincipal newGroup : newPrincipals) {
            if (!principalGroups.contains(newGroup)) {
                addMember(group, newGroup, user);
            }
        }
    }

    @Override
    public void removeMember(SsmGroup group, SsmPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from SsmGroupMember g where g.group = :group and g.principal = :principal");
        query.setEntity("group", group);
        query.setEntity("principal", principal);
        SsmGroupMember groupMember = (SsmGroupMember) query.uniqueResult();
        session.delete(groupMember);
    }

    private boolean isInRecursive(SsmGroup parent, SsmGroup child) {
        Set<SsmGroup> hierarchicalGroup = findHierarchicalGroupAsNative(parent);
        return !hierarchicalGroup.add(child);
    }
}
