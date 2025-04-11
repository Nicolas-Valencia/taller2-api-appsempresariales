package com.taller2.taller2.Controllers;

import com.taller2.taller2.Entity.Pago;
import com.taller2.taller2.Service.PagoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    @Autowired
    private PagoService pagoService;

    @Operation(summary = "Obtener todos los pagos")
    @ApiResponse(responseCode = "200", description = "Pagos obtenidos correctamente")
    @GetMapping
    public List<Pago> obtenerTodosLosPagos() {
        return pagoService.obtenerTodos();
    }

    @Operation(summary = "Obtener una pago por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pago encontrado"),
            @ApiResponse(responseCode = "404", description = "Pago no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Pago> obtenerPagoPorId(@PathVariable Long id) {
        return pagoService.obtenerPagoPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un nuevo pago")
    @ApiResponse(responseCode = "201", description = "Pago creado correctamente")
    @PostMapping
    public ResponseEntity<Pago> crearPago(@RequestBody Pago pago) {
        Pago nuevo = pagoService.guardarPago(pago);
        return ResponseEntity.status(201).body(nuevo);
    }

    @Operation(summary = "Actualizar un pago existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pago actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Pago no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Pago> actualizarPago(@PathVariable Long id, @RequestBody Pago pago) {
        try {
            Pago actualizado = pagoService.actualizarPago(id, pago);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Eliminar un pago")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Pago eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Pago no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPago(@PathVariable Long id) {
        pagoService.eliminarPago(id);
        return ResponseEntity.noContent().build();
    }

}
