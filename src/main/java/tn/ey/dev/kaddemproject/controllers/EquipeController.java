package tn.ey.dev.kaddemproject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.ey.dev.kaddemproject.entities.Equipe;
import tn.ey.dev.kaddemproject.services.IEquipeServices;

import java.util.List;

@Tag(name = "Equipe")
@RestController
@RequestMapping("equipe")
@RequiredArgsConstructor
public class EquipeController {
    //@Autowired
    IEquipeServices iEquipeServices;
    @GetMapping()
    public List<Equipe> getAllEquipe(){
        return iEquipeServices.getAllEquipe();
    }
    @GetMapping("/{id}")
    public Equipe getByIdEquipe(@PathVariable int id){
        return iEquipeServices.getByIdEquipe(id);
    }
    @DeleteMapping("/{id}")
    private void deleteEquipe(@PathVariable int id){
        iEquipeServices.deleteEquipe(id);
    }
    @PostMapping()
    public void ajouterEquipe(@RequestBody Equipe equipe){
        iEquipeServices.ajouterEquipe(equipe);
    }
    @PutMapping()
    private Equipe updateEquipe(@RequestBody Equipe equipe){
        iEquipeServices.updateEquipe(equipe);
        return equipe;
    }
    @PostMapping("/evoluerEquipes")
    public void faireEvoluerEquipes(){
        iEquipeServices.faireEvoluerEquipes();
    }
}
