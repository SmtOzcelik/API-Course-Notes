package get_requests;

import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get11 extends RestfulBaseUrl {
    /*
    Given
        https://restful-booker.herokuapp.com/booking?firstname=Josh&lastname=Allen
    When
        User sends get request to the URL
    Then
        Status code is 200
    And
         Among the data there should be someone whose firstname is "John" and lastname is "Allen"

    */
    @Test
    public void get11(){
        //1-Set the Url
        spec.pathParam("first","booking").queryParams("firstname","Josh","lastname","Allen");
        //2-Set the expected data
        //3-Send the Request and get the Response
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        //4-Do Assertion
        assertEquals(200,response.statusCode());
        assertTrue(response.asString().contains("bookingid"));


    }
}
