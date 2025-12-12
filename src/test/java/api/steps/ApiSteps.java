package api.steps;

import api.models.SampleRequest;
import api.models.SampleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class ApiSteps {

    private final ObjectMapper mapper = new ObjectMapper();

    /**
     * Crea un recurso "sample" en reqres.in: POST /users
     * Retorna la respuesta Http completa.
     */
    public Response createSample(SampleRequest request) {
        return given()
                .contentType("application/json")
                .body(request)
                .when()
                .post("/users");
    }

    /**
     * Crea y devuelve el objeto SampleResponse deserializado (útil para aserciones).
     * Lanza RuntimeException si la deserialización falla.
     */
    public SampleResponse createSampleAndDeserialize(SampleRequest request) {
        Response resp = createSample(request);
        try {
            return mapper.readValue(resp.getBody().asString(), SampleResponse.class);
        } catch (IOException e) {
            throw new RuntimeException("Error deserializando respuesta", e);
        }
    }

    /**
     * GET /users/{id} (endpoint público de ejemplo).
     */
    public Response getUserById(int id) {
        return given()
                .when()
                .get("/users/" + id);
    }
}
