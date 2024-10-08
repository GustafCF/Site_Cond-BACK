package com.br.condominio.house.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.br.condominio.house.models.CarModel;
import com.br.condominio.house.services.CarService;

@RestController
@RequestMapping(value = "/cars")
public class CarController {

    @Autowired
    private CarService service;

    @GetMapping
    public ResponseEntity<List<CarModel>> findAll(){
        List<CarModel> obj = service.findAll();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CarModel> findById(@PathVariable Long id){
        CarModel obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping("/register/{residentId}")
    public ResponseEntity<CarModel> registerCar(@PathVariable Long residentId, @RequestBody CarModel carModel) {
            CarModel savedCar = service.registerCarForResident(residentId, carModel);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedCar.getId()).toUri();
            return ResponseEntity.created(uri).body(savedCar);
    }  
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
