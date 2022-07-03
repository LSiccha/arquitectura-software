package com.lsiccha.semana12.application.dto.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    @JsonProperty("usuario")
    String usuario;

    @JsonProperty("clave")
    String clave;
}
