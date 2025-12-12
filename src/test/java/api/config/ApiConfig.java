package api.config;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ApiConfig {
    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://api.example.com";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }
}
