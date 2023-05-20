package get_requests;

import base_url.RestfulBaseUrl;

public class Get19Pojo extends RestfulBaseUrl {
       /*
     Given
         https://restful-booker.herokuapp.com/booking/18
     When
         I send GET Request to the URL
     Then
        Status code is 200
     And
        Response body is like:
                       {
    "firstname": "John",
    "lastname": "Smith",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
    */
    public void get19Pojo(){
        //Set the url
        spec.pathParams("1","booking","2",18);
        // Set the expected data



    }
}
