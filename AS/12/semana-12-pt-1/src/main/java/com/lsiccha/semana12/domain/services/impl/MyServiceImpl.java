package com.lsiccha.semana12.domain.services.impl;

import com.lsiccha.semana12.application.dto.Externo;
import com.lsiccha.semana12.domain.entities.Producto;
import com.lsiccha.semana12.domain.services.MyService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MyServiceImpl implements MyService {

    @Value("${service.pets}")
    String servicioPets;

    protected final Log logger = LogFactory.getLog(getClass());


    @Override
    public List<Producto> listFilteredData(String tipo) throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.wait(1000);

        ResponseEntity<List<Externo>> response = restTemplate.exchange(
                servicioPets,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Externo>>() {
                });

        List<Producto> lista = new ArrayList<Producto>();
        Producto producto;

        if(response.getStatusCode()== HttpStatus.OK){
            for (Externo item: response.getBody()) {
                producto = new Producto();
                producto.setId(item.getId());
                producto.setDescripcion(item.getType());
                producto.setPrecio(item.getPrice()*1+(Math.random()*6+1)/10);
                lista.add(producto);
            }
            return lista.stream().filter(p -> p.getDescripcion().equals(tipo)).collect(Collectors.toList());
        }
        else{
            logger.error("Error en la respuesta del servicio invocado. Code: "+response.getStatusCode());
            throw new InterruptedException("Error en la respuesta del servicio invocado. Code: "+response.getStatusCode());
        }    }
}
