package com.taller2.taller2.Controllers;

import com.taller2.taller2.Entity.Viaje;
import com.taller2.taller2.Service.ViajeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/controller")
public class ViajeController {

    @Autowired
    private ViajeService viajeService;

    @Operation(summary = "Obtener todos los viajes")
    @ApiResponse(responseCode = "200", description = "Lista de viajes obtenidos correctamente")
    @GetMapping
    public List<Viaje> obtenerTodasLasReservas() {
        return viajeService.obtenerTodos();
    }

    @Operation(summary = "Obtener un viaje por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Viaje encontrado"),
            @ApiResponse(responseCode = "404", description = "Viaje no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Viaje> obtenerViajePorId(@PathVariable Long id) {
        return viajeService.obtenerViajePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un nuevo viaje")
    @ApiResponse(responseCode = "201", description = "Viaje creado correctamente")
    @PostMapping
    public ResponseEntity<Viaje> crearViaje(@RequestBody Viaje viaje) {
        Viaje nuevo = viajeService.guardarViaje(viaje);
        return ResponseEntity.status(201).body(nuevo);
    }

    @Operation(summary = "Actualizar un viaje existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Viaje actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Viaje no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Viaje> actualizarViaje(@PathVariable Long id, @RequestBody Viaje viaje) {
        try {
            Viaje actualizado = viajeService.actualizarViaje(id, viaje);
            return ResponseEntity.ok(actualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Eliminar un viaje")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Viaje eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Viaje no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarViaje(@PathVariable Long id) {
        viajeService.eliminarViaje(id);
        return ResponseEntity.noContent().build();
    }

}
