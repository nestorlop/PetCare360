package com.dosw.PetCare360.Model;

import java.sql.Date;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

import com.dosw.PetCare360.Model.Enum.Veterinarian;


@Data
@Builder
public class Appoiment {
    private Long id;
    private LocalDateTime date;
    private String description;
    private Veterinarian veterinarian;
    private int price;
    private Pet pet;
}