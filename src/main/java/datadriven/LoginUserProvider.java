package datadriven;

import dto.user.UserLoginRequestDTO;
import dto.user.UserLoginRespondeDTO;
import org.testng.annotations.DataProvider;


public class LoginUserProvider {
    @DataProvider(name = "loginSuccess")
    public Object[][] loginSuccess(){
        UserLoginRequestDTO user = UserLoginRequestDTO.builder()
                .usuarioLogin("admin")
                .usuarioSenha("admin")
                .build();


        UserLoginRespondeDTO loginUser = UserLoginRespondeDTO.builder()
                .message("Sucesso ao realizar o login")
                .build();


        String body = "{\"usuarioLogin\": \""+user.getUsuarioLogin()+"\",\n" +
                      " \"usuarioSenha\": \""+user.getUsuarioSenha()+"\"}";

        return new Object[][]{
                {body,loginUser}
        };

    }

    @DataProvider(name = "loginInvalidoSenhaValida")
    public Object[][] loginInvalidoSenhaValida(){
        UserLoginRequestDTO user = UserLoginRequestDTO.builder()
                .usuarioLogin("teste")
                .usuarioSenha("admin")
                .build();


        String body = "{\"usuarioLogin\": \""+user.getUsuarioLogin()+"\",\n" +
                " \"usuarioSenha\": \""+user.getUsuarioSenha()+"\"}";

        return new Object[][]{
                {body}
        };

    }

    @DataProvider(name = "loginValidoSenhaInvalida")
    public Object[][] loginValidoSenhaInvalida(){
        UserLoginRequestDTO user = UserLoginRequestDTO.builder()
                .usuarioLogin("admin")
                .usuarioSenha("teste")
                .build();


        String body = "{\"usuarioLogin\": \""+user.getUsuarioLogin()+"\",\n" +
                " \"usuarioSenha\": \""+user.getUsuarioSenha()+"\"}";

        return new Object[][]{
                {body}
        };

    }

    @DataProvider(name = "loginSenhaNull")
    public Object[][] loginSenhaNull(){
        UserLoginRequestDTO user = UserLoginRequestDTO.builder()
                .usuarioLogin("")
                .usuarioSenha("")
                .build();


        String body = "{\"usuarioLogin\": \""+user.getUsuarioLogin()+"\",\n" +
                " \"usuarioSenha\": \""+user.getUsuarioSenha()+"\"}";

        return new Object[][]{
                {body}
        };

    }

    @DataProvider(name = "loginSenhaParametroBody")
    public Object[][] loginSemParametroBody(){

        String body = "{}";

        return new Object[][]{
                {body}
        };

    }
}
