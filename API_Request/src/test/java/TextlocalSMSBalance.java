import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.port;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.json.simple.JSONObject;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

@Listeners(Isuitelistener_test.class)

public class TextlocalSMSBalance {
	public static int smsbalance;

    // Other methods and logic in TextlocalSMSBalance...

    public static int getSmsbalance() {
        return smsbalance;
        
    }
		@Test(priority=0)
	    public void wwwloginrequest(){
			 String parametervalue="";
		      System.setProperty("parameterFromTestMethod", parametervalue);
	   	 baseURI="https://e2e.cloudtesla.com";
	    	port=8006;
	    	//step 1:prerequisite
	    	JSONObject jo=new JSONObject();
	    	jo.put("request_type","login_request");
	    	jo.put("username","rafeek");
	    	jo.put("password", "Rafeek317322*");
	    	  Response response = given()
	    		     	.body(jo)
	    		     	.contentType(ContentType.JSON)
	    		     	.when()
	    		     	.post("/api_inmemory");
	         int statusCode = response.getStatusCode();
	         String responseBody = response.getBody().asString();
	         System.out.println("Status Code: " + statusCode);
	         System.out.println("Response Body: " + responseBody);
	         String key = response.jsonPath().get("key");
	         System.out.println(key);
	         response.then().log().all();  
	         System.out.println("loged in successfully"); 
	         JSONObject jObj=new JSONObject();
	         jObj.put("key",key);
	         jObj.put("request_type","read_collection");
	         jObj.put("collection_name", "textlocal_sms_balance");
	         jObj.put("limit", 1);
	     	 // Get the value of the "limit" key
	         Response response2 = given()
	     	.body(jObj)
	     	.contentType(ContentType.JSON)
	     	.when()
	     	.post("/api_inmemory");
	         if (response2.getStatusCode() == 200) {
	             // Extract the value "254" from the JSON response
	             Object valueToRetrieve = response2.path("data[0].MP.MM[0]");
	             //convert object to integer
	             System.out.println("Before setting smsbalance: " + getSmsbalance());
	             smsbalance = (int) valueToRetrieve;
	             System.out.println("After setting smsbalance: " + getSmsbalance());
	              System.out.println("smsbalance:"+smsbalance);
	              parametervalue = valueToRetrieve.toString();
	             System.out.println(parametervalue);

	             // Print or use the extracted value
	             System.out.println("Value retrieved: " + valueToRetrieve);
	         } else {
	             System.out.println("Failed to fetch data. HTTP Status Code: " + response2.getStatusCode());
	         }
	         System.out.println("Final smsbalance value: " + getSmsbalance());

	   
	   
	}
		
	@Test(priority=1)
	public void telemessage() throws IOException, InterruptedException {
		Telegram_Connect tele=new Telegram_Connect();
		
			
		tele.lagunatelegramnotification("current SMS Blance is  "+smsbalance);

	}
	
	
}
