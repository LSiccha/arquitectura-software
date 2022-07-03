package com.lsiccha.semana12.domain.services.impl;

import com.lsiccha.semana12.application.dto.auth.LoginDto;
import com.lsiccha.semana12.domain.entities.Acceso;
import com.lsiccha.semana12.domain.services.AuthService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import javax.security.sasl.AuthenticationException;


@Service
public class AuthServiceImpl implements AuthService {

    protected final Log logger = LogFactory.getLog(getClass());
    @Value("{service.acceso}")
    String servicioAcceso;

    String endpoint = "http://localhost:9000/accesoServicio/login";

    @Override
    public Acceso login(LoginDto loginDto) throws Exception {
        //HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<LoginDto> entity = new HttpEntity<>(loginDto);

        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.wait(1000);

        try {
            logger.error("Llegue");

            ResponseEntity<Acceso> response = restTemplate.exchange(
                    endpoint,
                    HttpMethod.POST,
                    entity,
                    new ParameterizedTypeReference<Acceso>() {
                    });

            logger.error("Llegue");
            if(response.getStatusCode() == HttpStatus.OK){
                return response.getBody();
            } else if (response.getStatusCode() == HttpStatus.BAD_REQUEST) {
                return response.getBody();
            } else{
                logger.error("Error en la respuesta del servicio invocado. Code: "+response.getStatusCode());
                throw new InterruptedException("Error en la respuesta del servicio invocado. Code: "+response.getStatusCode());
            }
        } catch (HttpClientErrorException e){
            throw new AuthenticationException("Error en la autenticacion");
        }
    }
}

