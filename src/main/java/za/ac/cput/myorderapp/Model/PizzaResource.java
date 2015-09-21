package za.ac.cput.myorderapp.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Andies on 2015-05-21.
 */
public class PizzaResource extends ResourceSupport {
    private Long pizza_no;
    private double price;
    private String name;

    private PizzaResource(){}

    public PizzaResource(Builder builder){
        this.pizza_no = builder.pizza_no;
        this.price = builder.price;
        this.name = builder.name;
    }

    public Long getPizza_no() {
        return pizza_no;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public static class Builder{
        private Long pizza_no;
        private double price;
        private String name;

        public Builder(String name){
            this.name = name;
        }

        public Builder pizza_no(Long pizza_no){
            this.pizza_no = pizza_no;
            return this;
        }

        public Builder price(double price){
            this.price = price;
            return this;
        }

        public Builder copy(PizzaResource value){
            this.pizza_no = value.pizza_no;
            this.name = value.name;
            this.price = value.price;
            return this;
        }

        public PizzaResource build(){return new PizzaResource(this);}
    }
}
