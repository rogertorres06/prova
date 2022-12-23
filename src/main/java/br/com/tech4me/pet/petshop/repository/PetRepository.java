package br.com.tech4me.pet.petshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4me.pet.petshop.model.PetShop;

public interface PetRepository extends MongoRepository<PetShop, String>  {
    
}
