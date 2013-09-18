package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.*;
import com.ssm.llp.core.model.SsmPrincipalRole;
import com.ssm.llp.core.model.SsmRoleType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
@Table(name = "SSM_PRINCIPAL_ROLE")
@Entity(name = "SsmPrincipalRole")
public class SsmPrincipalRoleImpl implements SsmPrincipalRole, Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_SSM_PRINCIPAL_ROLE")
    @SequenceGenerator(name = "SEQ_SSM_PRINCIPAL_ROLE", sequenceName = "SEQ_Ssm_PCPL_ROLE", allocationSize = 1)
    private Long id;

    @Column(name = "ROLE_TYPE")
    private SsmRoleType roleType;

    @OneToOne(targetEntity = SsmPrincipalImpl.class)
    @JoinColumn(name = "PRINCIPAL_ID")
    private SsmPrincipal principal;

    @Embedded
    private SsmMetadata metadata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SsmRoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(SsmRoleType roleType) {
        this.roleType = roleType;
    }

    public SsmPrincipal getPrincipal() {
        return principal;
    }

    public void setPrincipal(SsmPrincipal principal) {
        this.principal = principal;
    }

    public SsmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(SsmMetadata metadata) {
        this.metadata = metadata;
    }
}
