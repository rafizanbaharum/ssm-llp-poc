package com.ssm.llp.core.dao.impl;

import com.ssm.llp.core.dao.SsmNameDao;
import com.ssm.llp.core.model.SsmName;
import com.ssm.llp.core.model.SsmNameType;
import com.ssm.llp.core.model.SsmPluralName;
import com.ssm.llp.core.model.SsmUser;
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
    public SsmName findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select n from SsmName n where n.id = :id");
        query.setLong("id", id);
        return (SsmNameImpl) query.uniqueResult();
    }

    @Override
    public SsmName findByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select n from SsmName n where n.name = :name");
        query.setString("name", name);
        return (SsmNameImpl) query.uniqueResult();
    }

    @Override
    public boolean hasName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(n) from SsmName n where " +
                "n.name = :name ");
        query.setString("name", name);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasName(String name, SsmNameType typeSsm) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(n) from SsmName n where " +
                "n.name = :name and n.nameType = :nameType");
        query.setString("name", name);
        query.setInteger("nameType", typeSsm.ordinal());
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasName(String name, int type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(n) from SsmName n where " +
                "n.name = :name and n.nameType = :nameType");
        query.setString("name", name);
        query.setInteger("nameType", type);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasPlural(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(n) from SsmPluralName n where " +
                "n.name = :name");
        query.setString("name", name);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    @Override
    public boolean hasSimilar(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select count(n) from SsmSimilarName n where " +
                "n.name = :name");
        query.setString("name", name);
        return 0 < ((Long) query.uniqueResult()).intValue();
    }

    public String findPluralOrOriginal(String name) {
        if (hasPlural(name))
            return ((SsmPluralName) findByName(name)).getPlural();
        else return name;
    }

    public String[] findSimilarOrOriginal(String name) {
        if (hasSimilar(name)) {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("select n.simile from SsmSimilarName n where n.name = :name");
            query.setString("name", name);
            List<String> list = (List<String>) query.list();
            list.add(name);
            return list.toArray(new String[]{});
        } else
            return new String[]{name};
    }

    @Override
    public List<SsmName> find() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select n from SsmName n order by n.name");
        return (List<SsmName>) query.list();
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
        Query query = session.createQuery("select n from SsmName n where n.nameType = :nameType order by n.name");
        query.setInteger("nameType", type.ordinal());
        return (List<SsmName>) query.list();
    }


    @Override
    public List<SsmName> find(int type) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select n from SsmName n where n.nameType = :nameType");
        query.setInteger("nameType", type);
        return (List<SsmName>) query.list();
    }

    @Override
    public List<SsmName> findByOwner(SsmNameType nameType, SsmUser owner) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select n from SsmName n where n.metadata.creator = :creatorId " +
                "and n.nameType=:nameType");
        query.setInteger("nameType", nameType.ordinal());
        query.setLong("creatorId", owner.getId());
        return (List<SsmName>) query.list();
    }

    @Override
    public String[] getStates() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select n.name from SsmName n where n.nameType = :nameType");
        query.setInteger("nameType", SsmNameType.STATE.ordinal());
        List<String> list = (List<String>) query.list();
        return list.toArray(new String[]{});
    }

    @Override
    public String[] getCountries() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select n.name from SsmName n where n.nameType = :nameType");
        query.setInteger("nameType", SsmNameType.COUNTRY.ordinal());
        List<String> list = (List<String>) query.list();
        return list.toArray(new String[]{});
    }
}
