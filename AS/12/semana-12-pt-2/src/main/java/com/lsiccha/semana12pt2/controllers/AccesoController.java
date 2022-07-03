package com.lsiccha.semana12pt2.controllers;

import com.lsiccha.semana12pt2.entities.Acceso;
import com.lsiccha.semana12pt2.entities.Login;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="*")
@RequestMapping(path="/accesoServicio")
public class AccesoController {

    @PostMapping(value="/login", produces =  {"application/json"}, consumes ={"application/json"})
    public ResponseEntity<Acceso> login(@RequestBody Login info){
        Acceso acceso = new Acceso();
        try {
            if (
                    info.getUsuario().equalsIgnoreCase("CARLOS") &&
                    info.getClave().equalsIgnoreCase("123456")
            ){
                acceso.setSatisfactorio(true);
                acceso.setMensaje("Validacion Correcta!!!");
                return new ResponseEntity<Acceso>(acceso, HttpStatus.OK);
            }else {
                acceso.setSatisfactorio(false);
                acceso.setMensaje("Validacion Incorrecta!!!");
                return new ResponseEntity<Acceso>(acceso, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e){
            acceso.setSatisfactorio(false);
            acceso.setMensaje("Error inesperado, " + e.getMessage());
            return new ResponseEntity<Acceso>(acceso, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
