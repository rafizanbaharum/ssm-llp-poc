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

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ADDRESS1")
    private String address1;

    @Column(name = "ADDRESS2")
    private String address2;

    @Column(name = "ADDRESS3")
    private String address3;

    @Column(name = "ADDRESS4")
    private String phone;

    @Column(name = "FAX")
    private String fax;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
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

