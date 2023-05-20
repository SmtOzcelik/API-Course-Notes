package post_requests;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.RestfulTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Post02 extends RestfulBaseUrl {
    /*
   Given
       1) https://restful-booker.herokuapp.com/booking
       2) {
            "firstname": "John",
            "lastname": "Doe",
            "totalprice": 11111,
            "depositpaid": true,
            "bookingdates": {
                "checkin": "2021-09-09",
                "checkout": "2021-09-21"
             }
          }
   When
       I send POST Request to the Url
   Then
       Status code is 200
       And response body should be like {
                                           "bookingid": 5315,
                                           "booking": {
                                               "firstname": "John",
                                               "lastname": "Doe",
                                               "totalprice": 11111,
                                               "depositpaid": true,
                                               "bookingdates": {
                                                   "checkin": "2021-09-09",
                                                   "checkout": "2021-09-21"
                                               }
                                           }
                                        }
    */
    @Test
    public void post02(){
        // Set the Url
        spec.pathParam("1","booking");
        //Set the expected data
        RestfulTestData obj=new RestfulTestData();
        Map<String,String>bookingdataMap=obj.bookingdatesMethod("2021-09-09","2021-09-21");

        Map<String,Object>expectedDataMap=obj.expectedDataMethod("John","Doe",11111,true,bookingdataMap);
        // Send the Resquest and get the response
        Response response=given().spec(spec).contentType(ContentType.JSON).body(expectedDataMap).when().post("/{1}");
        response.prettyPrint();

        //Do Assertions
        Map<String,Object>actualdataMap=response.as(HashMap.class);
        assertEquals(expectedDataMap.get("firstname"),((Map)actualdataMap.get("booking")).get("firstname"));
        assertEquals(expectedDataMap.get("lastname"),((Map)actualdataMap.get("booking")).get("lastname"));
        assertEquals(expectedDataMap.get("totalprice"),((Map)actualdataMap.get("booking")).get("totalprice"));
        assertEquals(expectedDataMap.get("depositpaid"),((Map)actualdataMap.get("booking")).get("depositpaid"));

        assertEquals(bookingdataMap.get("checkin"),((Map)((Map)actualdataMap.get("booking")).get("bookingdates")).get("checkin"));
        assertEquals(bookingdataMap.get("checkout"),((Map)((Map)actualdataMap.get("booking")).get("bookingdates")).get("checkout"));


    }
}
