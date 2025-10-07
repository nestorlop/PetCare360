package com.dosw.PetCare360.Model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Facture {
    private String id;
    private Appoiment appointment;
    private List<Product> products;     
    private double totalPrice;
}