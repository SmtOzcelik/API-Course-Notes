package post_requests;

import base_url.JsonplaceholderBaseUrl;
import org.junit.Test;

public class Post03Pojo extends JsonplaceholderBaseUrl {
    /*
        Given
           https://jsonplaceholder.typicode.com/todos
           {
           "userId": 55,
           "title": "Tidy your room",
           "completed": false
           }
       When
           I send POST Request to the Url
       Then
           Status code is 201
       And
           response body is like {
                                   "userId": 55,
                                   "title": "Tidy your room",
                                   "completed": false,
                                   "id": 201
                                   }
    */
    @Test
    public void post03Pojo(){
        // Set the Url
        spec.pathParam("1","todos");
        // Send the Request and get the Response

    }
}
