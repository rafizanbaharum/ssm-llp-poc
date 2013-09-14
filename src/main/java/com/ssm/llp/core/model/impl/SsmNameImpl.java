package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmMetadata;
import com.ssm.llp.core.model.SsmName;
import com.ssm.llp.core.model.SsmNameType;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Table(name = "SSM_NAME")
@Entity(name = "SsmName")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SsmNameImpl implements SsmName, Serializable{

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_SSM_NAME")
    @SequenceGenerator(name = "SEQ_SSM_NAME", sequenceName = "SEQ_SSM_NAME", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "NAME_TYPE")
    private SsmNameType nameType;

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

    public SsmNameType getNameType() {
        return nameType;
    }

    public void setNameType(SsmNameType nameType) {
        this.nameType = nameType;
    }

    public SsmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(SsmMetadata metadata) {
        this.metadata = metadata;
    }
}
