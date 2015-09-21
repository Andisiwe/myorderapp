package za.ac.cput.myorderapp.Domain;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by Andies on 2015-05-11.
 */
@Embeddable
public class ContactAddress implements Serializable {
    private String physicalAddress;
    private String postalAddress;
    private int postalCode;

    private ContactAddress(){}

    public ContactAddress(Builder builder){
        this.physicalAddress = builder.physicalAddress;
        this.postalAddress = builder.postalAddress;
        this.postalCode = builder.postalCode;
    }

    public String getPhysicalAddress(){return physicalAddress;}
    public String getPostalAddress(){return postalAddress;}
    public int getPostalCode(){return postalCode;}

    public static class Builder{
        private String physicalAddress;
        private String postalAddress;
        private int postalCode;

        public Builder(String physicalAddress){this.physicalAddress = physicalAddress;}

        public Builder postalAddress(String postalAddress){
            this.postalAddress = postalAddress;
            return this;
        }

        public Builder postalCode(int postalCode){
            this.postalCode = postalCode;
            return this;
        }

        public Builder copy(ContactAddress value){
            this.physicalAddress = value.physicalAddress;
            this.postalAddress = value.postalAddress;
            this.postalCode = value.postalCode;
            return this;
        }

        public ContactAddress build(){return  new ContactAddress(this);}
    }
}
