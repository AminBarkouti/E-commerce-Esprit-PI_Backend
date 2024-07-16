package tn.esprit.ecommerceespritpi.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ImageData {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "type")
    private String type;
    @ManyToOne
    @JsonIgnore
    private Product product;

    @Lob
    @Column(name = "picByte", length = 100000)
    private byte[] picByte;

    public ImageData(String name, String type, byte[] picByte) {
        this.name = name;
        this.type = type;
        this.picByte = picByte;
    }

    public ImageData(Long id, String name, String type, byte[] bytes) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.picByte = bytes;
    }
}
