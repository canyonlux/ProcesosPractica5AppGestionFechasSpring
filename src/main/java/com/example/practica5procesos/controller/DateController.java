package com.example.practica5procesos.controller;

import com.example.practica5procesos.model.CustomDate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController // Marca la clase como un controlador REST, permitiendo manejar peticiones HTTP
@RequestMapping("/api/date")
public class DateController {

    // Endpoint para obtener la fecha actual
    @GetMapping // Anotación para manejar peticiones GET a la ruta base
    public ResponseEntity<CustomDate> getCurrentDate() {
        LocalDate now = LocalDate.now();

        CustomDate customDate = new CustomDate(now.getDayOfMonth(), now.getMonthValue(), now.getYear());

        return ResponseEntity.ok(customDate);
    }

    // Endpoint para obtener la fecha actual más un número específico de días
    @GetMapping("/{n}")
    public ResponseEntity<CustomDate> getDatePlusDays(@PathVariable int n) {
        LocalDate futureDate = LocalDate.now().plusDays(n);
        // Crea una instancia de CustomDate con la fecha futura
        CustomDate customDate = new CustomDate(futureDate.getDayOfMonth(), futureDate.getMonthValue(), futureDate.getYear());
        // Retorna la fecha futura envuelta en un ResponseEntity
        return ResponseEntity.ok(customDate);
    }

    // Endpoint para cambiar la fecha del sistema (no implementado)
    @PostMapping
    public ResponseEntity<String> setDate(@RequestBody CustomDate newDate) {

        return ResponseEntity.ok("Cambio de fecha no implementado por razones de seguridad y complejidad");
        // Se evita cambiar la fecha del sistema para prevenir riesgos de seguridad y problemas técnicos
    }
}
