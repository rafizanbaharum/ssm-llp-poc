package com.ssm.llp.biz.validation.script;

import com.google.common.base.CharMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author rafizan.baharum
 * @since 9/17/13
 */
@Component("scriptUtil")
public class ScriptUtil {

    private Logger log = LoggerFactory.getLogger(ScriptUtil.class);

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

    public String scrubName(String name) {
        if (name.trim().isEmpty()) return "";
        name = name.toUpperCase();
        Pattern pattern = Pattern.compile("\\b(PLT|LLP|PERKONGSIAN LIABILITI TERHAD|LIMITED LIABILITY PARTNERSHIP)+\\b",
                Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);

        StringBuffer sb = new StringBuffer();
        while (matcher.find()) matcher.appendReplacement(sb, "");
        matcher.appendTail(sb);

        return CharMatcher.WHITESPACE.collapseFrom(sb.toString(), ' ').trim();
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

    public String[] permuteWords(String s) {
        String[] split = s.split(" ");
        boolean[] used = new boolean[split.length];
        String res = "";
        List<String> list = new ArrayList<String>();
        permute(split, used, res, 0, list);
        return list.toArray(new String[]{});
    }

    public static void permute(String[] splits, boolean[] used, String res, int level, List<String> list) {
//        log.debug(String.format("res = %s level = %d Used = %s", res, level, Arrays.toString(used)));
        if (level == splits.length && !res.equals("")) {
            list.add(res.trim());
            return;
        }
        for (int i = 0; i < splits.length; i++) {
            if (used[i]) continue;
            used[i] = true;
            permute(splits, used, res + " " + splits[i], level + 1, list);
            used[i] = false;
        }
    }

}
