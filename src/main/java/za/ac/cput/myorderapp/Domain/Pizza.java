package za.ac.cput.myorderapp.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Andies on 2015-05-14.
 */
@Entity
public class Pizza implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long pizza_no;
    private double price;
    private String name;
    /*@OneToMany//(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "pizza_no")
    private List<Topping> topping;*/

    private Pizza(){}

    public Pizza(Builder builder){
        this.pizza_no = builder.pizza_no;
        this.price = builder.price;
        this.name = builder.name;
       // this.topping = builder.topping;
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

    //public List<Topping>getTopping(){return topping;}

    public static class Builder{
        private Long pizza_no;
        private double price;
        private String name;
       // private List<Topping> topping;

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

       /* public Builder topping(List<Topping> topping){
            this.topping = topping;
            return this;
        }*/

        public Builder copy(Pizza value){
            this.pizza_no = value.pizza_no;
            this.name = value.name;
            this.price = value.price;
         //   this.topping = value.topping;
            return this;
        }

        public Pizza build(){return new Pizza(this);}
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
