package com.dosw.PetCare360.Service;


import java.util.List;
import java.util.Optional;

import com.dosw.PetCare360.Model.Appoiment;

public interface AppointmentService {
    Appoiment ScheduleAppoiment(Appoiment cita);
    Optional<Appoiment> consultAppointment(Long id);
    void cancelAppointment(Long id);
    List<Appoiment> listAppointmentsByVeterinarian(String vetName);
    List<Appoiment> listAppointmentsByPet(String petId);
}