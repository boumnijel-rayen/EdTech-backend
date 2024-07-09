package tn.esprint.EdTech.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Utilisateur implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    private Set<Role> roles;

    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL)
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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
