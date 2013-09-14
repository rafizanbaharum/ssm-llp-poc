package com.ssm.llp.core.model;

import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
public interface SsmGroup extends SsmPrincipal {

    Set<SsmGroupMember> getMembers();

    void setMembers(Set<SsmGroupMember> members);

}
