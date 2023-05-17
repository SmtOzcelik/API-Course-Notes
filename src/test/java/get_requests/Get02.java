package get_requests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class Get02 {
    /*
    Given https://restful-booker.herokuapp.com/booking/2500
    When User send a GET Request to the url
    Then HTTP Status code should be 404
    And Status Line should be HTTP/1.1 404 Not Found
    And Response body contains "Not Found"
    And Response body does not contain "HepsiBurada"
    And Server is "Cowboy"
     */
    @Test
    public void get01(){
        //  i)   Set the URL
        String url="https://restful-booker.herokuapp.com/booking/2500+";
        //  ii)  Set the expected Data (beklenen datanin olusturulmasi post,put,patch)
        // bizden post,put yada patch istenmedigi icin bu case de kullanmayacagiz

        //  iii) Type code to send request (talep göndermek icin kod yazimi)
        Response response=given().when().get(url);
        //response.prettyPrint();

        //iv)  Do Assertion (dogrulama yapmak)
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        //Body Not Found iceriyor mu testi yapildi
        assertTrue(response.asString().contains("Not Found"));

        //Body nin HepsiBurada icermedigi test yapildi
        assertFalse(response.asString().contains("HepsiBurada"));

        //Server in Cowboy olup oldugunu test ediyoruz
        assertEquals("Cowboy",response.getHeader("server"));


    }
}
