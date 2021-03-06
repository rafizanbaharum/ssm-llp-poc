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

    SsmName findByName(String name);

    List<SsmName> find();

    List<SsmName> find(String filter);

    List<SsmName> find(SsmNameType type);

    List<SsmName> find(int type);

    List<SsmName> findByOwner(SsmNameType type, SsmUser owner);

    String[] getStates();

    String[] getCountries();


    // helpers
    boolean hasName(String name);

    boolean hasName(String name, SsmNameType typeSsm);

    boolean hasName(String name, int type);

    boolean hasPlural(String name);

    boolean hasSimilar(String name);

    String findPluralOrOriginal(String name);

    String[] findSimilarOrOriginal(String name);

    String[] findInstrName(String name, SsmNameType nameType);

    String[] findInstrName(String name, int nameType);

    // cruds

    void save(SsmName name, SsmUser user);

    void update(SsmName name, SsmUser user);

    void deactivate(SsmName name, SsmUser user);

    void remove(SsmName name, SsmUser user);

}
