
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import ProjectLibrary.PojoClass;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;



import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class Api_inmemory_req {
	
    @Test
    public void loginrequestAutomation() {
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
    
    }
    @Test
    public void param_req() {
    	baseURI="https://e2e.cloudtesla.com";
    	port=8006;
    	//step 1:prerequisite
    	JSONObject jo=new JSONObject();
    	jo.put("key","tWbm6yDizVDoeBTD");
    	jo.put("request_type","read_collection");
    	jo.put("collection_name", "system_info_1");
    	jo.put("limit", 1);
    	jo.put("query", "{}");
        Response response = given()
    	.body(jo)
    	.contentType(ContentType.JSON)
    	.when()
    	.post("/api_inmemory");
        Float pid1 = response.jsonPath().get("data[0].MP.MM[33]");
        Float pid2 = response.jsonPath().get("data[0].MP.MM[30]");
       String str1 = pid1.toString();
       String str2 = pid2.toString();
       
       LocalDateTime currentTime = LocalDateTime.now(); // Gets the current system time
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       String formattedTime = currentTime.format(formatter);
        System.out.println(" Current time & pmem inmemory VALUE "+formattedTime+" "+str1);
        System.out.println(" Current time & pcpu inmemory  VALUE "+formattedTime+" "+str2);
        response.then().log().all().assertThat().statusCode(200);

    
    }
    @Test
    public void multiple_param_req() {
    	baseURI="https://e2e.cloudtesla.com" ;
    	port=8006;
    	//step 1:create prerequisite
    	JSONObject jo=new JSONObject();
    	jo.put("key","tWbm6yDizVDoeBTD");
    	jo.put("request_type","read_collection");
    	jo.put("collection_name", "system_info_1");
    	jo.put("limit", 1);
    	jo.put("query", "{}");
    	// Get the value of the "limit" key
        Response response = given()
    	.body(jo)
    	.contentType(ContentType.JSON)
    	.when()
    	.post("/api_inmemory");
        int limit=(Integer) jo.get("limit");
        System.out.println("limt="+ limit);
        String[] stringArray = new String[limit];
        for(int i=1;i<=limit;i++)
        {
        Object parameterValue_1packet = response.jsonPath().get("data["+i+"-1].MP.MM[33]");
     // Create an array of float values
        String parametervalue = parameterValue_1packet.toString();
        stringArray[i-1] =parametervalue;
        response.then().log().all().assertThat().statusCode(200);
    }
     // Print the string array
        for (String str : stringArray) {
            System.out.println(str);
        }
    }
     @Test
     public void request_chaining() {
     	baseURI="https://e2e.cloudtesla.com" ;
     	port=8006;
     	// step 1:prerequisite
     	JSONObject jo=new JSONObject();
     	jo.put("request_type","login_request");
     	jo.put("username","rafeek");
     	jo.put("password", "Rafeek317322*");
     	 Response response = given()
  		     	.body(jo)
  		     	.contentType(ContentType.JSON)
  		     	.when()
  		     	.post("/api_inmemory");
          String key = response.jsonPath().get("key");
          response.then().log().all();
          System.out.println("login successfully");
          JSONObject jObj=new JSONObject();
          jObj.put("key",key);
          jObj.put("request_type","read_collection");
          jObj.put("collection_name", "system_info_1");
          jObj.put("limit", 1);
          jObj.put("query", "{}");
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
          Object parameterValue_1packet = response2.jsonPath().get("data["+i+"-1].MP.MM[33]");
         //Create an array of float values
          String parametervalue = parameterValue_1packet.toString();
          stringArray[i-1] =parametervalue;
          response2.then().log().all().assertThat().statusCode(200);
      }
        // Print the string array
          for (String str : stringArray) {
        	  LocalDateTime currentTime = LocalDateTime.now(); // Gets the current system time
              DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
              String formattedTime = currentTime.format(formatter);
             System.out.println("Date & time:value = "+formattedTime+" : "+str);
         } 
    	
    }
     
}
