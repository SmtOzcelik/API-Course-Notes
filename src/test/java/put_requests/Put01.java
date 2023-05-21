package put_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlacePojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Put01 extends JsonplaceholderBaseUrl {
    /*
    Given
     1) https://jsonplaceholder.typicode.com/todos/198
     2) {
             "userId": 21,
             "title": "Wash the dishes",
             "completed": false
           }
    When
         I send PUT Request to the Url
    Then
         Status code is 200
    And
         response body is like   {
                   "userId": 21,
                   "title": "Wash the dishes",
                   "completed": false
                  }
    */
    @Test
    public void put01(){
        //Set the url
        spec.pathParams("1","todos","2",198);
        //Set the expected data
        JsonPlacePojo expectedData=new JsonPlacePojo(21,"Wash the dishes",false);
        System.out.println("expectedData = " + expectedData);
        //Send the request and get the response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().put("/{1}/{2}");
        response.prettyPrint();
        //Do Assertion
        JsonPlacePojo actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPlacePojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());
        assertEquals(expectedData.getTitle(),actualData.getTitle());


    }
}
