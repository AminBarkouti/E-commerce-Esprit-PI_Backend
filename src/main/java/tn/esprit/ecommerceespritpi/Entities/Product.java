package tn.esprit.ecommerceespritpi.Entities;

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
    private Long id;
    private String title;
    @Column(length = 1000)
    private String description;
    private String category;
    private String type;
    @ElementCollection
    private List<String> sizes;
    @OneToMany(mappedBy = "product")
    private List<ImageData> images;
    private String stock;
    private double price;
    private double prevprice;
    private Integer qte;
    private double discount;
    private double totalprice;
    @Embedded
    private Rating rating;
}