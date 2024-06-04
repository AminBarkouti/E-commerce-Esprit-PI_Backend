package tn.esprit.ecommerceespritpi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;

    private String name;
    private String description;
    private double price;
    private int quantityAvailable;

    @OneToMany
    @JsonIgnore
    private List<ProductCategory> productCategories;
}
