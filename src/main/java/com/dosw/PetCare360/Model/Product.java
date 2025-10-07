package com.dosw.PetCare360.Model;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class Product {
    private String id;
    private String name;
    private String description;
    private double price;
    private String category;
}