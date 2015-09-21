package za.ac.cput.myorderapp.api.intergrationtests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.myorderapp.App;
import za.ac.cput.myorderapp.Domain.ContactAddress;
import za.ac.cput.myorderapp.Domain.Customer;
import za.ac.cput.myorderapp.Domain.CustomerContactsNos;
import za.ac.cput.myorderapp.conf.Factory.AddressFactory;
import za.ac.cput.myorderapp.conf.Factory.ContactsFactory;

import java.net.URI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by student on 2015/09/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port=8080"})
public class CustomerAPITest {
    final String BASE_URL = "http://localhost:8080/";
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        template = new TestRestTemplate();
    }

    @Test
    public void testRead() throws Exception {
        ResponseEntity<String> response =template.getForEntity(BASE_URL+"api/base", String.class);

        System.out.println("The response is "+response.getBody());


    }

    public static final String REST_SERVICE_URI = "http://localhost:8080/api";

    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllSubjects(){
        System.out.println("Testing listAllCustomers API-----------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> CustomersMap = restTemplate.getForObject(REST_SERVICE_URI+"/customer/", List.class);

        if(CustomersMap!=null){
            for(LinkedHashMap<String, Object> map : CustomersMap){
                System.out.println("Customer Id : id="+map.get("cust_id")+", Name="+map.get("name")+", Surname="+map.get("surname")
                        +", Address="+map.get("address")+", Contact no="+map.get("contactNos")+", username="+map.get("username")
                        +", password="+map.get("password")+", Order="+map.get("order"));
            }
        }else{
            System.out.println("No Customer exist----------");
        }
    }

    /* GET */
    private static void getCustomer(){
        System.out.println("Testing getCustomer API----------");
        RestTemplate restTemplate = new RestTemplate();
        Customer customer = restTemplate.getForObject(REST_SERVICE_URI+"/customer/1", Customer.class);
        System.out.println(customer);
    }

    /* POST */
    private static void createCustomer() {
        System.out.println("Testing create Customer API----------");
        RestTemplate restTemplate = new RestTemplate();
        Customer customer = new Customer.Builder("Sive").surname("Ntsini").username("veve").password("veeee").build();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/customer/create/", customer, Customer.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    /* PUT */
    private static void updateBase() {
        System.out.println("Testing update Base API----------");
        RestTemplate restTemplate = new RestTemplate();
        Customer customer  =  new Customer.Builder("Sive").surname("Ntsini").username("veve").password("veeee").build();
        restTemplate.put(REST_SERVICE_URI+"/customer/update/1", customer);
        System.out.println(customer);
    }

    /* DELETE */
    private static void deleteBas() {
        System.out.println("Testing delete Customer API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/customer/delete/3");
    }


    /* DELETE */
    private static void deleteAllSubjects() {
        System.out.println("Testing all delete Customer API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/customer/");
    }

}
