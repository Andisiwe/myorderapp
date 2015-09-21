package za.ac.cput.myorderapp.conf.Factory;

import za.ac.cput.myorderapp.Domain.Pizza;
import za.ac.cput.myorderapp.Domain.Topping;

import java.util.List;

/**
 * Created by Andies on 2015-05-14.
 */
public class PizzaFactory {
    public static Pizza createPizza(String name, double price/*, List<Topping> toppings*/){
        Pizza pizza = new Pizza.Builder(name)
                                .price(price)
                             //   .topping(toppings)
                                .build();
        return pizza;
    }
}
