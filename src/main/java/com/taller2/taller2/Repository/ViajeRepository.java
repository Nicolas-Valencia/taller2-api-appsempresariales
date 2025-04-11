package com.taller2.taller2.Repository;

import com.taller2.taller2.Entity.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ViajeRepository extends JpaRepository<Viaje, Long> {

    // Buscar viajes por destino
    List<Viaje> findByDestinoContainingIgnoreCase(String destino);

    // Buscar viajes por rango de fechas
    List<Viaje> findByFechaInicioBetween(LocalDate desde, LocalDate hasta);
}
