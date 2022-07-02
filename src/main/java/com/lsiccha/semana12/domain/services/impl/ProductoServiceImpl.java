package com.lsiccha.semana12.domain.services.impl;

import com.lsiccha.semana12.application.dto.Externo;
import com.lsiccha.semana12.domain.entities.Producto;
import com.lsiccha.semana12.domain.repositories.ProductoRepository;
import com.lsiccha.semana12.domain.services.ProductoService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    @Value("$(service.pets)")
    String servicioPets;

    private Logger logger;
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listar() {
        return this.productoRepository.listar();
    }

    @Override
    public List<Producto> listarDataProcesada() throws InterruptedException {
        //HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON);

        //HttpEntity<Externo> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();
        //restTemplate.wait(1000);

        ResponseEntity<List<Externo>> response = restTemplate.exchange(
                "http://petstore-demo-endpoint.execute-api.com/petstore/pets",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Externo>>() {
                });

        List<Producto> lista = new ArrayList<Producto>();
        Producto producto;

        if(response.getStatusCode()==HttpStatus.OK){
            for (Externo item: response.getBody()) {
                producto = new Producto();
                producto.setId(item.getId());
                producto.setDescripcion(item.getType());
                producto.setPrecio(item.getPrice()*1+(Math.random()*6+1));
                lista.add(producto);
                System.out.println(producto.toString());
            }
            return lista;
        }
        else{
            logger.error("Error en la respuesta del servicio invocado. Code: "+response.getStatusCode());
            throw new InterruptedException("Error en la respuesta del servicio invocado. Code: "+response.getStatusCode());
        }

    }
}
