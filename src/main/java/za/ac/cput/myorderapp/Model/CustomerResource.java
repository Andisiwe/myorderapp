package za.ac.cput.myorderapp.Model;

import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Andies on 2015-05-21.
 */
public class CustomerResource extends ResourceSupport {
    private Long cust_id;
    private String name;
    private String surname;

    public CustomerResource(){}

    public CustomerResource(Builder builder){
        this.cust_id = builder.cust_id;
        this.name = builder.name;
        this.surname = builder.surname;
    }

    public Long getCust_Id(){return cust_id;}
    public String getName(){return name;}
    public String getSurname(){return surname;}

    public static class Builder{
        private Long cust_id;
        private String name;
        private String surname;

        public Builder(String name){
                this.name = name;
            }

        public Builder id(Long id){
            this.cust_id = id;
            return this;
        }

        public Builder surname(String surname){
            this.surname = surname;
            return this;
        }

        public Builder copy(CustomerResource value){
            this.cust_id = value.cust_id;
            this.name = value.name;
            this.surname = value.surname;
            return this;
        }

        public CustomerResource build(){
                return new CustomerResource(this);
            }
    }
}
