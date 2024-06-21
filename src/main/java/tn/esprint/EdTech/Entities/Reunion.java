package tn.esprint.EdTech.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Reunion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String sujet;
    private String description;
    private Date date;

    @ManyToOne
    private Utilisateur organisateur;

    @OneToMany(mappedBy = "reunion")
    @JsonIgnore
    private Set<ParticipationReunion> participants;
}
