package com.taller2.taller2.Repository;

import com.taller2.taller2.Entity.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

    // Consultar pagos por estado
    List<Pago> findByEstado(String estado);

    // Consultar pagos por número de transacción
    Pago findByNumeroTransaccion(String numeroTransaccion);
}
