package get_requests;

import base_url.GorestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GorestDataPojo;
import pojos.GorestPojo;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get20Pojo extends GorestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users/2508
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
          {
            "meta": null,
            "data": {
                     "message": "Resource not found"
    }
}
    */
    @Test
    public void get20Pojo(){
        //Set the Url
        spec.pathParams("1","users","2",2508);
        //Set the expected data
        GorestDataPojo gorestDataPojo=new GorestDataPojo("Resource not found");
        System.out.println(gorestDataPojo);
        GorestPojo expectedDate=new GorestPojo(null,gorestDataPojo);
        System.out.println(expectedDate);
        //Send the Request and get the Response
        Response response=given().spec(spec).when().get("/{1}/{2}");
        GorestPojo actualData=response.as(GorestPojo.class);
        // Do assertions
        assertEquals(expectedDate.getMeta(),actualData.getMeta());
        assertEquals(gorestDataPojo.getMessage(),actualData.getData().getMessage());

    }
}
