package com.ssm.llp.biz.manager;

/**
 * @author rafizan.baharum
 * @since 9/15/13
 */
public interface UserRegistrationManager {

    void register(String username, String password, String name, String nricNo,
                  String email, String fax, String phone,
                  String address1, String address2, String address3);

    boolean isExists(String username);
}
