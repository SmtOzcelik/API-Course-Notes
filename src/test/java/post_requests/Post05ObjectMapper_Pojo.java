package post_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlacePojo;
import test_data.JsonPlaceHolderTestData;
import utils.ObjectMapperUtils;

import java.util.Random;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post05ObjectMapper_Pojo extends JsonplaceholderBaseUrl {
    /*
         Given
           1) https://jsonplaceholder.typicode.com/todos
           2) {
                 "userId": 55,
                 "title": "Tidy your room",
                 "completed": false
               }
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
    public void post05(){
        //Set the Url
        spec.pathParam("1","todos");
        //Set the expected data
        JsonPlacePojo expectedData=new JsonPlacePojo(55,"Tidy your room",false);
        System.out.println("expectedData = " + expectedData);
        //Send the request and the response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{1}");
        response.prettyPrint();
        //Do assertion
        JsonPlacePojo actualData =ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPlacePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(201,response.statusCode());
        assertEquals(expectedData.getUserId(),actualData.getUserId());
        assertEquals(expectedData.getCompleted(),actualData.getCompleted());
        assertEquals(expectedData.getTitle(),actualData.getTitle());

    }

}
