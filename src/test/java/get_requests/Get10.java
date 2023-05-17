package get_requests;

import base_url.ReqresBaseUrl;
import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get10 extends ReqresBaseUrl {

    /*
   Given
       https://reqres.in/api/users/2
   When
       User send GET Request to the URL
   Then
       HTTP Status Code should be 200
   And
       Response format should be "application/json"
   And
       "email" is "janet.weaver@reqres.in",
   And
       "first_name" is "Janet"
   And
       "last_name" is "Weaver"
   And
       "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */

    @Test
    public void get10() {

        // Set the URL
        spec.pathParams("first", "api", "second", "users", "third",2);

        // 2. Set The Expected Data (Put, Post and Patch)

        // 3. Send The Request And Get The Response
        Response response = given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();

        // 4. Do Assertion
        // HTTP Status Code should be 200
        // Response format should be "application/json"
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

        /*
        "email" is "janet.weaver@reqres.in",
        "first_name" is "Janet",
        "last_name" is "Weaver",
         "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
         */
        response.then().assertThat().body("data.email", equalTo("janet.weaver@reqres.in"),
               "data.first_name", equalTo("Janet"),
               "data.last_name", equalTo("Weaver"),
                "support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));


    }
}