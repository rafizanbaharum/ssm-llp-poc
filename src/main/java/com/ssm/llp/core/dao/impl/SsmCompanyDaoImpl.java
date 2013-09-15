package com.ssm.llp.core.dao.impl;

import com.ssm.llp.core.dao.SsmCompanyDao;
import com.ssm.llp.core.model.*;
import com.ssm.llp.core.model.impl.SsmCompanyImpl;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Repository("companyDao")
public class SsmCompanyDaoImpl extends DaoSupport<Long, SsmCompany, SsmCompanyImpl> implements SsmCompanyDao, Serializable {

    @Override
    public SsmCompany findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select n from SsmCompany n where n.id = :id");
        query.setLong("id", id);
        return (SsmCompany) query.uniqueResult();
    }

    @Override
    public List<SsmCompany> find(String filter) {
        Session session = sessionFactory.getCurrentSession();
        FullTextSession fullTextSession = Search.getFullTextSession(sessionFactory.getCurrentSession());
        QueryBuilder builder = fullTextSession
                .getSearchFactory()
                .buildQueryBuilder().forEntity(SsmCompanyImpl.class).get();
        org.apache.lucene.search.Query termQuery = builder.keyword()
                .onField("Company")
                .matching(filter)
                .createQuery();
        FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(termQuery, SsmCompanyImpl.class);
        return (List<SsmCompany>) fullTextQuery.list();
    }

    @Override
    public List<SsmCompany> findByOwner(SsmCompanyType companyType, SsmUser owner) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select n from SsmCompany n where " +
                "n.metadata.creator = :creatorId " +
                "and n.companyType=:companyType");
        query.setInteger("companyType", companyType.ordinal());
        query.setLong("creatorId", owner.getId());
        return (List<SsmCompany>) query.list();
    }

}
