import base_url.RestfulBaseUrl;

public class Get06 extends RestfulBaseUrl {
    /*
        Given https://restful-booker.herokuapp.com/booking/2325
        When User send a GET request to the URL
        Then HTTP Status Code should be 200
        And Response content type is "application/json"
        And Response body should be like;
         {
    "firstname": "Bradley",
    "lastname": "Pearson",
    "totalprice": 132,
    "depositpaid": false,
    "bookingdates": { ==> Outer JSON
        "checkin": "2022-10-27", ==> Inner JSON
        "checkout": "2022-11-07" ==> Inner JSON
    },
    "additionalneeds": "None"
}
     */
    public void get06(){

    }
}
