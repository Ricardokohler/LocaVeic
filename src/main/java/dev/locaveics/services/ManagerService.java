package dev.locaveics.services;

import dev.locaveics.entities.Manager;
import dev.locaveics.entities.dtos.ManagerDto;
import dev.locaveics.entities.mappers.ClientMapper;
import dev.locaveics.entities.mappers.ManagerMapper;
import dev.locaveics.repositories.ManagerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ManagerService {

    private final ManagerRepository repository;

    public ManagerService(ManagerRepository repository){
        this.repository= repository;
    }


    //create
    public ManagerDto create(ManagerDto managerDto){
        Manager createdManager = ManagerMapper.map(managerDto);

        createdManager = repository.save(createdManager);
        return ManagerMapper.map(createdManager);
    }


    //getAll
    public List<ManagerDto> getAll(){
        List<Manager> managerList = repository.findAll();

        return managerList.stream()
                .map(ManagerMapper::map)
                .collect(Collectors.toList());
    }


    //getById
    public ManagerDto getById(Long id){
        Optional <Manager> optionalManager = repository.findById(id);

        return optionalManager.map(ManagerMapper::map).orElse(null);
    }


    //getByFullName
    public ManagerDto getByFullName(String name){
        Optional<Manager> optionalManager = repository.findByName(name);

        return optionalManager.map(ManagerMapper::map).orElse(null);
    }


    //getByCpf
    public ManagerDto getByCpf(String cpf){
        Optional<Manager> optionalManager = repository.findByName(cpf);

        return optionalManager.map(ManagerMapper::map).orElse(null);
    }


    //getByEmail
    public ManagerDto getByEmail(String email){
        Optional<Manager> optionalManager = repository.findByName(email);

        return optionalManager.map(ManagerMapper::map).orElse(null);
    }


    //updateById
    public ManagerDto updateById(Long id, ManagerDto managerDto){
        Optional<Manager> oldManager = repository.findById(id);

        if(oldManager.isPresent()){
            Manager newManager = ManagerMapper.map(managerDto);
            newManager.setId(id);

            repository.save(newManager);
            return ManagerMapper.map(newManager);
        } else throw new RuntimeException("Id not found");

    }

    //deleteById
    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
