package get_requests;

import base_url.GorestBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.GorestDataPojo;
import pojos.GorestPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get17 extends GorestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users/2986
        When
            User send GET Request to the URL
        Then
            Status Code should be 404
        And
            Response body should be like
            /*
            {
    "meta": null,
    "data": {
        "message": "Resource not found"
    }
}
         }
     */
    @Test
    public void test(){
        //1-Set the url
        spec.pathParams("1","users","2",2986);
        //2-Set the url
        GorestDataPojo gorestDataPojo=new GorestDataPojo("Resource not found");
        GorestPojo expectedData=new GorestPojo(null,gorestDataPojo);
        System.out.println("expectedData = " + expectedData);
        //3-Send the request and get the response
        Response response=given().spec(spec).when().get("{1}/{2}");
        response.prettyPrint();
        //4-Do Assertion
         GorestPojo actualData=ObjectMapperUtils.convertJsonToJava(response.asString(),GorestPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(expectedData.getMeta(),actualData.getMeta());
        assertEquals(gorestDataPojo.getMessage(),actualData.getData().getMessage());
        assertEquals(404,response.statusCode());

    }
}
