package com.lsiccha.semana12.application.controllers.impl;

import com.lsiccha.semana12.application.controllers.AuthController;
import com.lsiccha.semana12.application.dto.auth.LoginDto;
import com.lsiccha.semana12.application.dto.auth.RespuestaAcceso;
import com.lsiccha.semana12.domain.entities.Acceso;
import com.lsiccha.semana12.domain.services.AuthService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.sasl.AuthenticationException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/auth")
public class AuthControllerImpl implements AuthController {

    protected final Log logger = LogFactory.getLog(getClass());
    private AuthService authService;

    AuthControllerImpl(AuthService authService){
        this.authService = authService;
    }

    @Value("${message.producto.errorProceso}")
    private String msgerrorProceso;

    @Override
    public ResponseEntity<RespuestaAcceso> login(LoginDto creds) throws Exception {
        RespuestaAcceso response = new RespuestaAcceso();
        try {
            Acceso acceso = this.authService.login(creds);
            response.setSatisfactorio(true);
            response.setData(acceso);
            response.setMensaje("Proceso de autenticacion realizado correctamente");
            response.setCodigo("10");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e){
            response.setSatisfactorio(false);
            response.setCodigo("99");
            response.setMensaje(msgerrorProceso);
            return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
