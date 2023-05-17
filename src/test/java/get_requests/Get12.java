package get_requests;

import base_url.ReqresBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

public class Get12 extends ReqresBaseUrl {
    /*
        Given
          https://reqres.in/api/unknown/3
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type is "application/json"
        And
            Response body should be like;(Soft Assertion)
        {
        "data": {
            "id": 3,
            "name": "true red",
            "year": 2002,
            "color": "#BF1932",
            "pantone_value": "19-1664"
        },
        "support": {
            "url": "https://reqres.in/#support-heading",
            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
        }
}
      */
    @Test
    public void get12(){
        //1-Set the Url
        spec.pathParams("first","api","second","unknown","third",3);
        //2-Set the expected data
        //3-Send the Request and get the Response
        Response response=given().spec(spec).when().get("/{first}/{second}/{third}");
        response.prettyPrint();
        //4-Do Assertion
        SoftAssert softAssert=new SoftAssert();
        JsonPath jsonPath=response.jsonPath();

        System.out.println(jsonPath.getInt("data.id"));// body icindeki id ye ulastik
        softAssert.assertEquals(jsonPath.getInt("data.id"),"3");

        softAssert.assertEquals(jsonPath.getString("data.name"),"true red");

        softAssert.assertEquals(jsonPath.getInt("data.year"),2002);

        softAssert.assertEquals(jsonPath.getString("data.color"),"#BF1932");

        softAssert.assertEquals(jsonPath.getString("data.pantone_value"),"19-1664");

        softAssert.assertEquals(jsonPath.getString("support.url"),"https://reqres.in/#support-heading");

        softAssert.assertAll();


    }
}
