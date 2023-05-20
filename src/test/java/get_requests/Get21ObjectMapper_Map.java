package get_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import utils.ObjectMapperUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get21ObjectMapper_Map extends JsonplaceholderBaseUrl {
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
    @Test
    public void get21()  {
        // Set the Url
        spec.pathParams("first", "todos", "second", 198);
        //Set the expected data
        JsonPlaceHolderTestData obj=new JsonPlaceHolderTestData();
        String jsonString=obj.expectedDataInString(10,"quis eius est sint explicabo",true);
        Map<String,Object>expectedData=ObjectMapperUtils.convertJsonToJava(jsonString,HashMap.class);
        System.out.println("expectedData = " + expectedData);
        //Send the request and get the response
       Response response=given().spec(spec).when().get("/{first}/{second}");
       response.prettyPrint();
       //Do assertions
        Map<String,Object>actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),HashMap.class);

        assertEquals(200,response.statusCode());
        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));

    }
}
