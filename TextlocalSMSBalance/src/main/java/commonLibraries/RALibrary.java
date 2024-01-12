package commonLibraries;
import org.testng.annotations.Test;
import io.restassured.RestAssured.*;
import io.restassured.response.Response;
public class RALibrary {
@Test

	/**
	 * This method will return the json path
	 * @param resp
	 * @param jsonPath
	 * @return
	 */
	public String getJsonPath( Response resp, String jsonPath)
	{  
		String value = resp.jsonPath().get(jsonPath);
		return value;
      
	}	
}

