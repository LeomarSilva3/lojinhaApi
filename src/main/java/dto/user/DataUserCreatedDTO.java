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
public class DataUserCreatedDTO {
    private String usuarioId;
    private String usuarioLogin;
    private String usuarioNome;

}
