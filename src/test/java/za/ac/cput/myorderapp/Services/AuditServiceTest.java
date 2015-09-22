package za.ac.cput.myorderapp.Services;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import za.ac.cput.myorderapp.App;
import za.ac.cput.myorderapp.Domain.AuditTopping;
import za.ac.cput.myorderapp.Domain.Topping;
import za.ac.cput.myorderapp.Repository.AuditToppingRepository;
import za.ac.cput.myorderapp.conf.Factory.AuditFactory;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Andies on 2015-05-20.
 */
//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
public class AuditServiceTest extends AbstractTestNGSpringContextTests {
    @Autowired
    private AuditToppingService service;

    private Long id;

    @Autowired
    private AuditToppingRepository repository;
    private AuditTopping auditTopping;

    //@BeforeMethod
    public void setUp() throws Exception {


    }

    //@Test
    public void create() throws Exception {
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        AuditTopping auditTopping = AuditFactory.createAudit(sqlDate, 5, 7);
        repository.save(auditTopping);
        id = auditTopping.getUser_id();
        Assert.assertNotNull(auditTopping.getUser_id());

    }

    //@Test(dependsOnMethods = "create")
    public void testGetAuditInfo() throws Exception {
        List<AuditTopping> auditTopping = service.findAll();
        Assert.assertNotNull(auditTopping);

    }
}
