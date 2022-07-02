package com.lsiccha.semana12.application.controllers;

import com.lsiccha.semana12.application.dto.Externo;
import com.lsiccha.semana12.domain.entities.Producto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping(path="/")
public class ProductoControllerImpl {

    private ProductoService productoService;

    public List<Producto> listarProductos(){
        return this.productoService.listar();
    }

    @Override
    public ResponseEntity<List<Producto>> listarDataProcesada() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Externo> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Externo>> response = restTemplate.exchange(
                "http://petstore-demo-endpoint.execute-api.com/petstore/pets",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Externo>>() {});


        List<Producto> lista = new ArrayList<Producto>();
        Producto producto;
        for (Externo item: response.getBody()) {
            producto = new Producto();
            producto.setId(item.getId());
            producto.setDescripcion(item.getType());
            producto.setPrecio(item.getPrice()*1+(Math.random()*6+1));
        }

        return new ResponseEntity<>(lista, HttpStatus.OK);


    }

}
