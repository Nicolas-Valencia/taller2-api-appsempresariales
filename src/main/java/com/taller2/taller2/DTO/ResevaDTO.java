package com.taller2.taller2.DTO;

import com.taller2.taller2.Entity.Viaje;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResevaDTO {
    private Long id;

    private LocalDate fechaReserva;

    private String estado; // confirmada, cancelada, pendiente

    private int numeroPersonas;

    private Viaje viaje;
}
