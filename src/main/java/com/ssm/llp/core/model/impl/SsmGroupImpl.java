package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmGroup;
import com.ssm.llp.core.model.SsmGroupMember;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
@Table(name = "Ssm_GROUP")
@Entity(name = "SsmGroup")
public class SsmGroupImpl extends SsmPrincipalImpl implements SsmGroup {

    @OneToMany(targetEntity = SsmGroupMemberImpl.class, mappedBy = "group")
    Set<SsmGroupMember> members;

    public Set<SsmGroupMember> getMembers() {
        return members;
    }

    public void setMembers(Set<SsmGroupMember> members) {
        this.members = members;
    }
}
