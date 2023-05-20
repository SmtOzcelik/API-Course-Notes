package patch_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Patch01 extends JsonplaceholderBaseUrl {
      /*
    Given
     1) https://jsonplaceholder.typicode.com/todos/198
     2) {
             "title": "Wash the dishes"
           }
    When
       I send PATCH Request to the Url
    Then
      Status code is 200
      And response body is like   {
                   "userId": 10,
                   "title": "Wash the dishes",
                   "completed": true,
                   "id": 198
                   }
    */
    @Test
    public void patch01(){
        //Set the url
        spec.pathParams("1","todos","2",198);
        //Set the expected data
        JsonPlaceHolderTestData obj=new JsonPlaceHolderTestData();
        Map<String,Object> expectedDataMap=obj.expectedDataMetodu(null,"Wash the dishes",null);

        //Send the Request and get the Response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().patch("/{1}/{2}");
        response.prettyPrint();
        //Do Assertion
        Map<String,Object>actualDataMap=response.as(HashMap.class);
        System.out.println(actualDataMap);
        assertEquals(200,response.statusCode());
        assertEquals(expectedDataMap.get("title"),actualDataMap.get("title"));




    }
}
