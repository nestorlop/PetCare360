package com.dosw.PetCare360.Service.IMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dosw.PetCare360.Model.Appoiment;
import com.dosw.PetCare360.Repository.AppointmentRepository;
import com.dosw.PetCare360.Service.AppointmentService;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;

    public AppointmentServiceImpl(AppointmentRepository repository) {
        this.repository = repository;
    }
    @Override
    public Appoiment ScheduleAppoiment(Appoiment cita) {
       
        boolean conflicto = repository.findAll().stream()
                .anyMatch(c -> c.getVeterinarian().equals(cita.getVeterinarian())
                        && c.getDate().equals(cita.getDate()));

        if (conflicto) {
            throw new IllegalArgumentException("The veterinarian already has an appointment at that date and time.");
        }

        return repository.save(cita);
    }

    @Override
    public Optional<Appoiment> consultAppointment(Long id) {
        return repository.findById(id);
    }

    @Override
    public void cancelAppointment(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<Appoiment> listAppointmentsByVeterinarian(String vetName) {
        return repository.findByVeterinarian(vetName);
    }

    @Override
    public List<Appoiment> listAppointmentsByPet(String petId) {
        return repository.findByPetId(petId);
    }
}
