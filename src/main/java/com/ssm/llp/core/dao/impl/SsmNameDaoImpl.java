package com.ssm.llp.core.dao.impl;

import com.ssm.llp.core.dao.SsmNameDao;
import com.ssm.llp.core.model.SsmCompany;
import com.ssm.llp.core.model.SsmName;
import com.ssm.llp.core.model.SsmNameType;
import com.ssm.llp.core.model.impl.SsmCompanyImpl;
import com.ssm.llp.core.model.impl.SsmNameImpl;
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
@Repository("nameDao")
public class SsmNameDaoImpl extends DaoSupport<Long, SsmName, SsmNameImpl> implements SsmNameDao, Serializable {

    @Override
    public SsmNameImpl findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select n from SsmName n where n.id = :id");
        query.setLong("id", id);
        return (SsmNameImpl) query.uniqueResult();
    }

    @Override
    public boolean hasName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(n) from Name n where " +
                "n.name = :name ");
        query.setString("name", name);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasName(String name, SsmNameType typeSsm) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(n) from Name n where " +
                "n.name = :name and n.type = :type");
        query.setString("name", name);
        query.setInteger("type", typeSsm.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }


    @Override
    public List<SsmCompany> findRegisteredNames(String filter) {
        Session session = sessionFactory.getCurrentSession();
        FullTextSession fullTextSession = Search.getFullTextSession(sessionFactory.getCurrentSession());
        QueryBuilder builder = fullTextSession
                .getSearchFactory()
                .buildQueryBuilder().forEntity(SsmCompanyImpl.class).get();
        org.apache.lucene.search.Query termQuery = builder.keyword()
                .onField("name")
                .matching(filter)
                .createQuery();
        FullTextQuery fullTextQuery = fullTextSession.createFullTextQuery(termQuery, SsmCompanyImpl.class);
        return (List<SsmCompany>) fullTextQuery.list();
    }
}
