package com.taller2.taller2.Service;

import com.taller2.taller2.Entity.Pago;
import com.taller2.taller2.Repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;


    public Pago guardarPago(Pago pago) {
        return pagoRepository.save(pago);
    }


    public Optional<Pago> obtenerPagoPorId(Long id) {
        return pagoRepository.findById(id);
    }


    public List<Pago> obtenerTodos() {
        return pagoRepository.findAll();
    }


    public Pago actualizarPago(Long id, Pago pagoActualizado) {
        return pagoRepository.findById(id).map(pago -> {
            pago.setMetodoPago(pagoActualizado.getMetodoPago());
            pago.setMonto(pagoActualizado.getMonto());
            pago.setFechaPago(pagoActualizado.getFechaPago());
            pago.setEstado(pagoActualizado.getEstado());
            pago.setNumeroTransaccion(pagoActualizado.getNumeroTransaccion());
            pago.setReserva(pagoActualizado.getReserva());
            return pagoRepository.save(pago);
        }).orElseThrow(() -> new RuntimeException("Pago no encontrado"));
    }


    public void eliminarPago(Long id) {
        pagoRepository.deleteById(id);
    }
}
