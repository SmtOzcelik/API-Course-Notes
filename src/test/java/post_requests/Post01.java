package post_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Post01 extends JsonplaceholderBaseUrl {
    /*
    Given
      1) https://jsonplaceholder.typicode.com/todos
      2) {
            "userId": 55,
            "title": "Tidy your room",
            "completed": false
                         }
   When
       I send POST Request to the Url
   Then
       Status code is 201
   And
       response body is like {
                               "userId": 55,
                               "title": "Tidy your room",
                               "completed": false,
                               "id": 201
                               }
     */
    @Test
    public void post01(){
        //Set the url
       spec.pathParam("1","todos");
       //Set the expected data
        JsonPlaceHolderTestData obj=new JsonPlaceHolderTestData();
        Map<String,Object>expectedDataMap=obj.expectedDataMetodu(55,"Tidy your room",false);
        //Send the Resquest and the get Response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().post("/{1}");
        response.prettyPrint();
        //Do Assertion
        Map<String,Object>actualDataMap=response.as(HashMap.class);
        assertEquals(expectedDataMap.get("completed"),actualDataMap.get("completed"));
        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));
        assertEquals(expectedDataMap.get("userId"),actualDataMap.get("userId"));


    }
}
