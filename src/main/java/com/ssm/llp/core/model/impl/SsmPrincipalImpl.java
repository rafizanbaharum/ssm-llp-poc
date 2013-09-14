package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmMetadata;
import com.ssm.llp.core.model.SsmPrincipalRole;
import com.ssm.llp.core.model.SsmPrincipalType;

import javax.persistence.*;
import java.util.Set;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
@Table(name = "SSM_PRINCIPAL")
@Entity(name = "SsmPrincipal")
@Inheritance(strategy = InheritanceType.JOINED)
public class SsmPrincipalImpl {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_SSM_PRINCIPAL")
    @SequenceGenerator(name = "SEQ_SSM_PRINCIPAL", sequenceName = "SEQ_SSM_PRINCIPAL", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LOCKED")
    private boolean locked;

    @Enumerated(value = EnumType.ORDINAL)
    @Column(name = "PRINCIPAL_TYPE")
    private SsmPrincipalType principalType;

    @OneToMany(targetEntity = SsmPrincipalRoleImpl.class, mappedBy = "principal", fetch = FetchType.EAGER)
    private Set<SsmPrincipalRole> roles;

    @Embedded
    private SsmMetadata metadata = new SsmMetadata();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public SsmPrincipalType getPrincipalType() {
        return principalType;
    }

    public void setPrincipalType(SsmPrincipalType principalType) {
        this.principalType = principalType;
    }

    public Set<SsmPrincipalRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<SsmPrincipalRole> roles) {
        this.roles = roles;
    }

    public SsmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(SsmMetadata metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "SsmPrincipalImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + locked +
                '}';
    }
}
