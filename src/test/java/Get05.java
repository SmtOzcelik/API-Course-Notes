import base_url.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get05 extends RestfulBaseUrl {
     /*
        Given https://restful-booker.herokuapp.com/booking
        When User sends get request to the URL
        Then Status code is 200
        And Among the data there should be someone whose firstname is "Sally" and lastname is "Ericsson"
     */
    @Test
    public void get05(){
        // 1- Set the Url
        spec.pathParam("first","booking").queryParams("firstname","Sally","lastname","Ericsson");

        // 2- Set the expected Data

        // 3- Send The Request And get the Response
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        // 4- Do assertion
        assertEquals(200,response.getStatusCode());
        assertTrue(response.asString().contains("bookingid"));

    }
}
