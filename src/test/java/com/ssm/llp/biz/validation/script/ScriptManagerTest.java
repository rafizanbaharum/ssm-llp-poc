package com.ssm.llp.biz.validation.script;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.ssm.llp.CoreConfig;
import com.ssm.llp.biz.validation.ValidatorContext;
import com.ssm.llp.core.dao.SsmCompanyDao;
import com.ssm.llp.core.dao.SsmFilterDao;
import com.ssm.llp.core.dao.SsmNameDao;
import com.ssm.llp.core.model.*;
import junit.framework.Assert;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CoreConfig.class})
public class ScriptManagerTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Logger log = LoggerFactory.getLogger(ScriptManagerTest.class);

    @Autowired
    private SsmFilterDao filterDao;

    @Autowired
    private SsmNameDao nameDao;

    @Autowired
    private SsmCompanyDao companyDao;

    @Autowired
    private ScriptManager scriptManager;

    @Autowired
    private ScriptUtil scriptUtil;

    @Autowired
    private SessionFactory sessionFactory;

    @Before
    public void setUp() {
    }

    @Test
    @Rollback(value = false)
    public void testSearchScript() {
        List<SsmFilter> filters = filterDao.find(SsmFilterType.SEARCH);
        for (SsmFilter filter : filters) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("name", scriptUtil.scrubName("MAJU dan JAYA PLT"));
            map.put("context", new ValidatorContext());
            boolean valid = scriptManager.executeSearchFilter(filter.getScript(), map);
            log.debug("valid?: " + valid);
        }
    }


    @Test
    @Rollback(value = false)
    public void testPoisonScript() {
        List<SsmFilter> filters = filterDao.find(SsmFilterType.POISON);
        for (SsmFilter filter : filters) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            map.put("name", scriptUtil.scrubName(" malaysia negeri sembilan membodoh RAYA PLT\\"));
            map.put("context", new ValidatorContext());
            boolean valid = scriptManager.executePoisonFilter(filter.getScript(), map);
            log.debug("Result : " + filter.getName() + " " + Strings.padStart(Boolean.toString(valid), 10, '*'));
        }
    }

    @Test
    @Rollback(value = false)
    public void testScrubName() {
        String scrubbedText = scriptUtil.scrubName("CANANG TECHPLT");
        Assert.assertEquals("CANANG TECHPLT", scrubbedText);
        log.debug(scrubbedText);

        scrubbedText = scriptUtil.scrubName("CANANG TECH PLT");
        Assert.assertEquals("CANANG TECH", scrubbedText);
        log.debug(scrubbedText);

        scrubbedText = scriptUtil.scrubName("CANANG TECHLLP");
        Assert.assertEquals("CANANG TECHLLP", scrubbedText);
        log.debug(scrubbedText);

        scrubbedText = scriptUtil.scrubName("CANANG TECH LLP ");
        Assert.assertEquals("CANANG TECH", scrubbedText);
        log.debug(scrubbedText);

        scrubbedText = scriptUtil.scrubName("CANANG TECH LLP LLP ");
        Assert.assertEquals("CANANG TECH", scrubbedText);
        log.debug(scrubbedText);

        scrubbedText = scriptUtil.scrubName("");
        Assert.assertEquals("", scrubbedText);
        log.debug(scrubbedText);

        scrubbedText = scriptUtil.scrubName(" ");
        Assert.assertEquals("", scrubbedText);
        log.debug(scrubbedText);
    }

    @Test
    @Rollback(value = false)
    public void testUtils() {
        String[] strings = scriptUtil.makePairs("AL ARABI WAL WAHDI");
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            log.debug(string);
        }
    }

    @Test
    @Rollback(value = false)
    public void testUtils2() {
        String[] strings = scriptUtil.makePairs("");
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            log.debug(string);
        }
    }

    @Test
    @Rollback(value = false)
    public void testPermutates() {
        String[] strings = scriptUtil.permutatePairs("EHRAM BLAH MUKJIZAH DODOL");
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            log.debug(string);
        }
    }

    @Test
    @Rollback(value = false)
    public void testPermutates2() {
        String[] strings = scriptUtil.permutatePairs("");
        for (int i = 0; i < strings.length; i++) {
            String string = strings[i];
            log.debug(string);
        }
    }

    @Test
    @Rollback(value = false)
    public void companyFilterTest() {

        log.debug("" + companyDao.isValidWinding("ALAM MEKAR"));
        log.debug("" + companyDao.isValidWinding("ALIRAN DATA"));

    }

    @Test
    @Rollback(value = false)
    public void stringContainsGazettedWords() {
        String invalidName = "BUATANx diraja  MALAYSIA plt";
        String scrubbedName = scriptUtil.scrubName(invalidName);
        String[] permuteWords = scriptUtil.permuteWords(scrubbedName);
        List<SsmName> gazettedNames = nameDao.find(SsmNameType.GAZETTED);
        for (String permuteWord : permuteWords) {
            for (SsmName gazettedName : gazettedNames) {
                boolean matches = permuteWord.toUpperCase().replaceAll("[()]", "")
                        .matches(".*\\b" + gazettedName.getName().toUpperCase().replaceAll("[()]", "") + "\\b.*");
                if (matches) {
                    log.debug("Found Invalid! " + gazettedName.getName());
                    log.debug("Name = " + permuteWord);
                    return;
                }
            }
        }
    }

    @Test
    @Rollback(value = false)
    public void stringContainsControlledWords() {
        String[] invalidNames = new String[]{"KKKK KKKK FUTURES TRADING ADVISER LLP",
                "INTERNATIONAL CRIMINAL POLICE ORGANISATION (ICPO-I",
                " K.LUMPUR 2006 ", "INCarnation NIRVANA", "C.S.L kelantan"};
        for (String name : invalidNames) {
            String scrubbedName = scriptUtil.scrubName(name);
            String[] permuteWords = scriptUtil.permuteWords(scrubbedName);
            List<SsmName> controlledNames = nameDao.find(SsmNameType.CONTROLLED);
            for (String permuteWord : permuteWords) {
                for (SsmName controlledName : controlledNames) {
                    boolean matches = permuteWord.toUpperCase().replaceAll("[()]", "")
                            .matches(".*\\b" + controlledName.getName().toUpperCase().replaceAll("[()]", "") + "\\b.*");
                    if (matches) {
                        log.debug("Found Invalid! " + controlledName.getName());
                        log.debug("Name = " + permuteWord);
//                        return;
                    }
                }
            }
        }
    }

    @Test
    @Rollback(value = false)
    public void stringContainsOffensiveWords() {
        String[] invalidNames = new String[]{"AL HAMDULILLAH",
                "kaw ni COMMUNIST ke companies? ", " INCORPORATION WTH KEPARAT "};
        for (String invalidName : invalidNames) {
            String scrubbedName = scriptUtil.scrubName(invalidName);
            String[] permuteWords = scriptUtil.permuteWords(scrubbedName);
            List<SsmName> offensiveNames = nameDao.find(SsmNameType.OFFENSIVE);
            for (String permuteWord : permuteWords) {
                for (SsmName offensiveName : offensiveNames) {
                    boolean matches = permuteWord.toUpperCase().replaceAll("[()]", "")
                            .matches(".*\\b" + offensiveName.getName().toUpperCase().replaceAll("[()]", "") + "\\b.*");
                    if (matches) {
                        log.debug("Found Invalid! " + offensiveName.getName());
                        log.debug("Name = " + permuteWord);
//                        return;
                    }
                }
            }
        }
    }

    @Test
    @Rollback(value = false)
    public void nonStandaloneCountry() {
        String[] invalidNames = new String[]{"Malaysia trade PLT", " Malaysia trade PLT", "indah malaysia"};
        for (String name : invalidNames) Assert.assertTrue(validateCountry(name));

        String[] validaNames = new String[]{" Durian Malaysia trade PLT", "Malaysia Trade Company LLP LLP",
                " %Malaysia trade PLT"};
        for (String name : validaNames) Assert.assertTrue(validateCountry(name));

    }

    @Test
    @Rollback(value = false)
    public void nonStandaloneState() {
        String[] names = new String[]{"  Negeri Sembilan trade PLT PERKONGSIAN LIABILITI TERHAD ",
                "Pahang invest LLP LLP"};
        for (String name : names) Assert.assertTrue(validateState(name));

        String validName = "  Dodol Sarawak Sedap PLT ";
        Assert.assertTrue(validateState(validName));
    }

    @Test
    @Rollback(value = false)
    public void nameWithInvalidSymbol() {
        String[] names = new String[]{"  ABJJ% PERKONGSIAN LIABILITI TERHAD ",
                "\\Pahang invest LLP\" LLP", "Pahang invest LLP LLP:"};

        for (String name : names) {
            name = scriptUtil.scrubName(name);
            for (SsmName symbol : nameDao.find(SsmNameType.SYMBOL)) {
                if (name.contains(symbol.getName())) {
                    log.debug("Found Invalid! " + symbol.getName());
                    log.debug("Name = " + name);
                    Assert.assertTrue(name.contains(symbol.getName()));
                }
            }
        }
    }

    /*
    * cth : Perkataan maju jaya = majujaya = maju & jaya = maju dan jaya

    Perkataan jaya maju ≠ maju jaya
    */
    // TODO : Damn it ! buruk!
    @Test
    @Rollback(value = false)
    public void ampersandStemming() {
        String[] testStrings = new String[]{"majujaya plt ", "maju&jaya & kucing llp llp", "maju & jaya plt pltx", "maju dan jaya pltc"};

        for (String testString : testStrings) {
            String scrubbedName = scriptUtil.scrubName(testString);
            String[] stems = new String[]{"", " ", " DAN ", " & "};
            if (scrubbedName.contains("&")
                    || scrubbedName.contains("DAN")
                    || scrubbedName.contains("dan")) {
                String[] splits = scrubbedName.split("DAN|dan|&");
                log.debug("split.toString() = " + Arrays.toString(splits));
                String first = null, last = null;

                if (splits[0].split(" ").length > 0) {
                    Iterable<String> splitRights = Splitter.on(" ").omitEmptyStrings().trimResults().split(splits[0]);
                    last = Iterables.getLast(splitRights, "");
                    log.debug("last = " + last);
                }
                if (splits[1].split(" ").length > 0) {
                    Iterable<String> splitRights = Splitter.on(" ").omitEmptyStrings().trimResults().split(splits[1]);
                    first = Iterables.getFirst(splitRights, "");
                    log.debug("first = " + first);
                }
                for (String stem : stems) {
                    String join = last + stem + first;
                    List<SsmCompany> ssmCompanies = companyDao.find();
                    for (SsmCompany ssmCompany : ssmCompanies) {
                        boolean match = ssmCompany.getName().matches(".*\\b" + join.toUpperCase().replaceAll("[()]", "") + "\\b.*");
                        if (match) {
                            log.debug("found! = " + ssmCompany.getName() + " >> " + ssmCompany.getId());
                        }
                    }
                }
            }
        }
    }

    @Test
    @Rollback(value = false)
    public void ampersandStemming2() {
        String[] testStrings = new String[]{"majujaya plt ", "maju&jaya & kucing llp llp", "maju & jaya plt pltx", "maju dan jaya pltc"};
        String[] stems = new String[]{"", " ", " DAN ", " & "};
        for (String testString : testStrings) {
            String scrubbedName = scriptUtil.scrubName(testString);
            for (String stem : stems) {
                String replace = scrubbedName.replace("&", stem);
                String s = CharMatcher.WHITESPACE.collapseFrom(replace, ' ');
                log.debug("replace = " + s);
                boolean match = companyDao.hasName(s);

                String replace2 = scrubbedName.replace("DAN", stem);
                s = CharMatcher.WHITESPACE.collapseFrom(replace2, ' ');
                log.debug("replace2 = " + s);
                boolean match2 = companyDao.hasName(s);

                if (match || match2) {
//                    return true;
                }
            }
        }
    }

    private boolean validateCountry(String name) {
        String scrubbedName = scriptUtil.scrubName(name);
        for (SsmName country : nameDao.find(SsmNameType.COUNTRY)) {
            boolean match = scrubbedName.matches(".*\\b" + country.getName().toUpperCase().replaceAll("[()]", "") + "\\b.*");
            if (match) {
                log.debug("Found! " + country.getName());
                log.debug("Name = " + scrubbedName);

                // flag context.waived
//                context.setWaived(true);
                return true; // it's okay, we're just flagging
            }
        }
        return false;
    }

    private boolean validateState(String name) {
        String scrubbedName = scriptUtil.scrubName(name);
        for (SsmName state : nameDao.find(SsmNameType.STATE)) {
            boolean match = scrubbedName.matches(".*\\b" + state.getName().toUpperCase().replaceAll("[()]", "") + "\\b.*");
            if (match) {
                log.debug("Found Invalid! = " + state.getName());
                log.debug("Name = " + scrubbedName);
                return true;
            }
        }
        return false;
    }
}
