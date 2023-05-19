package get_requests;

import base_url.GorestBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertTrue;

public class Get18_Body_And_JSonPath extends GorestBaseUrl {
     /*
    Given
        https://gorest.co.in/public/v1/users
    When
        User send GET Request
    Then
        The value of "pagination limit" is 10
    And
        The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
    And
        The number of users should  be 10
    And
        We have at least one "active" status --> en az bir "active" olacak
    And
        "Pres. Amarnath Dhawan","Sujata Chaturvedi","Navin Panicker" are among the users
    And
        The female users are less than or equals to male users
 */
    @Test
    public void get18(){
        //1-Set the Url
        spec.pathParam("first","users");
        //2-Set the expected data
        //3-Send the Request and get the Response
        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();
        //4-Do Assertion
        //The value of "pagination limit" is 10
        response.then().assertThat().body("meta.pagination.limit",equalTo(10));
        //The "current link" should be "https://gorest.co.in/public/v1/users?page=1"
        response.then().assertThat().body("meta.pagination.current",equalTo("https://gorest.co.in/public/v1/users?page=1"));
        //The number of users should  be 10
        response.then().assertThat().body("data",hasSize(10));
        //We have at least one "active" status --> en az bir "active" olacak
        response.then().assertThat().body("data.status",hasItem("active"));
        //"Pres. Amarnath Dhawan","Sujata Chaturvedi","Navin Panicker" are among the users
        response.then().assertThat().body("data.name",hasItems("Pres. Amarnath Dhawan","Sujata Chaturvedi","Navin Panicker"));
        //The female users are less than or equals to male users
        //Kadin ve erkek sayilarini karşilastiralim
        //1.yol
        JsonPath jsonPath=response.jsonPath();
        List<String>genders=jsonPath.getList("data.gender");
        System.out.println(genders);
        int kadinSayisi=0;
        for (String w:genders
             ) {
            if (w.equalsIgnoreCase("female")){
                kadinSayisi++;

            }
        }
        assertTrue(kadinSayisi<=genders.size()-kadinSayisi);
        //2.yol kadin ve erkek sayilarini Groovy ile bulalim



    }
}
