package juego.juego.services;

import juego.juego.models.GameCharacter;
import juego.juego.repositories.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RestController
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    public List<GameCharacter> getAllCharacters() { //traer TODA la lista de personajes creados

        return characterRepository.findAll();
    }

    public void createCharacter(GameCharacter gameCharacter) { //crea un personaje

        characterRepository.save(gameCharacter);
    }

    public GameCharacter searchById(Long id) { //buscar un personaje

        return characterRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) { // borra un personaje

        characterRepository.deleteById(id);
    }

    public GameCharacter updateById(GameCharacter gameCharacter) { // actualiza los datos de un personaje

        // Si en POSTMAN se escribe solamente el dato a editar (ej: editar solo el nombre),
        // los demás datos que no aparezcan en el RequestBody, se actualizarán a null.

        characterRepository.save(gameCharacter);
        return characterRepository.findById(gameCharacter.getId()).orElse(null);

    }
}    /*
        //probando metodo de validación de id sin DTO ni MAPPER (necesita revisión)
        if (characterRepository.existsById(id)) {
            GameCharacter gameCharacterToModify = characterRepository.findById(id).get();

            if (gameCharacter.getName() != null) {
                gameCharacterToModify.setName(gameCharacter.getName());
            }
            if (gameCharacter.getRace() != null) {
                gameCharacterToModify.setRace(gameCharacter.getRace());
            }
            if (gameCharacter.getCategory() != null) {
                gameCharacterToModify.setCategory(gameCharacter.getCategory());
            }
            if (gameCharacter.getGuild() != null) {
                gameCharacterToModify.setGuild(gameCharacter.getGuild());
            }
            if (gameCharacter.getLife() != null) {
                gameCharacterToModify.setLife(gameCharacter.getLife());
            }
            if (gameCharacter.getStamina() != null) {
                gameCharacterToModify.setStamina(gameCharacter.getStamina());
            }
            if (gameCharacter.getMana() != null) {
                gameCharacterToModify.setMana(gameCharacter.getMana());
            }
            GameCharacter gameCharacterModified = characterRepository.save(gameCharacterToModify);
            return gameCharacterModified;
        }

    // harcodeando datos

    // lista de personajes
    List<GameCharacter> crearPersonaje = new ArrayList<>();
        GameCharacter character = new GameCharacter(1L, "Fabio", "Human", "Tank", "Lancer", 20000L, 5000, 0);
        GameCharacter character1 = new GameCharacter(2L, "Andurien", "Elf", "Healer", "Priest", 15000L, 0, 5000);
        GameCharacter character2 = new GameCharacter(3L, "Vaoltyr", "Orc", "DPS", "Berserk", 25000L, 10000, 0);
        GameCharacter character3 = new GameCharacter(4L, "Bombur", "Dwarf", "Assassin", "warrior", 15000L, 20000, 0);
        GameCharacter character4 = new GameCharacter(5L, "Adil", "Elf", "Tank", "Lancer", 15000L, 0, 5000);

    public void addCharacter() { // adhiere los personajes a la lista
        crearPersonaje.add(character);
        crearPersonaje.add(character1);
        crearPersonaje.add(character2);
        crearPersonaje.add(character3);
        crearPersonaje.add(character4);
    }

    public List<GameCharacter> getAllCharacter(){ // traer toda la lista de personajes
       // addCharacter();
        return crearPersonaje;
    }

    public GameCharacter getCharacter(){ // buscar un personaje por id
        addCharacter();
        return crearPersonaje.get(0);
    }

    public void createCharacter(){ //crear
        addCharacter();
        crearPersonaje.add(new GameCharacter(6L, "Atila", "Dwarf", "DPS", "Berserk", 25000L, 10000, 0));
    }

    public void deleteCharacterById(Long id) {
        GameCharacter characterToDelete = searchCharacterById(id);
        crearPersonaje.remove(characterToDelete);
    }

    public GameCharacter searchCharacterById(long id) {
        addCharacter();

        for (int i = 0; i < crearPersonaje.size(); i++) {
            if (crearPersonaje.get(i).getId() == id) {
                return crearPersonaje.get(i);
            }
        }
        return null;
    }
     */