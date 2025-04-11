package com.taller2.taller2.Service;

import com.taller2.taller2.Entity.Reserva;
import com.taller2.taller2.Repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;


    public Reserva guardarReserva(Reserva reserva) {
        return reservaRepository.save(reserva);
    }


    public Optional<Reserva> obtenerReservaPorId(Long id) {
        return reservaRepository.findById(id);
    }


    public List<Reserva> obtenerTodas() {
        return reservaRepository.findAll();
    }


    public Reserva actualizarReserva(Long id, Reserva reservaActualizada) {
        return reservaRepository.findById(id).map(reserva -> {
            reserva.setFechaReserva(reservaActualizada.getFechaReserva());
            reserva.setEstado(reservaActualizada.getEstado());
            reserva.setNumeroPersonas(reservaActualizada.getNumeroPersonas());
            reserva.setViaje(reservaActualizada.getViaje());
            reserva.setCliente(reservaActualizada.getCliente());
            return reservaRepository.save(reserva);
        }).orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }


    public void eliminarReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
