package com.ssm.llp.core.model;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
public interface SsmFilter extends SsmMetaObject {

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    String getScript();

    void setScript(String script);

    SsmFilterType getFilterType();

    void setFilterType(SsmFilterType filterType);
}
