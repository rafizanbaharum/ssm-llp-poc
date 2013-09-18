package com.ssm.llp.biz.validation.script;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/17/13
 */
@Component("scriptUtil")
public class ScriptUtil {

    private Logger log = LoggerFactory.getLogger(ScriptLog.class);

    /**
     * AYAM KAMBING IKAN
     * <p/>
     * RESULT:
     * AYAM KAMBING
     * KAMBING IKAN
     *
     * @param str
     * @return
     */
    public String[] makePairs(String str) {
        List<String> list = new ArrayList<String>();
        String[] split = str.split(" ");
        if (split.length == 0) return new String[]{""};
        if (split.length == 1) return new String[]{str};
        if (split.length == 2) return new String[]{str};
        for (int i = 0; i < split.length - 1; i++) {
            list.add(split[i] + " " + split[i + 1]);
        }
        return list.toArray(new String[]{});
    }

    /**
     * AYAM KAMBING IKAN
     * <p/>
     * RESULT:
     * AYAM KAMBING
     * AYAM IKAN
     * AYAM AYAM
     * KAMBING IKAN
     *
     * @param str
     * @return
     */
    public String[] permutatePairs(String str) {
        List<String> list = new ArrayList<String>();
        String[] split = str.split(" ");
        if (split.length == 0) return new String[]{""};
        if (split.length == 1) return new String[]{str};
        if (split.length == 2) return new String[]{str};
        for (int i = 0; i < split.length; i++) {
            for (int j = 0; j < split.length; j++) {
                list.add(split[j] + " " + split[i]);
            }
        }
        return list.toArray(new String[]{});
    }


    public String scrubName(String name) {
        if (null != name) {
            name = name.trim().toUpperCase();
            if (name.trim().endsWith("PLT") || name.trim().endsWith("LLP"))
                return name.trim().substring(0, name.trim().length() - "LLP".length());
            else return name.trim();
        }
        return name;
    }
}
