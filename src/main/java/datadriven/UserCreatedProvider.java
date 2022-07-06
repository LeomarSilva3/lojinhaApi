package datadriven;

import dto.user.UserCreatedRequestDTO;
import org.testng.annotations.DataProvider;

import java.util.Random;

public class UserCreatedProvider {
    @DataProvider(name = "userCreated")
    public Object[] userCreated() {
        Random random = new Random();
        int number = random.nextInt(99);

        UserCreatedRequestDTO user = UserCreatedRequestDTO.builder()
                .usuarioNome("usuarioCriado")
                .usuarioLogin("usuarioCriado" + number)
                .usuarioSenha("123456")
                .build();

        return new Object[]{user};
    }

    @DataProvider(name = "userAlreadyExists")
    public Object[] userAlreadyExists(){
        UserCreatedRequestDTO user = UserCreatedRequestDTO.builder()
                .usuarioNome("usuarioCriado")
                .usuarioLogin("usuarioCriado")
                .usuarioSenha("123456")
                .build();

        return new Object[]{user};
    }
}
