package com.ssm.llp.core.model;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
public interface SsmName extends SsmMetaObject{

    String getName();

    void setName(String name);

    SsmNameType getNameType();

    void setNameType(SsmNameType nameType);
}
