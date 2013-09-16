package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 9/16/13
 */
@Entity(name = "SsmCompanyMember")
@Table(name = "SSM_COMPANY_MEMBER")
public class SsmCompanyMemberImpl implements SsmCompanyMember, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_SSM_COMPANY_MEMBER")
    @SequenceGenerator(name = "SEQ_SSM_COMPANY_MEMBER", sequenceName = "SEQ_SSM_COMPANY_MEMBER", allocationSize = 1)
    private Long id;

    @Column(name = "ROLE_TYPE")
    private SsmCompanyRoleType roleType;

    @ManyToOne(targetEntity = SsmCompanyImpl.class)
    @JoinColumn(name = "COMPANY_ID")
    private SsmCompany company;

    @ManyToOne(targetEntity = SsmPrincipalImpl.class)
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

    public SsmCompanyRoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(SsmCompanyRoleType roleType) {
        this.roleType = roleType;
    }

    public SsmCompany getCompany() {
        return company;
    }

    public void setCompany(SsmCompany company) {
        this.company = company;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SsmCompanyMemberImpl that = (SsmCompanyMemberImpl) o;

        if (company != null ? !company.equals(that.company) : that.company != null) return false;
        if (principal != null ? !principal.equals(that.principal) : that.principal != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = (company != null ? company.hashCode() : 0);
        result = 31 * result + (principal != null ? principal.hashCode() : 0);
        return result;
    }
}
