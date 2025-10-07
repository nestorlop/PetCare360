package com.dosw.PetCare360.Controller;
import com.dosw.PetCare360.Model.Appoiment;
import com.dosw.PetCare360.Service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/citas")
public class AppointmentController {
    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }
    
    @PostMapping
    public ResponseEntity<Appoiment> agendarCita(@RequestBody Appoiment cita) {
        Appoiment creada = service.ScheduleAppoiment(cita);
        return ResponseEntity.ok(creada);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Appoiment> consultarCita(@PathVariable Long id) {
        return service.consultAppointment(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelarCita(@PathVariable Long id) {
        service.cancelAppointment(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/veterinario/{nombre}")
    public ResponseEntity<List<Appoiment>> listarPorVeterinario(@PathVariable String nombre) {
        return ResponseEntity.ok(service.listAppointmentsByVeterinarian(nombre));
    }

    @GetMapping("/mascota/{id}")
    public ResponseEntity<List<Appoiment>> listarPorMascota(@PathVariable String id) {
        return ResponseEntity.ok(service.listAppointmentsByPet(id));
    }
}

