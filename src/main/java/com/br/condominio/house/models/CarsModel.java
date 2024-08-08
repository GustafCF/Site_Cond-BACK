package com.br.condominio.house.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="TB_CARROS")
public class CarsModel implements Serializable {
    private static final long serialVesrionUID = 1L;

    @Id
    @NotBlank
    private String placa;
    @NotBlank
    private String model;
    @NotBlank
    private String type;
    @NotNull
    private int year;
    
    @ManyToOne
    @JoinColumn(name="id_proprietario")
    private CondModel proprietario;

    public CarsModel() {
    }

    public CarsModel(@NotBlank String placa, @NotBlank String model, @NotBlank String type, @NotNull int year,
            CondModel proprietario) {
        this.placa = placa;
        this.model = model;
        this.type = type;
        this.year = year;
        this.proprietario = proprietario;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public CondModel getProprietario() {
        return proprietario;
    }

    public void setProprietario(CondModel proprietario) {
        this.proprietario = proprietario;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((placa == null) ? 0 : placa.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CarsModel other = (CarsModel) obj;
        if (placa == null) {
            if (other.placa != null)
                return false;
        } else if (!placa.equals(other.placa))
            return false;
        return true;
    }

}
