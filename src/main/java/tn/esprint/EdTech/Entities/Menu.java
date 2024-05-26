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
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String type;

    @OneToMany(mappedBy = "menu")
    private Set<DemandeMenu> demandes;

    @ManyToMany(mappedBy = "menus", cascade = CascadeType.ALL)
    private Set<Repas> repas;
}
