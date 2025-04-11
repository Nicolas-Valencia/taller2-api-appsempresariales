package com.taller2.taller2.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String metodoPago;

    private BigDecimal monto;

    private LocalDate fechaPago;

    private String estado; // pagado, pendiente, rechazado, etc.

    private String numeroTransaccion;

    @OneToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;

    @Override
    public String toString() {
        return "Pago{" +
                "id=" + id +
                ", metodoPago='" + metodoPago + '\'' +
                ", monto=" + monto +
                ", fechaPago=" + fechaPago +
                ", estado='" + estado + '\'' +
                ", numeroTransaccion='" + numeroTransaccion + '\'' +
                ", reserva=" + reserva +
                '}';
    }
}
