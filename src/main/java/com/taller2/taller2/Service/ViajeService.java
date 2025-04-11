package com.taller2.taller2.Service;

import com.taller2.taller2.Entity.Viaje;
import com.taller2.taller2.Repository.ViajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViajeService {

    @Autowired
    private ViajeRepository viajeRepository;


    public Viaje guardarViaje(Viaje viaje) {
        return viajeRepository.save(viaje);
    }


    public Optional<Viaje> obtenerViajePorId(Long id) {
        return viajeRepository.findById(id);
    }


    public List<Viaje> obtenerTodos() {
        return viajeRepository.findAll();
    }


    public Viaje actualizarViaje(Long id, Viaje viajeActualizado) {
        return viajeRepository.findById(id).map(viaje -> {
            viaje.setDestino(viajeActualizado.getDestino());
            viaje.setDuracion(viajeActualizado.getDuracion());
            viaje.setPrecio(viajeActualizado.getPrecio());
            viaje.setFechaInicio(viajeActualizado.getFechaInicio());
            viaje.setFechaFin(viajeActualizado.getFechaFin());
            viaje.setDescripcion(viajeActualizado.getDescripcion());
            return viajeRepository.save(viaje);
        }).orElseThrow(() -> new RuntimeException("Viaje no encontrado"));
    }


    public void eliminarViaje(Long id) {
        viajeRepository.deleteById(id);
    }
}
