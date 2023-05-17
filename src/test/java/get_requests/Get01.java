package get_requests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Get01 {
    /*
    1) Postman, manuel API testleri icin kullandik.
    2) otomasyon testleri icin de Rest Assured Library kullanacagiz
    3) Otomasyon testlerimizi yaparken asagidaki adimlari izliyoruz
        a) Gereksinimleri anlamak,
        b) Test Case yaziyoruz
            i) Test Case yaziliminda "Gherkin" dilini kullanacağiz. Bizler yazilim diline hakim
               olsakda ,karşimizdaki hakim olmayabilir.Gherkin ile yazilan testleri anlamak ta
               zorluk cekmeyeceklerdi

               -Given : On kosullar
               -When  : Yapilacak aksiyonlar icin (get(),put(),post(),patch() ve delete())
               -Then  : Istek yaptiktan (request gonderdikten sonra) dogrulama
               -And   : Coklu islemlerde kullanacağiz

        c) Test kodlarimizi yazmaya baslayacagız

            i)   Set the URL,
            ii)  Set the expected Data (beklenen datanin olusturulmasi post,put,patch)
            iii) Type code to send request (talep göndermek icin kod yazimi)
            iv)  Do Assertion (dogrulama yapmak)

     */
    /*
    Given https://restful-booker.herokuapp.com/booking/344
    When user sends a GET Request to the url
    Then HTTP Status Code should be 200
    And Content Type should be JSON
    And Status Line should be HTTP/1.1 200 OK
     */
    @Test
    public void get(){
       //  i)   Set the URL
        String url="https://restful-booker.herokuapp.com/booking/344";

      //  ii)  Set the expected Data (beklenen datanin olusturulmasi post,put,patch)
      // bizden post,put yada patch istenmedigi icin bu case de kullanmayacagiz

      //  iii) Type code to send request (talep göndermek icin kod yazimi)
        Response response=given().when().get(url);
       // response.prettyPrint();

        //iv)  Do Assertion (dogrulama yapmak)

        response.then().assertThat().statusCode(200).contentType("application/json").statusLine("HTTP/1.1 200 OK");

        //Status Code Konsola yazdiralim
        System.out.println("Status Code : " +response.getStatusCode());

        // Content Type konsola yazdiralim
        System.out.println("Content Type : "+response.getContentType());

        // Status Line konsola yazdiralim
        System.out.println("Status Line : "+response.getStatusLine());

        //Header konsola yazdiralim
        System.out.println("Header : "+response.getHeader("Server"));

        //Headers konsola yazdiralim
        System.out.println("Headers : "+response.getHeaders());

        // Time konsola yazdiralim
        System.out.println("Time : "+response.getTime());
    }

}
