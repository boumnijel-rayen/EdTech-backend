package tn.esprint.EdTech.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RendezVous {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private Status statut;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    private Utilisateur etudiant;

    @ManyToOne
    private Utilisateur validateur;


}
