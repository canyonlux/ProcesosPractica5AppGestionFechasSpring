package com.example.practica5procesos;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/date") // Ruta base para todos los endpoints de esta clase
public class DateController {

    @GetMapping
    public ResponseEntity<CustomDate> getCurrentDate() {
        LocalDate now = LocalDate.now();
        CustomDate customDate = new CustomDate(now.getDayOfMonth(), now.getMonthValue(), now.getYear());
        return ResponseEntity.ok(customDate);
    }

    @GetMapping("/{n}") //
    public ResponseEntity<CustomDate> getDatePlusDays(@PathVariable int n) {
        LocalDate futureDate = LocalDate.now().plusDays(n);
        CustomDate customDate = new CustomDate(futureDate.getDayOfMonth(), futureDate.getMonthValue(), futureDate.getYear());
        return ResponseEntity.ok(customDate);
    }

    @PostMapping
    public ResponseEntity<String> setDate(@RequestBody CustomDate newDate) {

        return ResponseEntity.ok("Cambio de fecha no implementado por razones de seguridad y complejidad");
    }

}
