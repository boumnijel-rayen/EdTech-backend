package tn.esprint.EdTech.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.esprint.EdTech.Entities.Keys.DemandeMenuKey;
import tn.esprint.EdTech.Entities.Keys.ExamenKey;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DemandeMenu {
    @EmbeddedId
    private DemandeMenuKey id_demande;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("id_user")
    private Utilisateur utilisateur;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("id_menu")
    private Menu menu;
}
