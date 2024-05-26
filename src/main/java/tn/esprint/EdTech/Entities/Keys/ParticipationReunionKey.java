package tn.esprint.EdTech.Entities.Keys;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class ParticipationReunionKey implements Serializable {
    private static final long serialVersionUID = -270318519857743333L;
    private long id_reunion;
    private long id_user;
}
