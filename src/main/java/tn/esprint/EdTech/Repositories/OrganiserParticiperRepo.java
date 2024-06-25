package tn.esprint.EdTech.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprint.EdTech.Entities.OrganiserParticiper;

@Repository
public interface OrganiserParticiperRepo extends JpaRepository<OrganiserParticiper,Long> {


    //public boolean ajouterEquipeOrganisation()
}
