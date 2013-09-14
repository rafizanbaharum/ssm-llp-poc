package com.ssm.llp.core.model;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
public interface SsmUser extends SsmPrincipal {

    String getUsername();

    void setUsername(String username);

    String getRealname();

    void setRealname(String realname);

    String getPassword();

    void setPassword(String password);

    String getEmail();

    void setEmail(String email);

    SsmActor getActor();

    void setActor(SsmActor actor);

}
