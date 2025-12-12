package api.config;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.BeforeAll;

public class ApiConfig {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }
}

