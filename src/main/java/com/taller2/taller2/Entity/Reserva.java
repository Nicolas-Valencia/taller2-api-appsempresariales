package com.taller2.taller2.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaReserva;

    private String estado; // confirmada, cancelada, pendiente

    private int numeroPersonas;

    @ManyToOne
    @JoinColumn(name = "viaje_id")
    private Viaje viaje;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", fechaReserva=" + fechaReserva +
                ", estado='" + estado + '\'' +
                ", numeroPersonas=" + numeroPersonas +
                ", viaje=" + viaje +
                ", cliente=" + cliente +
                '}';
    }
}
