package api.steps;

import api.models.UserRequest;
import api.models.UserResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserApiSteps {

    // GET /users?page=2
    public Response getUsersPage(int page) {
        return given()
                .queryParam("page", page)
                .when()
                .get("/users");
    }

    // POST /users
    public UserResponse createUser(UserRequest request) {
        Response resp = given()
                .contentType("application/json")
                .body(request)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .extract().response();

        return resp.as(UserResponse.class);
    }

    // PUT /users/{id}
    public UserResponse updateUser(String id, UserRequest request) {
        Response resp = given()
                .contentType("application/json")
                .body(request)
                .when()
                .put("/users/" + id)
                .then()
                .statusCode(200)
                .extract().response();

        return resp.as(UserResponse.class);
    }

    // DELETE /users/{id}
    public void deleteUser(String id) {
        given()
                .when()
                .delete("/users/" + id)
                .then()
                .statusCode(204);
    }
}
