package get_requests;

import base_url.GorestBaseUrl;
import org.junit.Test;

public class Get16 extends GorestBaseUrl {
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
        //2-Set the expectedData

    }
}
