package common;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import static enums.Enums.LOGIN_USUARIO;
import static io.restassured.RestAssured.given;

public class Auth extends BaseTest{
    String token = "";

    public String autenticacao(){
        String body = "{\"usuarioLogin\": \"usuarioCriado\",\n" +
                " \"usuarioSenha\": \"123456\"}";

        token =  given().
                spec(requestSpecification).
                body(body).
                when().
                post(LOGIN_USUARIO.getUrl()).
                then().
                statusCode(HttpStatus.SC_OK).
                contentType(ContentType.JSON).extract().path("data.token");
        return token;

    };
}
