package get_requests;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;


import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class Get06 extends RestfulBaseUrl {
    /*
        Given https://restful-booker.herokuapp.com/booking/710
        When User send a GET request to the URL
        Then HTTP Status Code should be 200
        And Response content type is "application/json"
        And Response body should be like;
         {
    "firstname": "Josh",
    "lastname": "Allen",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {           // outer json
        "checkin": "2018-01-01", // inner json
        "checkout": "2019-01-01"  // inner json
    },
    "additionalneeds": "super bowls"
}

     */
    @Test
    public void get06(){
        //1-Set the Url
        spec.pathParams("first","booking","second",710);
        //2-Set the expected data

        //3-Send the Request and get the Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // 4-Do assertions
        //1.yol
        response.then().assertThat().statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",equalTo("Josh"),"lastname",equalTo("Allen"),
                        "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2018-01-01"),
                        "bookingdates.checkout",equalTo("2019-01-01"),
                        "additionalneeds",equalTo("super bowls"));
        //2.yol JsonPath class in kullanimi
        JsonPath json=response.jsonPath();
        assertEquals("Josh",json.getString("firstname"));
        assertEquals("Allen",json.getString("lastname"));
        assertEquals(111,json.getString("totalplace"));
        assertEquals("2018-01-01",json.getString("bookingdates.checkin"));
        assertEquals("2019-01-01",json.getString("bookingdates.checkout"));

        // 3.yol softAssert --> 3 aşamada gercekleşir
        // i) obje olusturma
        SoftAssert softAssert=new SoftAssert();
        // ii) Do Assertion(dogrula yapma)
        softAssert.assertEquals(json.getString("fisrtname"),"Json","Firstname Hatali");
        softAssert.assertEquals(json.getString("lastname"),"Allen","Lastname Hatali");
        softAssert.assertEquals(json.getString("totalplace"),111,"Total Price Hatali");
        softAssert.assertEquals(json.getString("bookingdates.checkin"),"2018-01-01","Check in Tarihi hatali");
        // iii)
        softAssert.assertAll();

    }
}
