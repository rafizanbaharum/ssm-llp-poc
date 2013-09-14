package com.ssm.llp.core.model;

/**
 * @author rafizan.baharum
 * @since 9/10/13
 */
public enum SsmRoleType {

    ROLE_ADMINISTRATOR("Administrator"),
    ROLE_USER("User"),
    ROLE_GUEST("Guest");

    private String description;

    SsmRoleType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }

}
