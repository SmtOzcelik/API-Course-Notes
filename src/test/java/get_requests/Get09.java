package get_requests;

import base_url.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get09 extends ReqresBaseUrl {
    /*
   Given
       https://reqres.in/api/users/23
   When
       User send a GET Request to the url
   Then
       HTTP Status code should be 403
   And
       Status Line should be HTTP/1.1 403 Forbidden
   And
       Server is null
   And
       Response body should be empty

    */
    @Test
    public void get09(){
    //1-Set the url
        spec.pathParams("first","api","second","users","third",23);
    //2-Set the expected data

    //3-Send the Requals and get the Response
        Response response=given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

    //4-Do Assertion
        assertEquals(403,response.statusCode());
        assertEquals("HTTP/1.0 403 Forbidden",response.statusLine());
        assertEquals(null,response.getHeader("Server"));


    }
}
