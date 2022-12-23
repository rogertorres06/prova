package br.com.tech4me.pet.petshop.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.pet.petshop.model.PetShop;

public interface PetService {

    List<PetShop> obterTodosPet();
    Optional<PetShop> obterPetPorId(String id);
    void excluirPetPorId(String id);
    PetShop cadastrarPet(PetShop pet);
    Optional<PetShop> atualizarPetPorId(String id, PetShop pet);
    
}
