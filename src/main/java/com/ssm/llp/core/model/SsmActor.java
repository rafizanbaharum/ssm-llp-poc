package com.ssm.llp.core.model;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
public interface SsmActor extends SsmMetaObject {

    String getIdentityNo();

    void setIdentityNo(String identityNo);

    String getName();

    void setName(String name);

    String getAddress1();

    void setAddress1(String address1);

    String getAddress2();

    void setAddress2(String address2);

    String getAddress3();

    void setAddress3(String address3);

    String getEmail();

    void setEmail(String email);

    String getPhone();

    void setPhone(String phone);

    String getFax();

    void setFax(String fax);

    SsmActorType getActorType();

    void setActorType(SsmActorType actorType);
}

