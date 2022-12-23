package br.com.tech4me.pet.petshop.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.tech4me.pet.petshop.model.PetShop;
import br.com.tech4me.pet.petshop.service.PetService;

@RestController
@RequestMapping("/pet")
public class PetController {
    @Autowired
    private PetService servico;

    @PostMapping
    public ResponseEntity<PetShop> cadastrarPet(@RequestBody PetShop pet) {
        
        return new ResponseEntity<>(servico.cadastrarPet(pet), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PetShop>> obterPet() {
      return new ResponseEntity<>(servico.obterTodosPet(), HttpStatus.OK);
    }


    @GetMapping(value="/{id}")
    public ResponseEntity<PetShop> obterPet (@PathVariable String id) {
      Optional<PetShop> retorno = servico.obterPetPorId(id);
  
      if (retorno.isPresent()){
        return new ResponseEntity<>(retorno.get(), HttpStatus.FOUND);
      }
      else{
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> excluirPet(@PathVariable String id){
      servico.excluirPetPorId(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    
    }

    @PutMapping("/{id}")
  public ResponseEntity<PetShop> atualizarPet(@PathVariable String id, @RequestBody PetShop pet){
    Optional<PetShop> retorno = servico.atualizarPetPorId(id, pet); 

    if (retorno.isPresent()) {
      return new ResponseEntity<>(retorno.get(), HttpStatus.ACCEPTED);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
    }
}
}