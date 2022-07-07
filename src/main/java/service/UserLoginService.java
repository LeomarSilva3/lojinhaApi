package service;

import common.BaseTest;
import dto.user.UserLoginRequestDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static enums.Enums.*;
import static io.restassured.RestAssured.given;

public class UserLoginService extends BaseTest {

    public ValidatableResponse loginSuccess(UserLoginRequestDTO body){
        return
             given().
                    spec(requestSpecification).
                     body(body).
             when().
                     post(LOGIN_USUARIO.getUrl()).
             then().
                     statusCode(HttpStatus.SC_OK).
                     contentType(ContentType.JSON);
    }

    public ValidatableResponse loginInvalido(UserLoginRequestDTO body){
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
