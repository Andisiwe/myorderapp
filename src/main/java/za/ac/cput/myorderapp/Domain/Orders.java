package za.ac.cput.myorderapp.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 * Created by student on 2015/04/23.
 */
@Entity
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderNo;
    private  Date order_date;
   /* @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_no")
    private List<Pizza> pizza;*/

    private Orders(){}

    public Orders(Builder builder){
        this.orderNo = builder.orderNo;
        this.order_date = builder.order_date;
        //this.pizza = builder.pizza;
    }

    public Long getOrderNo(){return orderNo;}
    public Date getOrder_date(){return order_date;}
   // public List<Pizza> getPizza(){return pizza;}

    public static class Builder{
        private Long orderNo;
        private Date order_date;
       // private List<Pizza> pizza;

        public Builder(Date order_date){
            this.order_date = order_date;
        }

        public Builder orderNo(Long orderNo){
            this.orderNo = orderNo;
            return this;
        }

       /* public Builder pizza(List<Pizza> pizza){
            this.pizza = pizza;
            return this;
        }*/

        public Builder copy(Orders value){
            this.order_date = value.order_date;
            this.orderNo = value.orderNo;
            return this;
        }

        public Orders build(){return new Orders(this);}
    }



}
