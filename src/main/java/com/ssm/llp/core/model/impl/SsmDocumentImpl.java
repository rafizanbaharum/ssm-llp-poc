package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmDocument;
import com.ssm.llp.core.model.SsmFlowdata;
import com.ssm.llp.core.model.SsmMetadata;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 9/14/13
 */
@Table(name = "SSM_DOCUMENT")
@Entity(name = "SsmDocument")
@Inheritance(strategy = InheritanceType.JOINED)
public class SsmDocumentImpl implements SsmDocument {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "SEQ_SSM_DOCUMENT")
    @SequenceGenerator(name = "SEQ_SSM_DOCUMENT", sequenceName = "SEQ_Ssm_DOCUMENT", allocationSize = 1)
    private Long id;

    @Column(name = "REFERENCE_NO")
    private String referenceNo;

    @Column(name = "SOURCE_NO")
    private String sourceNo;

    @Embedded
    private SsmMetadata metadata;

    @Embedded
    private SsmFlowdata flowdata;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReferenceNo() {
        return referenceNo;
    }

    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    public String getSourceNo() {
        return sourceNo;
    }

    public void setSourceNo(String sourceNo) {
        this.sourceNo = sourceNo;
    }

    public SsmMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(SsmMetadata metadata) {
        this.metadata = metadata;
    }

    public SsmFlowdata getFlowdata() {
        return flowdata;
    }

    public void setFlowdata(SsmFlowdata flowdata) {
        this.flowdata = flowdata;
    }
}
