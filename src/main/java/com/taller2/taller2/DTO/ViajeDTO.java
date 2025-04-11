package com.taller2.taller2.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ViajeDTO {

    private Long id;

    private String destino;

    private int duracion; // en días

    private BigDecimal precio;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;

    private String descripcion;
}
