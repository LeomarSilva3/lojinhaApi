package service;

import common.BaseTest;
import dto.user.UserCreatedRequestDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import static enums.Enums.CRIAR_USUARIO;
import static io.restassured.RestAssured.given;

public class UserCreatedService extends BaseTest {

    public ValidatableResponse userCreated(UserCreatedRequestDTO body){
        return given().
                    spec(requestSpecification).
                    body(body).
                when().
                    post(CRIAR_USUARIO.getUrl()).
                then().
                    statusCode(HttpStatus.SC_CREATED).
                    contentType(ContentType.JSON);
    }

    public ValidatableResponse userAlreadyExists(UserCreatedRequestDTO body){
        return given().
                    spec(requestSpecification).
                    body(body).
                when().
                    post(CRIAR_USUARIO.getUrl()).
                then().
                    statusCode(HttpStatus.SC_CONFLICT).
                    contentType(ContentType.JSON);
    }
}
