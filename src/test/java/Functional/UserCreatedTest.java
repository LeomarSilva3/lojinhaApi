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
    private UserCreatedService postCreated;

    @Test(dataProviderClass = UserCreatedProvider.class, dataProvider = "userCreated")
    public void userCreated(UserCreatedRequestDTO request){
        postCreated = new UserCreatedService();

        UserCreateResponseDTO response = postCreated.userCreated(request)
                .extract()
                .jsonPath()
                .getObject("$",UserCreateResponseDTO.class);

        Assert.assertEquals(response.getMessage(),"Usuário adicionado com sucesso");


    }

    @Test(dataProviderClass = UserCreatedProvider.class, dataProvider = "userAlreadyExists")
    public void userAlreadyExists(UserCreatedRequestDTO request){
        postCreated = new UserCreatedService();

        UserCreatedResponseAlreadyDTO response = postCreated.userAlreadyExists(request)
                .extract()
                .jsonPath()
                .getObject("$",UserCreatedResponseAlreadyDTO.class);

        Assert.assertEquals(response.getError(), "O usuário usuarioCriado já existe.");

    }


}
