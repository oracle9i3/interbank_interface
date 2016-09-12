package lv.javaguru.java2.database.hibernate;

import jdk.nashorn.internal.ir.annotations.Ignore;
import lv.javaguru.java2.servlet.mvc.spring.SpringConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

/**
 * Created by Svetlana Titova on 29.08.2016.
 */
    @Ignore
    @RunWith(SpringJUnit4ClassRunner.class)
    @ContextConfiguration(classes = SpringConfig.class)
    @TransactionConfiguration(defaultRollback = false)
    public class SpringIntegration {

    }

