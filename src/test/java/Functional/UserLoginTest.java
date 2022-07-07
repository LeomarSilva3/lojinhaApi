package Functional;

import common.BaseTest;
import datadriven.LoginUserProvider;
import dto.user.UserLoginRequestDTO;
import dto.user.UserLoginRespondeDTO;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.testng.annotations.Test;
import service.UserLoginService;


public class UserLoginTest extends BaseTest {
private UserLoginService userLoginService;

    @Test(dataProviderClass = LoginUserProvider.class, dataProvider = "loginSuccess")
    public void LoginComSucesso(UserLoginRequestDTO request){
        userLoginService = new UserLoginService();

        UserLoginRespondeDTO response = userLoginService.loginSuccess(request)
                .extract()
                .jsonPath()
                .getObject("$",UserLoginRespondeDTO.class);

        Assert.assertEquals(response.getMessage(), "Sucesso ao realizar o login");

    }

    @Test(dataProviderClass = LoginUserProvider.class, dataProvider = "loginInvalidoSenhaValida")
    public void LoginInvalidoSenhaValida(UserLoginRequestDTO request){
        userLoginService = new UserLoginService();

        ValidatableResponse response = userLoginService.loginInvalido(request);

        response.statusCode(401);

    }

    @Test(dataProviderClass = LoginUserProvider.class, dataProvider = "loginValidoSenhaInvalida")
    public void LoginValidoSenhaInvalida(UserLoginRequestDTO request){
        userLoginService = new UserLoginService();

        ValidatableResponse response = userLoginService.loginInvalido(request);

        response.statusCode(401);

    }

    @Test(dataProviderClass = LoginUserProvider.class, dataProvider = "loginSenhaNull")
    public void LoginSenhaNull(UserLoginRequestDTO request){
        userLoginService = new UserLoginService();

        ValidatableResponse response = userLoginService.loginInvalido(request);

        response.statusCode(401);

    }
}
