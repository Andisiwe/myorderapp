package za.ac.cput.myorderapp.Model;

import org.springframework.hateoas.ResourceSupport;
import za.ac.cput.myorderapp.Domain.Pizza;

import java.util.List;

/**
 * Created by student on 2015/08/11.
 */
public class BaseResource extends ResourceSupport {
    private Long baseCode;
    private String pizzaSize;
    private double price;

    private List<Pizza> pizza;

    private BaseResource(){}

    public BaseResource(Builder builder){
        this.baseCode = builder.baseCode;
        this.pizzaSize = builder.pizzaSize;
        this.price = builder.price;
        this.pizza = builder.pizza;
    }

    public Long getBaseCode() {
        return baseCode;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public double getPrice() {
        return price;
    }
    public List<Pizza> getPizza(){return pizza;}

    public static class Builder{
        private Long baseCode;
        private String pizzaSize;
        public double price;
        private List<Pizza> pizza;

        public Builder(String pizzaSize){this.pizzaSize = pizzaSize;}

        public Builder baseCode(Long baseCode){
            this.baseCode = baseCode;
            return this;
        }

        public Builder price(double price){
            this.price = price;
            return this;
        }

        public Builder pizza(List<Pizza> pizza){
            this.pizza = pizza;
            return this;
        }

        public Builder copy(BaseResource base){
            this.baseCode = base.baseCode;
            this.pizzaSize = base.pizzaSize;
            this.price = base.price;
            this.pizza = base.pizza;
            return this;
        }

        public BaseResource build(){return new BaseResource(this);}

    }
}
