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
import za.ac.cput.myorderapp.Domain.Orders;

import java.net.URI;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by student on 2015/09/11.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
//@IntegrationTest({"server.port=8080"})
public class OrderAPITest {
    final String BASE_URL = "http://localhost:8080/";
    private RestTemplate template;

    //@Before
    public void setUp() throws Exception {
        template = new TestRestTemplate();
    }

    //@Test
    public void testRead() throws Exception {
        ResponseEntity<String> response =template.getForEntity(BASE_URL+"api/order", String.class);

        System.out.println("The response is "+response.getBody());


    }

    public static final String REST_SERVICE_URI = "http://localhost:8080/api";

    /* GET */
    //@SuppressWarnings("unchecked")
    private static void listAllOrders(){
        System.out.println("Testing listAllOrders API-----------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> SubjectsMap = restTemplate.getForObject(REST_SERVICE_URI+"/order/", List.class);

        if(SubjectsMap!=null){
            for(LinkedHashMap<String, Object> map : SubjectsMap){
                System.out.println("Order : id="+map.get("orderNo")+", Date="+map.get("orderDate"));
            }
        }else{
            System.out.println("No Order exist----------");
        }
    }

    /* GET */
    private static void getOrder(){
        System.out.println("Testing getOrder API----------");
        RestTemplate restTemplate = new RestTemplate();
        Orders orders = restTemplate.getForObject(REST_SERVICE_URI+"/order/1", Orders.class);
        System.out.println(orders);
    }

    /* POST */
    private static void createOrder() {
        System.out.println("Testing create Orders API----------");
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        RestTemplate restTemplate = new RestTemplate();
        Orders orders = new Orders.Builder(sqlDate).build();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/base/create/", orders, Orders.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    /* PUT */
    private static void updateOrder() {
        System.out.println("Testing update Order API----------");
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        RestTemplate restTemplate = new RestTemplate();
        Orders orders  =  new Orders.Builder(sqlDate).build();
        restTemplate.put(REST_SERVICE_URI+"/order/update/1", orders);
        System.out.println(orders);
    }

    /* DELETE */
    private static void deleteBas() {
        System.out.println("Testing delete Order API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/order/delete/3");
    }


    /* DELETE */
    private static void deleteAllSubjects() {
        System.out.println("Testing all delete Order API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/order/");
    }
}
