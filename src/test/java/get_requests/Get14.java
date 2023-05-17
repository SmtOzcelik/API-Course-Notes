package get_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get14 extends JsonplaceholderBaseUrl {
     /*
         Given
            https://jsonplaceholder.typicode.com/todos/2
        When
            I send GET Request to the URL
        Then
            Status code is 200
            And "completed" is false
            And "userId" is 1
            And "title" is "quis ut nam facilis et officia qui"
            And header "Via" is "1.1 vegur"
            And header "Server" is "cloudflare"
            {
                "userId": 1,
                "id": 2,
                "title": "quis ut nam facilis et officia qui",
                "completed": false
            }
     */
    @Test
    public void get(){
        //1-Set the url
        spec.pathParams("first","todos","second",2);
        //2-Set the expected data
        Map<String, Object>expectedData=new HashMap<>();
        expectedData.put("userId",1);
        expectedData.put("id",2);
        expectedData.put("title","quis ut nam facilis et officia qui");
        expectedData.put("completed",false);
        System.out.println("expectedData : "+expectedData);

        //3-Send the Request and get the Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4-Do Assertion
        // Status code is 200
        assertEquals(200,response.statusCode());
        // And header "Via" is "1.1 vegur"
        assertEquals("1.1 vegur",response.getHeader("Via"));
        // And header "Server" is "cloudflare"
        assertEquals("cloudflare",response.getHeader("Server"));


        Map<String,Object>actualData=response.as(HashMap.class);//De-Serialization yani json u java ya cevirdik
        System.out.println("actualData : "+actualData);

        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("id"),actualData.get("id"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));

        // Bu asagidaki ise önceki ögrendigimiz manuel karşılaştirdik
        response.then().assertThat().body("userId",equalTo(1));
        response.then().assertThat().body("id",equalTo(2));
        response.then().assertThat().body("title",equalTo("quis ut nam facilis et officia qui"));
        response.then().assertThat().body("completed",equalTo(false));

    }
}
