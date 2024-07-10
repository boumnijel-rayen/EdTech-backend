package tn.esprint.EdTech.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Repas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private double calories;
    @Enumerated(EnumType.STRING)
    private CategorieRepas Categorie;
    private double poidsCarbs;
    private double poidsProteines;
    private double poidsFats;
    @Lob
    private byte[] image;

}