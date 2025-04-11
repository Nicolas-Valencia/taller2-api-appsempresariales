package com.taller2.taller2.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PagoDTO {

    private Long id;

    private String metodoPago;

    private BigDecimal monto;

    private LocalDate fechaPago;

    private String estado; // pagado, pendiente, rechazado, etc.

    private String numeroTransaccion;
}
