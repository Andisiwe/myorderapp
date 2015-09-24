package za.ac.cput.myorderapp.Domain;

import org.junit.Assert;
import za.ac.cput.myorderapp.conf.Factory.AuditFactory;

import java.util.Date;

/**
 * Created by Andies on 2015-05-14.
 */
public class TestAuditTopping {
   // @Before
    public void setUp() throws Exception {


    }

  //  @Test
    public void testCreateAudit() throws Exception {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        AuditTopping auditTopping = AuditFactory.createAudit(sqlDate,5,7);

        Assert.assertEquals(7, auditTopping.getNewPrice(), 2);

    }
}
