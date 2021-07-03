package com.sofka.biblioteca.dto;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

public class RecursosDTO {

    private String id;
    @NotBlank
    private String nombreRecurso;
    @NotBlank
    private Boolean disponible;
    @NotBlank
    private String tipoRecurso;
    @NotBlank
    private String fechaPrestamo;
    @NotBlank
    private String idArea;

    public RecursosDTO() {
    }

    public RecursosDTO(String nombreRecurso, Boolean disponible, String tipoRecurso, String fechaPrestamo, String idArea) {
        this.nombreRecurso = nombreRecurso;
        this.disponible = disponible;
        this.tipoRecurso = tipoRecurso;
        this.fechaPrestamo = fechaPrestamo;
        this.idArea = idArea;
    }

    public RecursosDTO(String id, String nombreRecurso, Boolean disponible, String tipoRecurso, String fechaPrestamo, String idArea) {
        this.id = id;
        this.nombreRecurso = nombreRecurso;
        this.disponible = disponible;
        this.tipoRecurso = tipoRecurso;
        this.fechaPrestamo = fechaPrestamo;
        this.idArea = idArea;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreRecurso() {
        return nombreRecurso;
    }

    public void setNombreRecurso(String nombreRecurso) {
        this.nombreRecurso = nombreRecurso;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getIdArea() {
        return idArea;
    }

    public void setIdArea(String idArea) {
        this.idArea = idArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecursosDTO that = (RecursosDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(nombreRecurso, that.nombreRecurso) && Objects.equals(disponible, that.disponible) && Objects.equals(tipoRecurso, that.tipoRecurso) && Objects.equals(fechaPrestamo, that.fechaPrestamo) && Objects.equals(idArea, that.idArea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombreRecurso, disponible, tipoRecurso, fechaPrestamo, idArea);
    }

    @Override
    public String toString() {
        return "RecursoDTO{" +
                "id='" + id + '\'' +
                ", nombreRecurso='" + nombreRecurso + '\'' +
                ", disponible=" + disponible +
                ", tipoRecurso='" + tipoRecurso + '\'' +
                ", fechaPrestamo='" + fechaPrestamo + '\'' +
                ", idArea='" + idArea + '\'' +
                '}';
    }
}
