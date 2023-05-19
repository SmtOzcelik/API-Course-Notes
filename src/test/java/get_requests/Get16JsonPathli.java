package get_requests;

import base_url.GorestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get16JsonPathli extends GorestBaseUrl {
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
        //2-Set the expected data
        //3-Send the Request and get the Response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        //4-Do assertion
        JsonPath jsonPath=response.jsonPath();
        assertEquals(null,jsonPath.getString("meta"));
        assertEquals("Resource not found",jsonPath.getString("data.message"));

    }
}
