package get_requests;

import base_url.GorestBaseUrl;
import org.junit.Test;

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


    }
}
