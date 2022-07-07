package service;

import common.Auth;
import common.BaseTest;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static enums.Enums.DELETAR_DADOS_USUARIO;
import static io.restassured.RestAssured.given;

public class UserDeleteDataService extends BaseTest {
    Auth autentic;

    public ValidatableResponse deleteDataUser(){

        autentic = new Auth();
        return
                given().
                    spec(requestSpecification).
                    header("token",autentic.autenticacao()).
                when().
                    delete(DELETAR_DADOS_USUARIO.getUrl()).
                then().
                    statusCode(HttpStatus.SC_NO_CONTENT);



        }
}
