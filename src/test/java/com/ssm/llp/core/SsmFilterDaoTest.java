package com.ssm.llp.core;

import com.ssm.llp.CoreConfig;
import com.ssm.llp.core.dao.SsmFilterDao;
import com.ssm.llp.core.dao.SsmUserDao;
import com.ssm.llp.core.model.SsmFilter;
import com.ssm.llp.core.model.SsmUser;
import com.ssm.llp.core.model.impl.SsmPoisonFilterImpl;
import com.ssm.llp.core.model.impl.SsmSearchFilterImpl;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author rafizan.baharum
 * @since 9/6/13
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CoreConfig.class})
public class SsmFilterDaoTest extends AbstractTransactionalJUnit4SpringContextTests {

    private Logger log = LoggerFactory.getLogger(SsmFilterDaoTest.class);

    @Autowired
    private SsmFilterDao filterDao;

    @Autowired
    private SsmUserDao userDao;

    @Autowired
    private SessionFactory sessionFactory;

    private SsmUser root;

    private String workingDir;

    @Before
    public void setUp() {
        root = userDao.findByUsername("root");
        workingDir = System.getProperty("user.dir");
    }

    /**
     * delete from SSM_POISON_FILTER;
     * delete from SSM_SEARCH_FILTER;
     * delete from SSM_FILTER;
     */
    @Test
    @Rollback(value = false)
    public void createFilters() {

        // error map
        Map<String, String> errorMap = new HashMap<String, String>();
        errorMap.put("AmpersandDestemmingSearchFilter", "YOUR CHOSEN NAME EXISTED");
        errorMap.put("CompanyWindingPoisonFilter", "YOUR CHOSEN NAME EXISTED");
        errorMap.put("ControlledPoisonFilter", "YOUR CHOSEN NAME HAS A CONTROLLED WORD(S)");
        errorMap.put("DotToEmptyDestemmingSearchFilter", "YOUR CHOSEN NAME EXISTED");
        errorMap.put("DotToSpaceDestemmingSearchFilter", "YOUR CHOSEN NAME EXISTED");
        errorMap.put("EmptyOrNullPoisonFilter", "YOUR CHOSEN NAME IS INVALID");
        errorMap.put("EnglishPluralSearchFilter", "YOUR CHOSEN NAME EXISTED");
        errorMap.put("ExistingSearchFilter", "YOUR CHOSEN NAME EXISTED");
        errorMap.put("GazettedPoisonFilter", "YOUR CHOSEN NAME HAS GAZETTED WORD(S)");
        errorMap.put("MalayPluralSearchFilter ", "YOUR CHOSEN NAME EXISTED");
        errorMap.put("MalaysianStatePoisonFilter", "YOUR CHOSEN NAME EXISTED");
        errorMap.put("MalaysiaPoisonFilter", "YOUR CHOSEN NAME HAS GAZETTED WORD(S)");
        errorMap.put("OffensivePoisonFilter", "YOUR CHOSEN NAME HAS OFFENSIVE WORD(S)");
        errorMap.put("ReservedPoisonFilter", "YOUR CHOSEN NAME IS ALREADY RESERVED");
        errorMap.put("SimilarSearchFilter", "YOUR CHOSEN NAME EXISTED");
        errorMap.put("SpecialWordPoisonFilter", "YOUR CHOSEN NAME IS INVALID");
        errorMap.put("StandaloneCountryPoisonFilter", "YOUR CHOSEN NAME HAS GAZETTED WORD(S)");
        errorMap.put("StandaloneStatePoisonFilter", "YOUR CHOSEN NAME GAZETTED WORD(S)");
        errorMap.put("StatePoisonFilter", "YOUR CHOSEN NAME GAZETTED WORD(S)");
        errorMap.put("SymbolPoisonFilter", "YOUR CHOSEN NAME HAS INVALID SYMBOL(S)");
        errorMap.put("UsedPoisonFilter", "YOUR CHOSEN NAME EXISTED");

        List<SsmFilter> ssmFilters = filterDao.find();
        for (SsmFilter ssmFilter : ssmFilters) {
            log.debug(ssmFilter.getName() + " deleted!");
            sessionFactory.getCurrentSession().delete(ssmFilter);
            sessionFactory.getCurrentSession().flush();
        }

        System.out.println();

        try {
            File poisonFolder = new File(workingDir + "/src/test/resources/filters/poison");
            File[] files = poisonFolder.listFiles();
            for (int i = 0; i < files.length; i++) {
                File file = files[i];
                SsmPoisonFilterImpl filter = new SsmPoisonFilterImpl();
                String name = file.getName().substring(0, file.getName().length() - 4);
                filter.setName(name);
                filter.setDescription(file.getName().substring(0, file.getName().length() - 4));
                filter.setError(errorMap.get(name));
                filter.setScript(readFile(file.getAbsolutePath(), Charset.defaultCharset()));
                filterDao.save(filter, root);
                log.debug(filter.getName() + " saved!");
            }
            sessionFactory.getCurrentSession().flush();

            File searchFolder = new File(workingDir + "/src/test/resources/filters/search");
            File[] searchFiles = searchFolder.listFiles();
            for (int i = 0; i < searchFiles.length; i++) {
                File file = searchFiles[i];
                SsmSearchFilterImpl filter = new SsmSearchFilterImpl();
                String name = file.getName().substring(0, file.getName().length() - 4);
                filter.setName(name);
                filter.setDescription(name);
                filter.setError(errorMap.get(name));
                filter.setScript(readFile(file.getAbsolutePath(), Charset.defaultCharset()));
                filterDao.save(filter, root);
                log.debug(filter.getName() + " saved!");
            }
            sessionFactory.getCurrentSession().flush();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static String readFile(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return encoding.decode(ByteBuffer.wrap(encoded)).toString();


    }
}



