package com.lsiccha.semana12.domain.services.impl;

import com.lsiccha.semana12.application.dto.Externo;
import com.lsiccha.semana12.domain.entities.Producto;
import com.lsiccha.semana12.domain.services.ProductoService;
import lombok.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class ProductoServiceImpl implements ProductoService {

    @Value("$(service.pets)")
    String servicioPets;

    @Override
    public List<Producto> listar() {
        return null;
    }

    @Override
    public List<Producto> listarDataProcesada() throws InterruptedException {
        //HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);

        //HttpEntity<Externo> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.wait(1000);

        ResponseEntity<List<Externo>> response = restTemplate.exchange(
                "http://petstore-demo-endpoint.execute-api.com/petstore/pets",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Externo>>() {
                });

        List<Producto> lista = new ArrayList<Producto>();
        Producto producto;
        if (response.getStatusCode()==HttpStatus.OK){
            for (Externo item: response.getBody()) {
                producto = new Producto();
                producto.setId(item.getId());
                producto.setDescripcion(item.getType());
                producto.setPrecio(item.getPrice()*1+(Math.random()*6+1));
                lista.add(producto);
                System.out.println(producto.toString());
            }
            return new ResponseEntity<>(lista, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(lista, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
