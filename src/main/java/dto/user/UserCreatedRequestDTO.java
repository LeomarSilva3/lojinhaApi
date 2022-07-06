package dto.user;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserCreatedRequestDTO {

    private String usuarioNome;
    private String usuarioLogin;
    private String usuarioSenha;

}
