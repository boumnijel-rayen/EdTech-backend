package tn.esprint.EdTech.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprint.EdTech.Entities.Keys.AbsenceKey;
import tn.esprint.EdTech.Entities.Keys.ExamenKey;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Absence {
    @EmbeddedId
    private AbsenceKey id_abs;
    private String etat;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("id_user")
    private Utilisateur etudiant;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("id_mat")
    private Matiere matiere;
}
