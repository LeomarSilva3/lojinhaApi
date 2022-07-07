package Functional;

import common.BaseTest;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import service.UserDeleteDataService;

public class UserDeleteDataTest extends BaseTest {
   public UserDeleteDataService userDeleteDataService;

    @Test()
    public void deleteDataUser(){
        userDeleteDataService = new UserDeleteDataService();

        ValidatableResponse response = userDeleteDataService.deleteDataUser();

        response.statusCode(204);
    }
}
