package za.ac.cput.myorderapp.Model;

import org.springframework.hateoas.ResourceSupport;

import java.util.Date;

/**
 * Created by student on 2015/08/11.
 */
public class AuditToppingResource extends ResourceSupport{
    private Long user_id;
    private Date dateChanged;
    private double oldPrice;
    private double newPrice;

    private AuditToppingResource(){}

    public AuditToppingResource(Builder builder){
        this.user_id = builder.user_id;
        this.dateChanged = builder.dateChanged;
        this.oldPrice = builder.oldPrice;
        this.newPrice = builder.newPrice;

    }

    public Long getUser_id() {
        return user_id;
    }

    public Date getDateChanged() {
        return dateChanged;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public double getNewPrice() {
        return newPrice;
    }



    public static class Builder{
        private Long user_id;
        private Date dateChanged;
        private double oldPrice;
        private double newPrice;

        public Builder(Date dateChanged){
            this.dateChanged = dateChanged;
        }

        public Builder user_id(Long user_id){
            this.user_id = user_id;
            return this;
        }

        public Builder oldPrice(double oldPrice){
            this.oldPrice = oldPrice;
            return this;
        }

        public Builder newPrice(double newPrice){
            this.newPrice = newPrice;
            return this;
        }

        public Builder copy(AuditToppingResource value){
            this.user_id = value.user_id;
            this.dateChanged = value.dateChanged;
            this.oldPrice = value.oldPrice;
            this.newPrice = value.newPrice;
            return this;
        }

        public AuditToppingResource build(){return new AuditToppingResource(this);}

    }

}
