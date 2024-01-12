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
import org.testng.annotations.Test;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;

public  class LagunaDeviceAPICommunication {
	 String  dateonly;
	 String lastcommunicationdate;
	 String dateandtime;
	@Test(priority=0)
    public void wwwloginrequest(){
   	 baseURI="https://www.cloudtesla.com";
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
         jObj.put("collection_name", "Laguna_F1");
         jObj.put("limit", 1);
     	 // Get the value of the "limit" key
         Response response2 = given()
     	.body(jObj)
     	.contentType(ContentType.JSON)
     	.when()
     	.post("/api_inmemory");
         int limit=(Integer) jObj.get("limit");
         String[] stringArray = new String[limit];
         for(int i=1;i<=limit;i++)
         {
       	  Object parameterValue_1packet = response2.jsonPath().get("data["+i+"-1].MP.MM[0]");
       	  Object dateAndTime = response2.jsonPath().get("data["+i+"-1].DT");
        
         String parametervalue = parameterValue_1packet.toString();
         stringArray[i-1] =parametervalue;
        
		 dateandtime = dateAndTime.toString();
         response2.then().log().all().assertThat().statusCode(200);
         System.out.println("parameter value"+parametervalue);
         try
         {
         System.out.println("date & time : "+dateandtime);
      // Parse the timestamp to Instant
         Instant instant = Instant.parse(dateandtime);

         // Convert to system default time zone
         ZoneId systemZone = ZoneId.systemDefault();
         ZonedDateTime zonedDateTime = instant.atZone(systemZone);

         // Format the date and time as needed
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
          //lastcommunicationdate = zonedDateTime.format(formatter);
           lastcommunicationdate = instant.atZone(ZoneOffset.UTC).format(formatter);

         DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
         LocalDateTime dateTime = LocalDateTime.parse(lastcommunicationdate, formatter3);
         
         // Extract the date
         dateonly = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
         
         System.out.println("Date only: " + dateonly);

         System.out.println("last communicated  Date and Time: " + lastcommunicationdate);
         LocalDate currentDate = LocalDate.now();

         // Define a custom date format if needed
         DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
         String systemdate = currentDate.format(formatter1);

         System.out.println("Current System Date: " + systemdate);
         if(dateonly.equals(systemdate)) {
       	  System.out.println("device is communicated on "+dateonly);
         }
         else {
       	  System.out.println("device is not communicated today");
       	  
         }
         
     } catch (Exception e) {
         e.printStackTrace();
     }
         
         
    }
   
   
}
	
@Test(priority=1)
public void telemessage() throws IOException, InterruptedException {
	Telegram_Connect tele=new Telegram_Connect();
	tele.lagunatelegramnotification("Laguna device last  communicated on "+lastcommunicationdate);
}
	
}
