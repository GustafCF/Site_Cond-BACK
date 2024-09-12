package com.br.condominio.house.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.condominio.house.models.ResidentModel;

@Repository
public interface ResidentRepository extends JpaRepository<ResidentModel, Long> {
    List<ResidentModel> findByResidentName(String residentName);
}
