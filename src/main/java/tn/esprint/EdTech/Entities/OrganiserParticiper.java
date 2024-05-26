package tn.esprint.EdTech.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprint.EdTech.Entities.Keys.ExamenKey;
import tn.esprint.EdTech.Entities.Keys.OraganiserParticiperKey;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrganiserParticiper {
    @EmbeddedId
    private OraganiserParticiperKey id_orgpar;

    private String type;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("id_user")
    private Utilisateur utilisateur;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("id_evenement")
    private Evenement evenement;
}
