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
public class RendezVous implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate date;
    @Enumerated(EnumType.STRING)
    private Status statut;
    private LocalDate startTime;
    private LocalDate endTime;

    @ManyToOne
    private Utilisateur etudiant;

    @ManyToOne
    private Utilisateur validateur;


}
