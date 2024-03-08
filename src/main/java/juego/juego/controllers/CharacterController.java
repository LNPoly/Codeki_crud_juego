package juego.juego.controllers;

import juego.juego.models.GameCharacter;
import juego.juego.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Controller
@RequestMapping("/character")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping("/all")
    public List<GameCharacter> getAll(){
        return characterService.getAllCharacters();
    }

    @GetMapping("/{id}")
    public GameCharacter searchCharacterById(@PathVariable Long id){
        return characterService.searchById(id);
    }

    @PostMapping("/create")
    public void createCharacter(@RequestBody GameCharacter gameCharacter){
        characterService.createCharacter(gameCharacter);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCharacter(@PathVariable Long id){
        characterService.deleteById(id);
    }

    @PutMapping("/update")
    public GameCharacter updateCharacter(@RequestBody GameCharacter gameCharacter){
        return characterService.updateById(gameCharacter);
    }

    /*

    // codigo  harcodeado

    @GetMapping ("")
    public GameCharacter getCharacter(){
        return characterService.getCharacter();

    }

    @GetMapping("/all")
    public List<GameCharacter> getAllCharacters(){
        return characterService.getAllCharacter();
    }

    @PostMapping("/create")
    public void createCharacter(){
        characterService.createCharacter();
    }
    //public GameCharacter createCharacter(@RequestBody GameCharacter character){
      //  return characterService.createCharacter(character);
    //}

    @GetMapping("/id")
    public GameCharacter searchCharacterById(){
        long id = 3L;
        GameCharacter characterFound = characterService.searchCharacterById(id);
        return characterFound;
    }

    @DeleteMapping("/delete")
    public void deleteCharacter(){
        long id = 3L;
        characterService.deleteCharacterById(id);
    }

     */
}
