package tn.esprint.EdTech.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprint.EdTech.Entities.Keys.ExamenKey;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class  Examen {
    @EmbeddedId
    private ExamenKey id_exam;
    private double note;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("id_user")
    private Utilisateur etudiant;

    @Column
    String enonce;

    @Column
    String travail;


    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("id_mat")
    private Matiere matiere;
}
