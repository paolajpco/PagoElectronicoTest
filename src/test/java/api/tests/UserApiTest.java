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

    @Test
    public void testGetUsersPage2() {
        Response resp = userApi.getUsersPage(2);

        // Validar código HTTP
        assertThat(resp.getStatusCode(), is(200));

        // Validar que JSON contiene "page" y "data"
        int page = resp.jsonPath().getInt("page");
        assertThat(page, is(2));

        assertThat(resp.jsonPath().getList("data"), is(not(empty())));
    }

    @Test
    public void testCreateUser() {
        UserRequest request = UserRequest.builder()
                .name("Paola Ortiz")
                .job("QA Engineer")
                .build();

        UserResponse resp = userApi.createUser(request);

        assertThat(resp.getId(), notNullValue());
        assertThat(resp.getName(), equalTo("Paola Ortiz"));
        assertThat(resp.getJob(), equalTo("QA Engineer"));
    }

    @Test
    public void testUpdateUser() {
        UserRequest request = UserRequest.builder()
                .name("Paola Updated")
                .job("Automation QA")
                .build();

        UserResponse resp = userApi.updateUser("2", request);

        assertThat(resp.getName(), equalTo("Paola Updated"));
        assertThat(resp.getJob(), equalTo("Automation QA"));
        assertThat(resp.getUpdatedAt(), notNullValue());
    }

    @Test
    public void testDeleteUser() {
        userApi.deleteUser("2");
        // Si llega aquí sin excepción, el DELETE fue exitoso
        Assertions.assertTrue(true);
    }
}


