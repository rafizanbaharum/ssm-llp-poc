package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.*;
import org.hibernate.search.annotations.*;
import org.hibernate.search.bridge.builtin.EnumBridge;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Indexed
@Table(name = "SSM_COMPANY")
@Entity(name = "SsmCompany")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SsmCompanyImpl implements SsmCompany, Serializable {

    @Id
    @DocumentId
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_SSM_COMPANY")
    @SequenceGenerator(name = "SEQ_SSM_COMPANY", sequenceName = "SEQ_SSM_COMPANY", allocationSize = 1)
    private Long id;

    @Field(index = Index.YES, analyze = Analyze.YES, store = Store.YES)
    @Column(name = "NAME")
    private String name;

    @Field(index = Index.YES, analyze = Analyze.NO, store = Store.YES)
    @FieldBridge(impl = EnumBridge.class)
    @Enumerated(EnumType.ORDINAL)
    @Column(name = "COMPANY_STATUS")
    private SsmCompanyStatus companyStatus;

    @Column(name = "COMPANY_TYPE")
    private SsmCompanyType companyType;

    @OneToMany(targetEntity = SsmCompanyMemberImpl.class, mappedBy = "company", fetch = FetchType.LAZY)
    private List<SsmCompanyMember> members;

    @Embedded
    private SsmMetadata metadata = new SsmMetadata();


    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public SsmCompanyStatus getCompanyStatus() {
        return companyStatus;
    }

    @Override
    public void setCompanyStatus(SsmCompanyStatus companyStatus) {
        this.companyStatus = companyStatus;
    }

    @Override
    public SsmCompanyType getCompanyType() {
        return companyType;
    }

    @Override
    public void setCompanyType(SsmCompanyType companyType) {
        this.companyType = companyType;
    }

    public List<SsmCompanyMember> getMembers() {
        return members;
    }

    public void setMembers(List<SsmCompanyMember> members) {
        this.members = members;
    }

    public SsmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(SsmMetadata metadata) {
        this.metadata = metadata;
    }
}

