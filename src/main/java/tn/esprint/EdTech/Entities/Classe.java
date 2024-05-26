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
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String specialite;
    private int nbreEtudiant;
    private int nbreCapacite;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classe")
    private Set<Utilisateur> etudiants;

    @ManyToOne
    private Niveau niveau;
}
