package com.dosw.PetCare360.Model;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Pet {
    @Id
    private Long id;
    private String name;
    private String type;
    private int age;
    private String breed;
    private String medicalHistory;
}