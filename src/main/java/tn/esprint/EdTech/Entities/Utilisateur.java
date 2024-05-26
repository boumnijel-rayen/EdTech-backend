package tn.esprint.EdTech.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    @ElementCollection(targetClass = Role.class)
    private Set<Role> roles;

    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore
    private Set<Examen> examens;

    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore
    private Set<Absence> absences;

    @ManyToMany(mappedBy = "enseignants", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Matiere> matieres;

    @ManyToOne
    private Classe classe;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<RendezVous> RendezvousValides;

    @OneToMany(mappedBy = "validateur", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<RendezVous> RendezvousPasses;

    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnore
    private Set<DemandeMenu> demandesMenu;

    @OneToMany(mappedBy = "utilisateur")
    @JsonIgnore
    private Set<ParticipationReunion> reunions;
}
