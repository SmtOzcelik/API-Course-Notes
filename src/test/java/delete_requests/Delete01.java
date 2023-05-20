package delete_requests;

import base_url.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import utils.ObjectMapperUtils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Delete01 extends JsonplaceholderBaseUrl {
    /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is { }
     */
    @Test
    public void delete01(){
        //Set the url
        spec.pathParams("1","todos","2",198);
        // Set the expected data

        //Send the request and get the response
        Response response=given().spec(spec).when().delete("/{1}/{2}");
        // Do assertions
       Map<String,Object>actualData=ObjectMapperUtils.convertJsonToJava(response.asString(), HashMap.class);
       assertEquals(200,response.statusCode());
       //1.yol
       assertTrue(actualData.isEmpty());
        //2.yol
        assertEquals(0,actualData.size());
    }
}
