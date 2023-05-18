package get_requests;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get15 extends RestfulBaseUrl {
    /*
      Given
          https://restful-booker.herokuapp.com/booking/91
      When
          I send GET Request to the url
      Then
          Response body should be like that;
           {
    "firstname": "Josh",
    "lastname": "Allen",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "super bowls"
}
   */
    @Test
    public void get15(){
        //1-Set the Url
        spec.pathParams("first","booking","second",91);
        //2-Set the expected data
        Map<String,String> bookindatesMap=new HashMap<>(); // ic Map olusturduk
        bookindatesMap.put("checkin","2018-01-01");
        bookindatesMap.put("checkout","2019-01-01");

        Map<String, Object>expectedDataMap=new HashMap<>(); // dis Map expectedMap
        expectedDataMap.put("firstname","Josh");
        expectedDataMap.put("lastname","Allen");
        expectedDataMap.put("totalprice",111);
        expectedDataMap.put("depositpaid",true);
        expectedDataMap.put("bookingdates",bookindatesMap);
        expectedDataMap.put("additionalneeds","super bowls");
        System.out.println(expectedDataMap);

        //3-Send the Request and get the Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //4-Do Assertion
        Map<String,Object>actualDataMap=response.as(HashMap.class);
        assertEquals(expectedDataMap.get("firstname"),actualDataMap.get("firstname"));
        assertEquals(expectedDataMap.get("lastname"),actualDataMap.get("lastname"));
        assertEquals(expectedDataMap.get("totalprice"),actualDataMap.get("totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"),actualDataMap.get("depositpaid"));
        assertEquals(expectedDataMap.get("additionalneeds"),actualDataMap.get("additionalneeds"));
        assertEquals(bookindatesMap.get("checkin"),((Map)(actualDataMap.get("bookingdates"))).get("checkin"));
        // Key value ikilileri String-Object seklinde oldugundan Bookingdates value kısmini casting ile map yaptik
        assertEquals(bookindatesMap.get("checkout"),((Map)(actualDataMap.get("bookingdates"))).get("checkout"));






    }
}
