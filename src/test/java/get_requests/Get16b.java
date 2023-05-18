package get_requests;

import base_url.GorestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get16b extends GorestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users/29
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
            /*
            {
    "meta": null,
    "data": {
        "message": "Resource not found"
    }
}
     */
    @Test
    public void get16b(){
        //1-Set the url
        spec.pathParams("first","users","second",29);
        //2-Set the expected data
        Map<String,String>dataKeyMap=new HashMap<>();// ic map
        dataKeyMap.put("message","Resource not found");

        Map<String,Object>expectedMap=new HashMap<>();
        expectedMap.put("meta",null);
        expectedMap.put("data",dataKeyMap);
        System.out.println(expectedMap);
        //3-Send the Request and get the Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //4-Do Assertion
        Map<String,Object>actualMap=response.as(HashMap.class);
        //assertEquals(200,response.statusCode());
        assertEquals(expectedMap.get("meta"),actualMap.get("meta"));
        assertEquals(dataKeyMap.get("message"),((Map)(actualMap.get("data"))).get("message"));
    }
}
