package za.ac.cput.myorderapp.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Andies on 2015-05-12.
 */
@Entity
public class Base implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long baseCode;
    private String pizzaSize;
    private double price;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "base_code")
    private List<Pizza> pizza;

    private Base(){}

    public Base(Builder builder){
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

        public Builder copy(Base base){
            this.baseCode = base.baseCode;
            this.pizzaSize = base.pizzaSize;
            this.price = base.price;
            this.pizza = base.pizza;
            return this;
        }

        public Base build(){return new Base(this);}

    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
