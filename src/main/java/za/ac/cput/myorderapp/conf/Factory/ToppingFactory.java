package za.ac.cput.myorderapp.conf.Factory;

import za.ac.cput.myorderapp.Domain.AuditTopping;
import za.ac.cput.myorderapp.Domain.Topping;

import java.util.List;

/**
 * Created by Andies on 2015-05-14.
 */
public class ToppingFactory {
    public static Topping createTopping(String toppingName, double price, List<AuditTopping> auditToppings){
        Topping topping = new Topping.Builder(toppingName)
                                      .price(price)
                                     .auditTopping(auditToppings)
                                     .build();
        return topping;
    }
}
