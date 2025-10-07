package com.dosw.PetCare360.Repository;
import com.dosw.PetCare360.Model.Appoiment;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AppointmentRepository {

    private final Map<Long, Appoiment> citas = new HashMap<>();

    public Appoiment save(Appoiment cita) {
        citas.put(cita.getId(), cita);
        return cita;
    }

    public Optional<Appoiment> findById(Long id) {
        return Optional.ofNullable(citas.get(id));
    }

    public void deleteById(Long id) {
        citas.remove(id);
    }

    public List<Appoiment> findAll() {
        return new ArrayList<>(citas.values());
    }

    public List<Appoiment> findByVeterinarian(String vetName) {
        return citas.values().stream()
                .filter(c -> c.getVeterinarian().name().equals(vetName))
                .toList();
    }

    public List<Appoiment> findByPetId(String petId) {
        return citas.values().stream()
                .filter(c -> c.getPet().getId().equals(petId))
                .toList();
    }
}
