package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Enums {

    BASE_URI ("http://165.227.93.41/lojinha"),
    BASE_PATH ("/"),
    LOGIN_USUARIO ("v2/login");

    private String url;
}
