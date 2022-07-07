package Functional;

import common.BaseTest;
import datadriven.UserCreatedProvider;
import dto.user.UserCreateResponseDTO;
import dto.user.UserCreatedRequestDTO;
import dto.user.UserCreatedResponseAlreadyDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.UserCreatedService;

import java.util.Random;


public class UserCreatedTest extends BaseTest {
    private UserCreatedService userCreatedService;

    @Test(dataProviderClass = UserCreatedProvider.class, dataProvider = "userCreated")
    public void userCreated(UserCreatedRequestDTO request){
        userCreatedService = new UserCreatedService();

        UserCreateResponseDTO response = userCreatedService.userCreated(request)
                .extract()
                .jsonPath()
                .getObject("$",UserCreateResponseDTO.class);

        Assert.assertEquals(response.getMessage(),"Usuário adicionado com sucesso");

    }

    @Test(dataProviderClass = UserCreatedProvider.class, dataProvider = "userAlreadyExists")
    public void userAlreadyExists(UserCreatedRequestDTO request){
        userCreatedService = new UserCreatedService();

        UserCreatedResponseAlreadyDTO response = userCreatedService.userAlreadyExists(request)
                .extract()
                .jsonPath()
                .getObject("$",UserCreatedResponseAlreadyDTO.class);

        Assert.assertEquals(response.getError(), "O usuário usuarioCriado já existe.");

    }


}
