package tn.ey.dev.kaddemproject.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.ey.dev.kaddemproject.entities.Departement;
import tn.ey.dev.kaddemproject.services.IDepartementServices;

import java.util.List;

@Tag(name = "Departement")
@RestController
@RequestMapping("departement")
@RequiredArgsConstructor
public class DepartementController {
    //@Autowired
    private IDepartementServices iDepartementServices;

    @GetMapping()
    public List<Departement> getAllDepartement(){
        return iDepartementServices.getAllDepartement();
    }
    @GetMapping("/{id}")
    public Departement getByIdDepartement(@PathVariable int id){
        return iDepartementServices.getByIdDepartement(id);
    }
    @DeleteMapping("/{id}")
    private void deleteDepartement(@PathVariable int id){
        iDepartementServices.deleteDepartement(id);
    }
    @PostMapping()
    public void ajouterDepartement(@RequestBody Departement departement){
        iDepartementServices.ajouterDepartement(departement);
    }
    @PutMapping()
    private Departement updateDepartement(@RequestBody Departement departement){
        iDepartementServices.updateDepartement(departement);
        return departement;
    }
}
