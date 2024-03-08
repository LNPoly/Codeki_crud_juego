package juego.juego.repositories;


import juego.juego.models.GameCharacter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<GameCharacter, Long> {

}
