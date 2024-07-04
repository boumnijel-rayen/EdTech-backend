package tn.esprint.EdTech.Repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprint.EdTech.Entities.Token;

import java.util.Optional;

@Repository
public interface TokenRepo extends JpaRepository<Token, Integer> {
    Optional<Token> findByToken(String token);
    @Query(value = "DELETE FROM `token` WHERE user_id = :idUser ;", nativeQuery = true)
    @Modifying
    @Transactional
    void deleteByUserId(@Param("idUser") long idUser);
}
