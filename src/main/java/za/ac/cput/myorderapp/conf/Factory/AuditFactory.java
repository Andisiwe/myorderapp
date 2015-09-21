package za.ac.cput.myorderapp.conf.Factory;

import za.ac.cput.myorderapp.Domain.AuditTopping;
import za.ac.cput.myorderapp.Domain.Topping;

import java.sql.Date;
import java.util.List;

/**
 * Created by Andies on 2015-05-14.
 */
public class AuditFactory {
    public static AuditTopping createAudit(Date date, double oldPrice, double newPrice){
        AuditTopping auditTopping = new AuditTopping.Builder(date)
                                                    .oldPrice(oldPrice)
                                                    .newPrice(newPrice)
                                                    .build();
        return auditTopping;
    }
}
