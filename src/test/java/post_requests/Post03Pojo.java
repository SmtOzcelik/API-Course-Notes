package post_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlacePojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post03Pojo extends JsonplaceholderBaseUrl {
    /*
        Given
           https://jsonplaceholder.typicode.com/todos
           {
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
    public void post03Pojo(){
        // Set the Url
        spec.pathParam("1","todos");
        // Set the expected data
        JsonPlacePojo expectedData=new JsonPlacePojo(55,"Tidy your room",false);
        System.out.println("expectedData : "+expectedData);
        //Send the Request and get the Response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{1}");
        response.prettyPrint();
        // Do assertion
        assertEquals(201,response.statusCode());

        JsonPlacePojo actualData=response.as(JsonPlacePojo.class);
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());
    }
}
