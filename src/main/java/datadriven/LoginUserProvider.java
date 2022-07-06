package datadriven;

import dto.user.UserLoginRequestDTO;
import org.testng.annotations.DataProvider;


public class LoginUserProvider {
    @DataProvider(name = "loginSuccess")
    public Object[] loginSuccess(){
        UserLoginRequestDTO user = UserLoginRequestDTO.builder()
                .usuarioLogin("admin")
                .usuarioSenha("admin")
                .build();

        return new Object[]{user};

    }

    @DataProvider(name = "loginInvalidoSenhaValida")
    public Object[] loginInvalidoSenhaValida(){
        UserLoginRequestDTO user = UserLoginRequestDTO.builder()
                .usuarioLogin("teste")
                .usuarioSenha("admin")
                .build();


        return new Object[]{user};

    }

    @DataProvider(name = "loginValidoSenhaInvalida")
    public Object[] loginValidoSenhaInvalida(){
        UserLoginRequestDTO user = UserLoginRequestDTO.builder()
                .usuarioLogin("admin")
                .usuarioSenha("teste")
                .build();

        return new Object[]{user};

    }

    @DataProvider(name = "loginSenhaNull")
    public Object[] loginSenhaNull(){
        UserLoginRequestDTO user = UserLoginRequestDTO.builder()
                .usuarioLogin("")
                .usuarioSenha("")
                .build();

        return new Object[]{user};

    }


}
