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
import za.ac.cput.myorderapp.Domain.Pizza;

import java.net.URI;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by student on 2015/09/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
@IntegrationTest({"server.port=8080"})
public class PizzaAPITest {
    final String BASE_URL = "http://localhost:8080/";
    private RestTemplate template;

    @Before
    public void setUp() throws Exception {
        template = new TestRestTemplate();
    }

    @Test
    public void testRead() throws Exception {
        ResponseEntity<String> response =template.getForEntity(BASE_URL+"api/pizza", String.class);

        System.out.println("The response is "+response.getBody());


    }

    public static final String REST_SERVICE_URI = "http://localhost:8080/api";

    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllPizzas(){
        System.out.println("Testing listAllPizzas API-----------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> PizzaMap = restTemplate.getForObject(REST_SERVICE_URI+"/pizza/", List.class);

        if(PizzaMap!=null){
            for(LinkedHashMap<String, Object> map : PizzaMap){
                System.out.println("Pizza : id="+map.get("pizzaNo")+", Name="+map.get("name")+", Price="+map.get("price"));
            }
        }else{
            System.out.println("No Pizza exist----------");
        }
    }

    /* GET */
    private static void getPizza(){
        System.out.println("Testing getPizza API----------");
        RestTemplate restTemplate = new RestTemplate();
        Pizza pizza = restTemplate.getForObject(REST_SERVICE_URI+"/pizza/1", Pizza.class);
        System.out.println(pizza);
    }

    /* POST */
    private static void createPizza() {
        System.out.println("Testing create Pizza API----------");
        RestTemplate restTemplate = new RestTemplate();
        Pizza pizza = new Pizza.Builder("Something meaty").price(70).build();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/pizza/create/", pizza, Pizza.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    /* PUT */
    private static void updatePizza() {
        System.out.println("Testing update Pizza API----------");
        RestTemplate restTemplate = new RestTemplate();
        Pizza pizza  =  new Pizza.Builder("Chicken").price(50).build();
        restTemplate.put(REST_SERVICE_URI+"/pizza/update/1", pizza);
        System.out.println(pizza);
    }

    /* DELETE */
    private static void deletePizza() {
        System.out.println("Testing delete Pizza API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/pizza/delete/3");
    }


    /* DELETE */
    private static void deleteAllPizzas() {
        System.out.println("Testing all delete Pizza API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/pizza/");
    }
}
