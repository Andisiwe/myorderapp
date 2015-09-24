package za.ac.cput.myorderapp.api.intergrationtests;

import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import za.ac.cput.myorderapp.Domain.Base;

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
public class BaseAPITest {

    final String BASE_URL = "http://localhost:8080/";
    private RestTemplate template;

   // @Before
    public void setUp() throws Exception {
        template = new TestRestTemplate();
    }

    //@Test
    public void testRead() throws Exception {
        ResponseEntity<String> response =template.getForEntity(BASE_URL+"api/base", String.class);

        System.out.println("The response is "+response.getBody());


    }

    public static final String REST_SERVICE_URI = "http://localhost:8080/api";

    /* GET */
    @SuppressWarnings("unchecked")
    private static void listAllSubjects(){
        System.out.println("Testing listAllBases API-----------");

        RestTemplate restTemplate = new RestTemplate();
        List<LinkedHashMap<String, Object>> SubjectsMap = restTemplate.getForObject(REST_SERVICE_URI+"/base/", List.class);

        if(SubjectsMap!=null){
            for(LinkedHashMap<String, Object> map : SubjectsMap){
                System.out.println("Base : id="+map.get("baseCode")+", Size="+map.get("pizzSize")+", Price="+map.get("price"));
            }
        }else{
            System.out.println("No Base exist----------");
        }
    }

    /* GET */
    private static void getBase(){
        System.out.println("Testing getBase API----------");
        RestTemplate restTemplate = new RestTemplate();
        Base base = restTemplate.getForObject(REST_SERVICE_URI+"/base/1", Base.class);
        System.out.println(base);
    }

    /* POST */
    private static void createBase() {
        System.out.println("Testing create Base API----------");
        RestTemplate restTemplate = new RestTemplate();
        Base base = new Base.Builder("Medium").price(40.0).build();
        URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/base/create/", base, Base.class);
        System.out.println("Location : "+uri.toASCIIString());
    }

    /* PUT */
    private static void updateBase() {
        System.out.println("Testing update Base API----------");
        RestTemplate restTemplate = new RestTemplate();
        Base base  =  new Base.Builder("Medium").price(30.0).build();
        restTemplate.put(REST_SERVICE_URI+"/base/update/1", base);
        System.out.println(base);
    }

    /* DELETE */
    private static void deleteBas() {
        System.out.println("Testing delete Base API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI+"/base/delete/3");
    }


    /* DELETE */
    private static void deleteAllSubjects() {
        System.out.println("Testing all delete Bases API----------");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(REST_SERVICE_URI + "/base/");
    }
}
