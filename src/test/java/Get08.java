import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class Get08 {
     /*
   Given https://reqres.in/api/users/3
   When User sends a GET Request to the url
   Then HTTP Status Code should be 200
   And  Content Type should be JSON
   And Status Line should be HTTP/1.1 200 OK
    */

    @Test
    public void get08(){
    // 1-Set the url
        String url="https://reqres.in/api/users/3";
    //2-Set the expected data

    //3-Send the Request and get the Response
        Response response=given().when().get(url);
        response.prettyPrint();
    //4-Do Assertion
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");


    }
}
