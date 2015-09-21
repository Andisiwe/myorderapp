package za.ac.cput.myorderapp.Model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.myorderapp.Repository.OrderRepository;

import java.util.Date;

/**
 * Created by Andies on 2015-05-21.
 */
public class OrderResource extends ResourceSupport {
    private Long orderNo;
    private Date order_date;

    private OrderResource(){}

    public OrderResource(Builder builder){
        this.orderNo = builder.orderNo;
        this.order_date = builder.order_date;
    }

    public Long getOrderNo(){return orderNo;}
    public Date getOrder_date(){return order_date;}

    public static class Builder{
        private Long orderNo;
        private Date order_date;

        public Builder(Date order_date){
            this.order_date = order_date;
        }

        public Builder orderNo(Long orderNo){
            this.orderNo = orderNo;
            return this;
        }

        public OrderResource build(){return new OrderResource(this);}
    }

}
