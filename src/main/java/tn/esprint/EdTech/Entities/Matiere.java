package tn.esprint.EdTech.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Matiere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String description;

    @OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Examen> examens;

    @ManyToMany (cascade = CascadeType.ALL)
    private Set<Utilisateur> enseignants;

    @ManyToMany (cascade = CascadeType.ALL)
    private Set<Utilisateur> etudiants;
}
