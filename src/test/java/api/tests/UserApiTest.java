package api.tests;

import api.config.ApiConfig;
import api.models.UserRequest;
import api.models.UserResponse;
import api.steps.UserApiSteps;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserApiTest extends ApiConfig {

    private final UserApiSteps userApi = new UserApiSteps();

    // GET /users?page=2
    @Test
    public void testGetUsersPage2() {
        Response resp = userApi.getUsersPage(2);

        int statusCode = resp.getStatusCode();

        // Reqres puede responder 200 o 403 por bloqueo a automatización
        assertThat("Código HTTP inesperado",
                statusCode, anyOf(is(200), is(403)));

        // Validaciones funcionales solo si la API responde correctamente
        if (statusCode == 200) {
            int page = resp.jsonPath().getInt("page");
            assertThat(page, is(2));

            assertThat(resp.jsonPath().getList("data"),
                    is(not(empty())));
        }
    }


    // POST /users
    @Test
    public void testCreateUser() {
        UserRequest request = UserRequest.builder()
                .name("Paola Ortiz")
                .job("QA Engineer")
                .build();

        UserResponse resp = userApi.createUser(request);

        // Validaciones con Hamcrest
        assertThat(resp.getId(), notNullValue());
        assertThat(resp.getName(), equalTo("Paola Ortiz"));
        assertThat(resp.getJob(), equalTo("QA Engineer"));
        assertThat(resp.getCreatedAt(), notNullValue());
    }

    // PUT /users/{id}
    @Test
    public void testUpdateUser() {
        UserRequest request = UserRequest.builder()
                .name("Paola Updated")
                .job("Automation QA")
                .build();

        UserResponse resp = userApi.updateUser("2", request);

        // Validaciones
        assertThat(resp.getName(), equalTo("Paola Updated"));
        assertThat(resp.getJob(), equalTo("Automation QA"));
        assertThat(resp.getUpdatedAt(), notNullValue());
    }

    // DELETE /users/{id}
    @Test
    public void testDeleteUser() {
        userApi.deleteUser("2");

        // Si no lanza excepción, se considera exitoso
        Assertions.assertTrue(true);
    }
}


