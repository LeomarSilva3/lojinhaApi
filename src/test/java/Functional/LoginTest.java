package Functional;

import common.BaseTest;
import datadriven.LoginUserProvider;
import dto.user.UserLoginRequestDTO;
import dto.user.UserLoginRespondeDTO;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.testng.annotations.Test;
import service.LoginUserService;

import java.util.Random;


public class LoginTest  extends BaseTest {
private LoginUserService postLogin;

    @Test(dataProviderClass = LoginUserProvider.class, dataProvider = "loginSuccess")
    public void LoginComSucesso(UserLoginRequestDTO request){
        postLogin = new LoginUserService();


        UserLoginRespondeDTO response = postLogin.loginSuccess(request)
                .extract()
                .jsonPath()
                .getObject("$",UserLoginRespondeDTO.class);

        Assert.assertEquals(response.getMessage(), "Sucesso ao realizar o login");

    }

    @Test(dataProviderClass = LoginUserProvider.class, dataProvider = "loginInvalidoSenhaValida")
    public void LoginInvalidoSenhaValida(UserLoginRequestDTO request){
        postLogin = new LoginUserService();

        ValidatableResponse response = postLogin.loginInvalido(request);

        response.statusCode(401);

    }

    @Test(dataProviderClass = LoginUserProvider.class, dataProvider = "loginValidoSenhaInvalida")
    public void LoginValidoSenhaInvalida(UserLoginRequestDTO request){
        postLogin = new LoginUserService();

        ValidatableResponse response = postLogin.loginInvalido(request);

        response.statusCode(401);

    }

    @Test(dataProviderClass = LoginUserProvider.class, dataProvider = "loginSenhaNull")
    public void LoginSenhaNull(UserLoginRequestDTO request){
        postLogin = new LoginUserService();

        ValidatableResponse response = postLogin.loginInvalido(request);

        response.statusCode(401);

    }
}
