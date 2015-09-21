package za.ac.cput.myorderapp.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by student on 2015/04/23.
 */
@Entity
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cust_id;
    private String name;
    private String surname;
    private String username;
    private String password;
    @Embedded
    private ContactAddress address;
    private CustomerContactsNos contactsNos;
    @OneToMany//(fetch = FetchType.EAGER)
    @JoinColumn(name = "cust_id")
    private List<Orders> order;

    public Customer(){}

    public Customer(Builder builder){
        this.cust_id = builder.cust_id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.address = builder.address;
        this.contactsNos = builder.contactNos;
        this.order = builder.order;
    }

    public Long getId(){return cust_id;}
    public String getName(){return name;}
    public String getSurname(){return surname;}
    public String getUsername(){return username;}
    public String getPassword(){return password;}
    public ContactAddress getAddress(){return address;}
    public CustomerContactsNos getContactsNos(){return contactsNos;}
    public List<Orders> getOrder(){return order;}



    public static class Builder{
        private Long cust_id;
        private String name;
        private String surname;
        private ContactAddress address;
        private CustomerContactsNos contactNos;
        private String username;
        private String password;
        private List<Orders> order;


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

        public Builder username(String username){
            this.username = username;
            return this;
        }

        public Builder password(String password){
            this.password = password;
            return this;
        }

        public Builder address(ContactAddress address){
            this.address = address;
            return this;
        }

        public Builder contactNos(CustomerContactsNos contactNos){
            this.contactNos = contactNos;
            return this;
        }

        public Builder order(List<Orders> order){
            this.order = order;
            return this;
        }

        public Builder copy(Customer value){
            this.cust_id = value.cust_id;
            this.name = value.name;
            this.surname = value.surname;
            this.username = value.username;
            this.password = value.password;
            this.address = value.address;
            this.contactNos = value.contactsNos;
            this.order = value.order;
            return this;
        }

        public Customer build(){
            return new Customer(this);
        }
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
