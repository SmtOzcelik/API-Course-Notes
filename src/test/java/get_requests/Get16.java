package get_requests;

import base_url.GorestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.GorestTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get16 extends GorestBaseUrl {
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
    public void get16(){
        //1-Set the url
        spec.pathParams("first","users","second",29);
        //2-Set the expectedData
        GorestTestData obj =new GorestTestData();
        Map<String,String> dataKeyMap=obj.dataKeyMapMetod("Resource not found");
        Map<String,Object>expectedData=obj.expectedDataMetodu(null,dataKeyMap);
        System.out.println(expectedData);
        //3-----
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //4----
        Map<String,Object>actualDataMap=response.as(HashMap.class);
        System.out.println(actualDataMap);
        assertEquals(expectedData.get("meta"),actualDataMap.get("meta"));
        assertEquals(dataKeyMap.get("message"),((Map)(actualDataMap.get("data"))).get("message"));


    }
}
