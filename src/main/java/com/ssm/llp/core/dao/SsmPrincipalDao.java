package com.ssm.llp.core.dao;

import com.ssm.llp.core.model.SsmPrincipalType;
import com.ssm.llp.core.exception.RecursiveGroupException;
import com.ssm.llp.core.model.SsmPrincipal;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 9/11/13
 */
public interface SsmPrincipalDao {

    SsmPrincipal findById(Long id);

    SsmPrincipal findByName(String name);

    List<SsmPrincipal> findAllPrincipals();

    List<SsmPrincipal> findPrincipals(String filter);

    List<SsmPrincipal> findPrincipals(String filter, SsmPrincipalType type);

    List<SsmPrincipal> findPrincipals(Integer offset, Integer limit);

    Set<GrantedAuthority> loadEffectiveAuthorities(SsmPrincipal principal) throws RecursiveGroupException;

}
