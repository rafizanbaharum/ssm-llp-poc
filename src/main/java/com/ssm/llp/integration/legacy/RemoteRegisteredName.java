package com.ssm.llp.integration.legacy;

/**
 * @author rafizan.baharum
 * @since 9/7/13
 */
public class RemoteRegisteredName {

    private String roc;
    private String name;
    private int status;

    public RemoteRegisteredName(String roc, String name, int status) {
        this.roc = roc;
        this.name = name;
        this.status = status;
    }

    public String getRoc() {
        return roc;
    }

    public void setRoc(String roc) {
        this.roc = roc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
