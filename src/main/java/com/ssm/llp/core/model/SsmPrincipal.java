package com.ssm.llp.core.model;

import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
public interface SsmPrincipal extends SsmMetaObject {

    String getName();

    void setName(String name);

    boolean isLocked();

    void setLocked(boolean locked);

    SsmPrincipalType getPrincipalType();

    void setPrincipalType(SsmPrincipalType principalType);

    Set<SsmPrincipalRole> getRoles();

    void setRoles(Set<SsmPrincipalRole> roles);

}

