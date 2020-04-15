
package com.mycompany.testesfuncionais;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class ApiTest {

    @Test
    public void getAllCountriesTest() {
        String uriBase = "http://localhost:8080/api/allCountries";

        given()
                .relaxedHTTPSValidation()
                .when()
                .get(uriBase)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);     
    }

    @Test
    public void getAllStatesTest() {
        String uriBase = "http://localhost:8080/api/allStates";

        given()
                .relaxedHTTPSValidation()
                .when()
                .get(uriBase)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);     

    }
    
    @Test
    public void getAllCitiesTest() {
        String uriBase = "http://localhost:8080/api/allCities";

        given()
                .relaxedHTTPSValidation()
                .when()
                .get(uriBase)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);     

    }
    
    @Test
    public void getAllPollutionTest() {
        String uriBase = "http://localhost:8080/api/allPollution";

        given()
                .relaxedHTTPSValidation()
                .when()
                .get(uriBase)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);     

    }

    @Test
    public void getAllWeatherTest() {
        String uriBase = "http://localhost:8080/api/allPollution";

        given()
                .relaxedHTTPSValidation()
                .when()
                .get(uriBase)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);     

    }
    
    @Test
    public void getStatesByCountryTest() {
        String uriBase = "http://localhost:8080/api/states/Angola";

        given()
                .relaxedHTTPSValidation()
                .when()
                .get(uriBase)
                .then()
                .statusCode(200) 
                .contentType(ContentType.JSON)
                .body("get(0).state", equalTo("Luanda"))
                .body("get(0).country", equalTo("Angola"));
                
                
                

    }
    
    @Test
    public void getCitiesByCountryAndStateTest() {
        String uriBase = "http://localhost:8080/api/cities/Angola/Luanda";

        given()
                .relaxedHTTPSValidation()
                .when()
                .get(uriBase)
                .then()
                .statusCode(200) 
                .contentType(ContentType.JSON)
                .body("get(0).city", equalTo("Luanda"))
                .body("get(0).state", equalTo("Luanda"))
                .body("get(0).country", equalTo("Angola"));
                
                
                

    }
   
    @Test
    public void getPollutionByCountryAndStateAndCityTest() {
        String uriBase = "http://localhost:8080/api/pollution/Angola/Luanda/Luanda";

        given()
                .relaxedHTTPSValidation()
                .when()
                .get(uriBase)
                .then()
                .statusCode(200) 
                .contentType(ContentType.JSON)
                .body("get(0).city", equalTo("Luanda"))
                .body("get(0).state", equalTo("Luanda"))
                .body("get(0).country", equalTo("Angola"));
                
                
                

    }
    
    @Test
    public void getWeatherByCountryAndStateAndCityTest() {
        String uriBase = "http://localhost:8080/api/weather/Angola/Luanda/Luanda";

        given()
                .relaxedHTTPSValidation()
                .when()
                .get(uriBase)
                .then()
                .statusCode(200) 
                .contentType(ContentType.JSON)
                .body("get(0).city", equalTo("Luanda"))
                .body("get(0).state", equalTo("Luanda"))
                .body("get(0).country", equalTo("Angola"));
                
                
                

    }
    
    @Test
    public void getCurrentPollutionByCountryAndStateAndCityTest() {
        String uriBase = "http://localhost:8080/api/currentPollution/Angola/Luanda/Luanda";

        given()
                .relaxedHTTPSValidation()
                .when()
                .get(uriBase)
                .then()
                .statusCode(200) 
                .contentType(ContentType.JSON)
                .body("city", equalTo("Luanda"))
                .body("state", equalTo("Luanda"))
                .body("country", equalTo("Angola"));
                
                
                

    }
    
    @Test
    public void getCurrentWeatherByCountryAndStateAndCityTest() {
        String uriBase = "http://localhost:8080/api/currentWeather/Angola/Luanda/Luanda";

        given()
                .relaxedHTTPSValidation()
                .when()
                .get(uriBase)
                .then()
                .statusCode(200) 
                .contentType(ContentType.JSON)
                .body("city", equalTo("Luanda"))
                .body("state", equalTo("Luanda"))
                .body("country", equalTo("Angola"));
                
                
                

    }
}



