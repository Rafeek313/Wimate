package DataDrivenTesting;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class MultipleUserLogin {
@Test(dataProvider="getData")
public void multipleUserLogin(String username,String password) {
	baseURI="https://e2e.cloudtesla.com";
	port=8006;
	JSONObject jo=new JSONObject();
	jo.put("request_type","login_request");
	jo.put("username",username);
	jo.put("password", password);
	
	given().body(jo).contentType(ContentType.JSON).when().post("/api_inmemory").then().log().all();
}
@DataProvider(name="getData")
public Object[][] data(){
Object[][] data=new Object[3][2];
data[0][0]="rafeek";
data[0][1]="Rafeek317322*";

data[1][0]="divya";
data[1][1]="June13@off";


data[2][0]="rohit";
data[2][1]="Rohitm@007";

return data;
}
{
	
}
}
