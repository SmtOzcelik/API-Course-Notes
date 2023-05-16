import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

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
        response.prettyPrint()

        // 4-Do assertions
        response.then().assertThat().statusCode(200).
                contentType(ContentType.JSON).
                body("firstname",equalTo("Josh"),"lastname",equalTo("Allen"),
                        "totalprice",equalTo(111),
                        "depositpaid",equalTo(true),
                        "bookingdates.checkin",equalTo("2018-01-01"),
                        "bookingdates.checkout",equalTo("2019-01-01"),
                        "additionalneeds",equalTo("super bowls"));

    }
}
