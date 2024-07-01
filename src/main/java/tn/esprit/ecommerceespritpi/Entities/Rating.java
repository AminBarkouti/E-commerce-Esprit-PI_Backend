package tn.esprit.ecommerceespritpi.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class Rating {
    private Double rate;
    private Integer count;
}
