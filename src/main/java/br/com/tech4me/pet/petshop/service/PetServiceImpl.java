package br.com.tech4me.pet.petshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.pet.petshop.model.PetShop;
import br.com.tech4me.pet.petshop.repository.PetRepository;
@Service
public class PetServiceImpl implements PetService{

    @Autowired
    private PetRepository repositorio;

    @Override
    public List<PetShop> obterTodosPet() {
         return repositorio.findAll();
        
    }

    @Override
    public Optional<PetShop> obterPetPorId(String id) {
       
        return repositorio.findById(id);
    }

    @Override
    public void excluirPetPorId(String id) {
        
        repositorio.deleteById(id);
    }

    @Override
    public PetShop cadastrarPet(PetShop pet) {
        
        return repositorio.save(pet);
    }

    @Override
    public Optional<PetShop> atualizarPetPorId(String id, PetShop pet) {
        
        Optional<PetShop> retorno = repositorio.findById(id);

        if (retorno.isPresent()) {
          pet.setId(id);
          return Optional.of(repositorio.save(pet));
        } else {
          return Optional.empty();
        }
    }
    

}
