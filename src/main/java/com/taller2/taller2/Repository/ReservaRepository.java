package com.taller2.taller2.Repository;

import com.taller2.taller2.Entity.Reserva;
import com.taller2.taller2.Entity.Cliente;
import com.taller2.taller2.Entity.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    // Buscar por cliente
    List<Reserva> findByCliente(Cliente cliente);

    // Buscar por viaje
    List<Reserva> findByViaje(Viaje viaje);

    // Buscar por estado
    List<Reserva> findByEstado(String estado);
}
