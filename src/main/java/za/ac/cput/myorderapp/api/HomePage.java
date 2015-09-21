package za.ac.cput.myorderapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.myorderapp.Domain.AuditTopping;
import za.ac.cput.myorderapp.Services.AuditToppingService;

import java.util.Date;
import java.util.List;

/**
 * Created by Andies on 2015-05-21.
 */
@RestController
@RequestMapping("/api/**")
public class HomePage {

    @Autowired
    private AuditToppingService service;

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String index(){return "This is a Home Page";}

    @RequestMapping(value = "/auditTopping", method = RequestMethod.GET)
    public AuditTopping getAuditTopping(){
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        AuditTopping auditTopping = new AuditTopping.Builder(sqlDate)
                                                    .oldPrice(5)
                                                    .newPrice(7)
                                                    .build();
        return auditTopping;
    }

    @RequestMapping(value = "/auditInfo", method = RequestMethod.GET)
    public List<AuditTopping> getAuditToppings(){return service.findAll();}
}
