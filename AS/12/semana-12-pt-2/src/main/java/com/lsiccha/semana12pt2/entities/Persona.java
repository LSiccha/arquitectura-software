package com.lsiccha.semana12pt2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Persona {

    @JsonProperty("dni")
    String dni;

    @JsonProperty("nombres")
    String nombres;
}
