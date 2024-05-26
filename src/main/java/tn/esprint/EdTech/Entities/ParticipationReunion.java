package tn.esprint.EdTech.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprint.EdTech.Entities.Keys.ParticipationReunionKey;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ParticipationReunion {
    @EmbeddedId
    private ParticipationReunionKey id_part;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("id_user")
    private Utilisateur utilisateur;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("id_reunion")
    private Reunion reunion;
}
