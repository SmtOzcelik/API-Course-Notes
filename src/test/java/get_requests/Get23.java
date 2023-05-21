package get_requests;

import base_url.RestfulBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get23 extends RestfulBaseUrl {
    /*
    bu soru pojo class ve ObjectMapper ile cözüm
        Given
	            https://restful-booker.herokuapp.com/booking/194
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
                  {
    "firstname": "Josh",
    "lastname": "Allen",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Extra pillows please"
}
     */
    @Test
    public void get23(){
        //Set the url
        spec.pathParams("1","booking","2",194);
        //Set the expected data
        BookingDatesPojo bookingDates=new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expectedData=new BookingPojo("Josh","Allen",111,true,bookingDates,"Extra pillows please");
        System.out.println("expectedData = " + expectedData);
        //Send the requets and the response
        Response response=given().spec(spec).when().get("/{1}/{2}");
        response.prettyPrint();
        //Do assertions
        assertEquals(200,response.statusCode());
       BookingPojo actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),BookingPojo.class);
       System.out.println("actualData = " + actualData);
       assertEquals(expectedData.getFirstname(),actualData.getFirstname());
       assertEquals(expectedData.getLastname(),actualData.getLastname());
       assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
       assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
       assertEquals(bookingDates.getCheckin(),actualData.getBookingdates().getCheckin());
       assertEquals(bookingDates.getCheckin(),actualData.getBookingdates().getCheckin());

       //Soft Assertion
        //1.Adim : SoftAssert Objesi olustur
        SoftAssert softAssert=new SoftAssert();

        //2.Adim Assertion yap
        softAssert.assertEquals(actualData.getFirstname(),expectedData.getFirstname(),"Fisrtname uyusmadi");
        softAssert.assertEquals(actualData.getLastname(),expectedData.getLastname(),"Lastname uyusmadi");
        softAssert.assertEquals(actualData.getTotalprice(),expectedData.getTotalprice(),"Totalprice uyusmadi");
        softAssert.assertEquals(actualData.getBookingdates().getCheckin(),bookingDates.getCheckin(),"Checkin uyusmadi");
        softAssert.assertEquals(actualData.getBookingdates().getCheckout(),bookingDates.getCheckout(),"Checkout uyusmadi");

        //3.Adim assertAll() methodu kullan
        softAssert.assertAll();




    }
}
