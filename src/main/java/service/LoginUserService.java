package service;

import common.BaseTest;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static enums.Enums.*;
import static io.restassured.RestAssured.given;

public class LoginUserService extends BaseTest {

    public ValidatableResponse loginSuccess(String body){
        return
             given().
                    spec(requestSpecification).
                     body(body).
             when().
                     post(LOGIN_USUARIO.getUrl()).
             then().
                     statusCode(HttpStatus.SC_UNAUTHORIZED).
                     contentType(ContentType.JSON);
    }

    public ValidatableResponse loginInvalido(String body){
        return
             given().
                    spec(requestSpecification).
                    body(body).
             when().
                    post(LOGIN_USUARIO.getUrl()).
             then().
                    statusCode(HttpStatus.SC_UNAUTHORIZED).
                        contentType(ContentType.JSON);
    }
}
