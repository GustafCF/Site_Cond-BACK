package com.br.condominio.house.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.condominio.house.models.CarsModel;
import com.br.condominio.house.models.CondModel;
import com.br.condominio.house.repositories.CarsRepository;
import com.br.condominio.house.repositories.CondRepository;

@Service
public class CarsService {

    @Autowired
    private CarsRepository carsRepository;

    @Autowired
    private CondRepository condRepository;

    public CarsModel saveCar(CarsModel car, UUID condId) {
        Optional<CondModel> condModelOptional = condRepository.findById(condId);
        if (condModelOptional.isPresent()) {
            CondModel condModel = condModelOptional.get();
            car.setProprietario(condModel);
            return carsRepository.save(car);
        } else {
            throw new RuntimeException("Condômino não encontrado com o ID: " + condId);
        }
    }

    public List<CarsModel> findAll(){
        return carsRepository.findAll();
    }
}
