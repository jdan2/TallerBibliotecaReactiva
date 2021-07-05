package com.sofka.biblioteca.dto;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class AreaTematicaDTO {


    private String idArea;
    @NotBlank
    private String nombreArea;

    public AreaTematicaDTO() {
    }

    public AreaTematicaDTO(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    public AreaTematicaDTO(String idArea, String nombreArea) {
        this.idArea = idArea;
        this.nombreArea = nombreArea;
    }

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AreaTematicaDTO that = (AreaTematicaDTO) o;
        return Objects.equals(idArea, that.idArea) && Objects.equals(nombreArea, that.nombreArea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idArea, nombreArea);
    }

    @Override
    public String toString() {
        return "AreaTematicaDTO{" +
                "idArea='" + idArea + '\'' +
                ", nombreArea='" + nombreArea + '\'' +
                '}';
    }
}
