package get_requests;

import base_url.DummyRestApiBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class Get24_Onemli extends DummyRestApiBaseUrl {
     /*
          URL: https://dummy.restapiexample.com/api/v1/employees
          HTTP Request Method: GET Request
          Test Case: Type by using Gherkin Language
          Assert:  i) Status code is 200
                  ii) There are 24 employees
                 iii) "Tiger Nixon" and "Garrett Winters" are among the employees
                  iv) The greatest age is 66
                   v) The name of the lowest age is "Tatyana Fitzpatrick"
                  vi) Total salary of all employees is 6,644,770
   */
    /*
   Given
        https://dummy.restapiexample.com/api/v1/employees
   When
        user send get request
   Then
   And
        i) Status code is 200
   And
        ii) There are 24 employees
   And
        iii) "Tiger Nixon" and "Garrett Winters" are among the employees
   And
        iv) The greatest age is 66
   And
        v) The name of the lowest age is "Tatyana Fitzpatrick"
   And
        vi) Total salary of all employees is 6,644,770
     */
    @Test
    public void get(){
        //Set the url
        spec.pathParam("1","employees");
        //Set the expected data
        // get işleminde genelde pojo objectMapper kullanmiyoruz
        //Send the request and the response
        Response response=given().spec(spec).when().get("/{1}");
        response.prettyPrint();
        //Do assertions
        //assertEquals(200,response.statusCode());

        //ii) There are 24 employees
        response.then().assertThat().body("data",hasSize(24));

        //"Tiger Nixon" and "Garrett Winters" are among the employees
        response.then().assertThat().body("data.employee_name",hasItems("Tiger Nixon","Garrett Winters"));

        //iv) The greatest age is 66
        List<Integer> agesList=response.jsonPath().getList("data.employee_age");
        System.out.println("agesList = " + agesList);
        Collections.sort(agesList);
        System.out.println("Siralanmis agesList = " + agesList);
        int enBuyukYas=agesList.get(agesList.size()-1);
        assertEquals(66,enBuyukYas);

        //v) The name of the lowest age is "Tatyana Fitzpatrick"
        String lowestAgeEmployee=response.jsonPath().getString("data.findAll{it.employee_age=="+agesList.get(0)+"}.employee_name");
        System.out.println(lowestAgeEmployee);
        assertEquals("[Tatyana Fitzpatrick]",lowestAgeEmployee);

        //vi) Total salary of all employees is 6,644,770
        List<Integer>salaryList=response.jsonPath().getList("data.findAll{it.employee_salary}.employee_salary");
        System.out.println("salaryList = " + salaryList);
        int toplam=0;
        for (Integer w:salaryList
             ) {
            toplam+=w;

        }
        System.out.println("toplam salary : "+toplam);
        assertEquals(6644770,toplam);


    }

}
