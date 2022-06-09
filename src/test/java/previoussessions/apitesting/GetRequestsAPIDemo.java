package previoussessions.apitesting;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ExecuteRequest;
import utils.GlobalVariables;

import static io.restassured.RestAssured.given;
public class GetRequestsAPIDemo {

    private Object jsonObject;

    @Test(groups = {"get"})
    public void buildGetRequest(){
        RestAssured.baseURI = "http://localhost:5000";
        Response response = given()
                .contentType(ContentType.JSON)
                .when()
                .get("/users/findbyid/5")
                .then()
                .extract().response();

        System.out.println(response.getBody().prettyPrint());
    }

    @Test(groups = {"getAll","get"})
    public void getAllUsers(){
        String url = GlobalVariables.apiHost +  "/users/all";
        Response response =  ExecuteRequest.makeGetRequest(url);
        System.out.println(response.asString());
        JSONArray jsonArray = new JSONArray(response.asString());
        System.out.println(jsonArray.toString(10));
        System.out.println(jsonArray.length());
        if(jsonArray.length() > 10){
            Assert.fail("Length should be 10");
        }
    }

    @Test(groups = {"countUsers"})
    public void countUsernamesWithNumberFive(){
        int contador = 0;
        String url = GlobalVariables.apiHost +  "/users/all";
        Response response =  ExecuteRequest.makeGetRequest(url);
        System.out.println(response.asString());
        JSONArray jsonArray = new JSONArray(response.asString());
        for (int i = 0; i < jsonArray.length(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            String userName = jsonObject.getString("username");
            if (userName.contains("5")) contador++;
        }
        System.out.println("El numero de usuarios que contienen el numero 5 es: " + contador);

    }

    @Test
    public void findById(){
        String url = GlobalVariables.apiHost +  "/users/findbyid/5";
        Response response = ExecuteRequest.makeGetRequest(url);
        System.out.println(response.asString());
        JSONObject jsonArray = new JSONObject(response.asString());
        System.out.println(jsonArray.toString(10));
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().get("id").toString(), "5");
    }

}
