package com.ssm.llp.biz.validation.script;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author rafizan.baharum
 * @since 9/7/13
 */
@Component("scriptLog")
public class ScriptLog {

    private Logger log = LoggerFactory.getLogger(ScriptLog.class);

    public void debug(String msg) {
        log.debug(msg);
    }

    public void info(String msg) {
        log.info(msg);
    }

    public void warn(String msg) {
        log.warn(msg);
    }

    public void error(String msg) {
        log.error(msg);
    }
}
