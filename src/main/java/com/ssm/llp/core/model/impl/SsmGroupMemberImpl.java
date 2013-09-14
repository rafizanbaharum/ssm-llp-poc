package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmGroup;
import com.ssm.llp.core.model.SsmGroupMember;
import com.ssm.llp.core.model.SsmMetadata;
import com.ssm.llp.core.model.SsmPrincipal;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
@Table(name = "SSM_GROUP_MEMBER")
@Entity(name = "SsmGroupMember")
public class SsmGroupMemberImpl implements SsmGroupMember {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_SSM_GROUP_MEMBER")
    @SequenceGenerator(name = "SEQ_SSM_GROUP_MEMBER", sequenceName = "SEQ_Ssm_GROP_MMBR", allocationSize = 1)
    private Long id;

    @OneToOne(targetEntity = SsmGroupImpl.class)
    @JoinColumn(name = "GROUP_ID")
    private SsmGroup group;

    @OneToOne(targetEntity = SsmPrincipalImpl.class)
    @JoinColumn(name = "MEMBER_ID")
    private SsmPrincipal member;

    @Embedded
    private SsmMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SsmGroup getGroup() {
        return group;
    }

    public void setGroup(SsmGroup group) {
        this.group = group;
    }

    public SsmPrincipal getMember() {
        return member;
    }

    public void setMember(SsmPrincipal member) {
        this.member = member;
    }

    public SsmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(SsmMetadata metadata) {
        this.metadata = metadata;
    }
}
