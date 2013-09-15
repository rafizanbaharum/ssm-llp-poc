package com.ssm.llp.core.dao.impl;

import com.ssm.llp.core.dao.SsmNameDao;
import com.ssm.llp.core.model.SsmName;
import com.ssm.llp.core.model.SsmNameType;
import com.ssm.llp.core.model.impl.SsmNameImpl;
import org.hibernate.Query;
import org.hibernate.Session;
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
    public List<SsmName> find(String filter) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select n from SsmName n where n.name like :filter");
        query.setString("filter", "%" + filter + "%");
        return (List<SsmName>) query.list();
    }

    @Override
    public List<SsmName> find(SsmNameType type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select n from SsmName n where n.nameType like :nameType");
        query.setInteger("nameType", type.ordinal());
        return (List<SsmName>) query.list();
    }
}
