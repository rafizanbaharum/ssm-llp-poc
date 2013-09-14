package com.ssm.llp.core.model.impl;

import com.ssm.llp.core.model.SsmActor;
import com.ssm.llp.core.model.SsmUser;

import javax.persistence.*;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
@Table(name = "SSM_USER")
@Entity(name = "SsmUser")
public class SsmUserImpl extends SsmPrincipalImpl implements SsmUser {

    @Column(name = "REALNAME")
    private String realname;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @OneToOne(targetEntity = SsmActorImpl.class)
    @JoinColumn(name = "ACTOR_ID")
    private SsmActor actor;

    public String getUsername() {
        return getName();
    }

    public void setUsername(String username) {
        setName(username);
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SsmActor getActor() {
        return actor;
    }

    public void setActor(SsmActor actor) {
        this.actor = actor;
    }

    @Override
    public String toString() {
        return "SsmUserImpl{" +
                "name='" + getName() + '\'' +
                "realname='" + realname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
