package com.ssm.llp.core.model.impl;


import com.ssm.llp.core.model.SsmFilter;
import com.ssm.llp.core.model.SsmFilterType;
import com.ssm.llp.core.model.SsmMetadata;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@Table(name = "SSM_FILTER")
@Entity(name = "SsmFilter")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class SsmFilterImpl implements SsmFilter, Serializable {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_FILTER")
    @SequenceGenerator(name = "SEQ_FILTER", sequenceName = "SEQ_FILTER", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Lob
    @Column(name = "SCRIPT")
    private String script;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "FILTER_TYPE")
    private SsmFilterType filterType;

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

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script;
    }

    public SsmFilterType getFilterType() {
        return filterType;
    }

    public void setFilterType(SsmFilterType filterType) {
        this.filterType = filterType;
    }

    public SsmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(SsmMetadata metadata) {
        this.metadata = metadata;
    }
}

