package api.tests;

import api.config.ApiConfig;
import api.models.SampleRequest;
import api.models.SampleResponse;
import api.steps.ApiSteps;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApiSampleTest extends ApiConfig {

    private final ApiSteps api = new ApiSteps();

    @Test
    public void testCreateSampleReturns201AndHasId() {
        SampleRequest request = new SampleRequest("Paola Ortiz", "QA Engineer");
        Response response = api.createSample(request);

        // Validaciones básicas
        Assertions.assertEquals(201, response.getStatusCode(), "Status code debe ser 201");
        // La API de reqres devuelve id y createdAt al crear un usuario
        String body = response.getBody().asString();
        Assertions.assertTrue(body.contains("id"), "Respuesta debe contener 'id'");
        Assertions.assertTrue(body.contains("createdAt"), "Respuesta debe contener 'createdAt'");
    }

    @Test
    public void testCreateSampleDeserialize() {
        SampleRequest request = new SampleRequest("John Doe", "Tester");
        SampleResponse respObj = api.createSampleAndDeserialize(request);

        Assertions.assertNotNull(respObj.getId(), "El id no debe ser nulo");
        Assertions.assertEquals("John Doe", respObj.getName(), "El nombre devuelto debe coincidir");
    }

    @Test
    public void testGetUserById() {
        Response r = api.getUserById(2);
        Assertions.assertEquals(200, r.getStatusCode());
        // valida que venga data.id == 2 (estructura específica de reqres)
        int id = r.then().extract().path("data.id");
        Assertions.assertEquals(2, id);
    }
}

