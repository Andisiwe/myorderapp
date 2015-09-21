package za.ac.cput.myorderapp.conf.Factory;

import za.ac.cput.myorderapp.Domain.Orders;
import za.ac.cput.myorderapp.Domain.Pizza;

import java.sql.Date;
import java.util.List;

/**
 * Created by student on 2015/04/25.
 */
public class OrderFactory {
    public static Orders createOrder(Date orderDate /*List<Pizza>pizza*/){
        Orders orders = new Orders.Builder(orderDate)
                                    //.pizza(pizza)
                                    .build();
        return orders;
    }
}
