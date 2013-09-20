package com.ssm.llp.biz.validation.script;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (name.trim().isEmpty()) return "";
        Pattern pattern = Pattern.compile("\\b(PLT|LLP|PERKONGSIAN LIABILITI TERHAD|LIMITED LIABILITY PARTNERSHIP)+\\b",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) matcher.appendReplacement(sb, "");
        matcher.appendTail(sb);

        return CharMatcher.WHITESPACE.collapseFrom(sb.toString(), ' ').trim();
    }

    /**
     * FIXME: simple permutation with index of 2 only
     *
     * @param first
     * @param second
     * @return
     */
    public String[] permutate(String[] first, String[] second) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                list.add(first[i] + " " + second[j]);
            }
        }
        return list.toArray(new String[]{});
    }
}
