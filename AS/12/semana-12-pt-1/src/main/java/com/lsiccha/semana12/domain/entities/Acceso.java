package com.lsiccha.semana12.domain.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Acceso {
    @JsonProperty("satisfactorio")
    boolean satisfactorio;

    @JsonProperty("mensaje")
    String mensaje;

    public void setSatisfactorio(boolean satisfactorio){
        this.satisfactorio = satisfactorio;
    }

    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
    }

    public String getMensaje(){
        return this.mensaje;
    }

    public boolean getSatisfactorio(){
        return this.satisfactorio;
    }
}
