package za.ac.cput.myorderapp.Domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Andies on 2015-05-11.
 */
@Embeddable
public class CustomerContactsNos implements Serializable {
    private String cellNumber;
    private String homeNumber;

    private CustomerContactsNos(){}

    private CustomerContactsNos(Builder builder){
        this.cellNumber = builder.cellNumber;
        this.homeNumber = builder.homeNumber;
    }

    public String getCellNumber() {
        return cellNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public static class Builder{
        private String cellNumber;
        private String homeNumber;

        public Builder(String cellNumber){this.cellNumber = cellNumber;}

        public Builder homeNumber(String homeNumber){
            this.homeNumber = homeNumber;
            return this;
        }

        public Builder copy(CustomerContactsNos value){
            this.cellNumber = value.cellNumber;
            this.homeNumber = value.homeNumber;
            return this;
        }

        public CustomerContactsNos build(){return new CustomerContactsNos(this);}
    }
}
