package com.ssm.llp.core.dao.impl;

import com.ssm.llp.core.dao.SsmCompanyMemberDao;
import com.ssm.llp.core.model.*;
import com.ssm.llp.core.model.impl.SsmCompanyMemberImpl;
import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/16/13
 */
@Repository("companyMemberDao")
public class SsmCompanyMemberDaoImpl extends DaoSupport<Long, SsmCompanyMember, SsmCompanyMemberImpl>
        implements SsmCompanyMemberDao {

    private static final Logger log = Logger.getLogger(SsmCompanyMemberDaoImpl.class);

    // =============================================================================
    // FINDER METHODS
    // =============================================================================

    @Override
    public SsmCompanyMember findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (SsmCompanyMember) session.get(SsmCompanyMemberImpl.class, id);
    }

    @Override
    public List<SsmCompanyMember> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select cca from SsmCompanyMember cca");
        return (List<SsmCompanyMember>) query.list();
    }

    @Override
    public List<SsmCompanyMember> find(Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select cca from SsmCompanyMember cca");
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<SsmCompanyMember>) query.list();
    }

    @Override
    public List<SsmCompanyMember> find(SsmCompany company) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select cca from SsmCompanyMember cca where cca.company = :company");
        query.setEntity("company", company);
        return (List<SsmCompanyMember>) query.list();
    }

    @Override
    public List<SsmCompanyMember> find(SsmCompany company, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select cca from SsmCompanyMember cca where cca.company = :company");
        query.setEntity("company", company);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<SsmCompanyMember>) query.list();
    }

    @Override
    public List<SsmUser> findUsers(SsmCompany company) {
        return null;
    }

    @Override
    public List<SsmPrincipal> findMembers(SsmCompany company) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select cca.principal from SsmCompanyMember cca where " +
                "cca.company = :company order by cca.principal.name");
        query.setEntity("company", company);
        return (List<SsmPrincipal>) query.list();
    }

    @Override
    public List<SsmCompanyMember> find(String filter, Integer offset, Integer limit) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select cca from SsmCompanyMember cca where " +
                "cca.company.code like upper(:filter) " +
                "or upper(cca.company.description) like upper(:filter) ");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return (List<SsmCompanyMember>) query.list();
    }


    @Override
    public Integer count() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(cca) from SsmCompanyMember cca");
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(cca) from SsmCompanyMember cca where " +
                "cca.company.code like upper(:filter) " +
                "or cca.company.description " +
                "like upper(:filter)");
        query.setString("filter", WILDCARD + filter + WILDCARD);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public Integer count(SsmCompany company) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(cca) from SsmCompanyMember cca where " +
                "cca.company = :company ");
        query.setEntity("company", company);
        return ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean isExist(SsmCompany company, SsmPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(cca) from SsmCompanyMember cca where " +
                "cca.principal = :principal " +
                "and cca.company = :company ");
        query.setEntity("company", company);
        query.setEntity("principal", principal);
        return ((Long) query.uniqueResult()) > 0;

    }

    // =============================================================================
    // CRUD METHODS
    // =============================================================================

    /**
     * @param company
     * @param principal
     * @param user
     */
    public SsmCompanyMember addMember(SsmCompany company, SsmPrincipal principal, SsmUser user) {
        Assert.notNull(principal);

        Session session = sessionFactory.getCurrentSession();
        SsmCompanyMember actor = new SsmCompanyMemberImpl();
        actor.setCompany(company);
        ((SsmCompanyMemberImpl) actor).setPrincipal(principal);

        // prepare metadata
        SsmMetadata metadata = new SsmMetadata();
        metadata.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        metadata.setCreator(user.getId());
        actor.setMetadata(metadata);

        session.save(actor);
        return actor;
    }

    @Override
    public void removeMember(SsmCompany company, SsmPrincipal principal, SsmUser user) {
        throw new UnsupportedOperationException("belum siap");
    }

    @Override
    public void removeMember(SsmCompany company, SsmPrincipal principal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select g from SsmCompanyMember g where g.company = :company " +
                "and g.principal = :principal");
        query.setEntity("company", company);
        query.setEntity("principal", principal);
        SsmCompanyMember companyMember = (SsmCompanyMember) query.uniqueResult();
        session.delete(companyMember);
    }

    @Override
    public void removeMembers(SsmCompany company, List<SsmPrincipal> principals) {
        for (SsmPrincipal principal : principals) {
            removeMember(company, principal);
        }
    }

    public void addMembers(SsmCompany company, List<SsmPrincipal> principals, SsmUser user) {
        for (SsmPrincipal principal : principals) {
            addMember(company, principal, user);
        }
    }

    @Override
    public void removeMembers(SsmCompany company, List<SsmPrincipal> principals, SsmUser user) {
        throw new UnsupportedOperationException("belum siap");
    }
}
