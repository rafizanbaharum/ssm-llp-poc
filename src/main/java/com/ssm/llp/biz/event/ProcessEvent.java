package com.ssm.llp.biz.event;

import com.ssm.llp.core.model.SsmDocument;
import org.springframework.context.ApplicationEvent;

/**
 * @author rafizan.baharum
 * @since 9/15/13
 */
public class ProcessEvent extends ApplicationEvent {

    private SsmDocument document;

    public ProcessEvent(SsmDocument source) {
        super(source);
        this.document = source;
    }

    public SsmDocument getDocument() {
        return document;
    }

    public void setDocument(SsmDocument document) {
        this.document = document;
    }
}
