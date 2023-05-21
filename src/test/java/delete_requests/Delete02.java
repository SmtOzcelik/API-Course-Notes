package delete_requests;

import base_url.DummyRestApiBaseUrl;

public class Delete02 extends DummyRestApiBaseUrl {
    /*
     URL: https://dummy.restapiexample.com/api/v1/delete/2
     HTTP Request Method: DELETE Request
     Test Case: Type by using Gherkin Language
     Assert:     i) Status code is 200
                 ii) "status" is "success"
                 iii) "data" is "2"
                 iv) "message" is "Successfully! Record has been deleted"

     Given
        URL: https://dummy.restapiexample.com/api/v1/delete/2
     When
        HTTP Request Method: DELETE Request
        Test Case: Type by using Gherkin Language
     Then
        i) Status code is 200
     And
        ii) "status" is "success"
     And
        iii) "data" is "2"
     And
        iv) "message" is "Successfully! Record has been deleted"
       */
    public void delete02(){
        //Set the url
        spec.pathParams("1","delete","2",2);
        //Set the expected data



    }

}
