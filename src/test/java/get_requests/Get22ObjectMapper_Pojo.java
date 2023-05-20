package get_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlacePojo;
import utils.ObjectMapperUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get22ObjectMapper_Pojo extends JsonplaceholderBaseUrl {
    /*
       Given
           https://jsonplaceholder.typicode.com/todos/198
       When
            I send GET Request to the URL
        Then
            Status code is 200
            And response body is like {
                                       "userId": 10,
                                       "id": 198,
                                       "title": "quis eius est sint explicabo",
                                       "completed": true
                                     }
    */
    // ObjectMapper + Pojo=En iyi Yöntem
    @Test
    public void get22(){
        //Set the url
        spec.pathParams("1","todos","2",198);
        //Set the expected data
        JsonPlacePojo expectedData=new JsonPlacePojo(10,"quis eius est sint explicabo",true);
        System.out.println("expectedData = " + expectedData);
        //Send the request and the response
        Response response=given().spec(spec).when().get("/{1}/{2}");
        response.prettyPrint();
        //Do assertion
        JsonPlacePojo actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPlacePojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(200,response.statusCode());
        assertEquals(expectedData.getTitle(),actualData.getTitle());
        assertEquals(expectedData.getCompleted(),expectedData.getCompleted());
        assertEquals(expectedData.getUserId(),actualData.getUserId());



    }
}
