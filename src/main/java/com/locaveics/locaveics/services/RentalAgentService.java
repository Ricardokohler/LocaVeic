package com.locaveics.locaveics.services;

import com.locaveics.locaveics.entities.RentalAgent;
import com.locaveics.locaveics.repositories.RentalAgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RentalAgentService {

    @Autowired
    private RentalAgentRepository repository;

    //Create
    public RentalAgent create(RentalAgent RentalAgent){
        return repository.save(RentalAgent);
    }

    //GetAll
    public List <RentalAgent> getAll(){
        return repository.findAll();
    }

    //GetById
    public Optional <RentalAgent> getById(Long id) {
        return repository.findById(id);

    }

    //Delete
    public void delete(Long id){
        repository.deleteById(id);
    }

    //Update
    public RentalAgent update(RentalAgent rentalAgent, Long id){
        Optional<RentalAgent> oldRentalAgent = repository.findById(id);

        if (oldRentalAgent.isPresent()) {
            RentalAgent newRentalAgent = oldRentalAgent.get();

            newRentalAgent.setName(rentalAgent.getName());
            newRentalAgent.setAddress(rentalAgent.getAddress());
            newRentalAgent.setPhone(rentalAgent.getPhone());
            newRentalAgent.setContractDate(rentalAgent.getContractDate());
            return repository.save(newRentalAgent);
        }

         else throw new RuntimeException("Id não encontrado") ; }


}
