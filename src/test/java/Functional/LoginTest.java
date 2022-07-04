package Functional;

import common.BaseTest;
import datadriven.LoginUserProvider;
import dto.user.UserLoginRespondeDTO;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.LoginUserService;


public class LoginTest  extends BaseTest {
private LoginUserService postLogin;

    @Test(dataProviderClass = LoginUserProvider.class, dataProvider = "loginSuccess")
    public void LoginComSucesso(String body, UserLoginRespondeDTO login){
        postLogin = new LoginUserService();


        UserLoginRespondeDTO response = postLogin.loginSuccess(body)
                .extract()
                .jsonPath()
                .getObject("$",UserLoginRespondeDTO.class);



    }

    @Test(dataProviderClass = LoginUserProvider.class, dataProvider = "loginInvalidoSenhaValida")
    public void LoginInvalidoSenhaValida(String body){
        postLogin = new LoginUserService();

        ValidatableResponse response = postLogin.loginInvalido(body);

        response.statusCode(401);

    }

    @Test(dataProviderClass = LoginUserProvider.class, dataProvider = "loginValidoSenhaInvalida")
    public void LoginValidoSenhaInvalida(String body){
        postLogin = new LoginUserService();

        ValidatableResponse response = postLogin.loginInvalido(body);

        response.statusCode(401);

    }

    @Test(dataProviderClass = LoginUserProvider.class, dataProvider = "loginSenhaNull")
    public void LoginSenhaNull(String body){
        postLogin = new LoginUserService();

        ValidatableResponse response = postLogin.loginInvalido(body);

        response.statusCode(401);

    }

    @Test(dataProviderClass = LoginUserProvider.class, dataProvider = "loginSenhaParametroBody")
    public void LoginSemParametrosBody(String body){
        postLogin = new LoginUserService();

        ValidatableResponse response = postLogin.loginInvalido(body);

        response.statusCode(401);

    }
}
