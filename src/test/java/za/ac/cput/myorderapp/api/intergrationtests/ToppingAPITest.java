package za.ac.cput.myorderapp.api.intergrationtests;

import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.myorderapp.Domain.Topping;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by student on 2015/09/11.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = App.class)
//@WebAppConfiguration
//@IntegrationTest({"server.port=8080"})
public class ToppingAPITest {
    final String BASE_URL = "http://localhost:8080/";
    private RestTemplate template;

    //@Before
    public void setUp() throws Exception {
        template = new TestRestTemplate();
    }

    //@Test
    public void testRead() throws Exception {
        ResponseEntity<String> response =template.getForEntity(BASE_URL+"api/topping", String.class);

        System.out.println("The response is "+response.getBody());


    }

    public static final String REST_SERVICE_URI = "http://localhost:8080/api";

    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAlltoppings(){
        System.out.println("Testing listAllToppings API-----------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> ToppingMap = restTemplate.getForObject(REST_SERVICE_URI+"/topping/", List.class);

        if(ToppingMap!=null){
            for(LinkedHashMap<String, Object> map : ToppingMap){
                System.out.println("Topping : id="+map.get("top_code")+", Name="+map.get("name")+", Price="+map.get("price"));
            }
        }else{
            System.out.println("No Topping exist----------");
        }
    }

    /* GET */
    private static void getTopping(){
        System.out.println("Testing getTopping API----------");
        RestTemplate restTemplate = new RestTemplate();
        Topping topping = restTemplate.getForObject(REST_SERVICE_URI+"/topping/1", Topping.class);
        System.out.println(topping);
    }

    /* POST */
    private static void createTopping() {
        System.out.println("Testing create Topping API----------");
        RestTemplate restTemplate = new RestTemplate();
        Topping topping = new Topping.Builder("Pina Apple").price(5).build();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/topping/create/", topping, Topping.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    /* PUT */
    private static void updateTopping() {
        System.out.println("Testing update Topping API----------");
        RestTemplate restTemplate = new RestTemplate();
        Topping topping  =  new Topping.Builder("Mushroom").price(6).build();
        restTemplate.put(REST_SERVICE_URI+"/topping/update/1", topping);
        System.out.println(topping);
    }

    /* DELETE */
    private static void deleteTopping() {
        System.out.println("Testing delete Topping API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/topping/delete/3");
    }


    /* DELETE */
    private static void deleteAllPizzas() {
        System.out.println("Testing all delete Topping API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/topping/");
    }
}
