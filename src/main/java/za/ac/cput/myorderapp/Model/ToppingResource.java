package za.ac.cput.myorderapp.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Andies on 2015-05-21.
 */
public class ToppingResource extends ResourceSupport {
    private Long top_code;
    private double price;

    private ToppingResource(){}

    public ToppingResource(Builder builder){
        this.top_code = builder.top_code;
        this.price = builder.price;
    }

    public Long getTop_code() {
        return top_code;
    }

    public double getPrice() {
        return price;
    }

    public static class Builder{
        private Long top_code;
        private double price;

        public Builder(double price){
            this.price = price;
        }

        public Builder top_code(Long top_code){
            this.top_code = top_code;
            return this;
        }

        public ToppingResource build(){
            return new ToppingResource(this);
        }
    }

}
