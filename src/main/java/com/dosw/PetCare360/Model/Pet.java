package com.dosw.PetCare360.Model;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class Pet {
    private Long id;
    private String name;
    private String type;
    private int age;
    private String breed;
    private String medicalHistory;
}