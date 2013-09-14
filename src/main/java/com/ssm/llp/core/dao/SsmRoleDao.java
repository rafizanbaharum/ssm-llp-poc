package com.ssm.llp.core.dao;

import com.ssm.llp.core.model.SsmPrincipal;
import com.ssm.llp.core.model.SsmRoleType;
import com.ssm.llp.core.model.SsmUser;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 */
public interface SsmRoleDao {

    void grant(SsmPrincipal principal, SsmRoleType roleType, SsmUser user);

    void grant(SsmPrincipal principal, SsmRoleType[] roleTypes, SsmUser user);

    void revoke(SsmPrincipal principal, SsmRoleType roleType, SsmUser user);

    void revoke(SsmPrincipal principal, SsmRoleType[] roleTypes, SsmUser user);

    void revokeAll(SsmPrincipal principal, SsmUser user);

    void overwrite(SsmPrincipal principal, SsmRoleType roleType, SsmUser user);

    void overwrite(SsmPrincipal principal, SsmRoleType[] roleTypes, SsmUser user);

    void update(SsmPrincipal principal, SsmRoleType[] roleTypes, SsmUser user);


}
