package com.ssm.llp.integration.legacy;

import org.springframework.stereotype.Service;

/**
 * @author rafizan.baharum
 * @since 9/7/13
 */
@Service("robService")
public class CbsRobService {

    public RemoteRegisteredName findRegisteredName(String name) {
        return new RemoteRegisteredName("99999-X", "DUMMY COMPANY SDN BHD", 0);
    }

    public RemoteRegisteredName findRegistered(String roc) {
        return new RemoteRegisteredName("99999-X", "DUMMY COMPANY SDN BHD", 0);
    }
}
