package dev.locaveics.services;

import dev.locaveics.entities.Consultant;
import dev.locaveics.entities.dtos.ConsultantDto;
import dev.locaveics.entities.mappers.ConsultantMapper;
import dev.locaveics.repositories.ConsultantRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultantService {

    private final ConsultantRepository repository;
    private final ConsultantMapper consultantMapper;

    public ConsultantService(ConsultantRepository repository, ConsultantMapper consultantMapper) {
        this.repository = repository;
        this.consultantMapper = consultantMapper;
    }

    //create
    public ConsultantDto create(ConsultantDto consultantDto){
        Consultant consultant = consultantMapper.map(consultantDto);

        consultant = repository.save(consultant);
        return consultantMapper.map(consultant);

    }

    //getAll
    public List<Consultant> getAll(){
        return repository.findAll();
    }

    //getById
    public Optional<Consultant> getById(Long id){
        return repository.findById(id);
    }

    //getByFullName
    public Optional<Consultant> getByFullName(String name){
        return repository.findByName(name);
    }

    //getByCpf
    public Optional<Consultant> getByCpf(String cpf){
        return repository.findByCpf(cpf);
    }

    //getByEmail
    public Optional<Consultant> getByEmail(String email){
        return repository.findByEmail(email);
    }

    //updateById
    public Consultant updateById(Long id, Consultant consultant) throws IOException {
        Optional<Consultant> oldConsultant = repository.findById(id);

        if(oldConsultant.isPresent()){
            Consultant newConsultant = oldConsultant.get();

            newConsultant.setName(consultant.getName());
            newConsultant.setPhone(consultant.getPhone());
            newConsultant.setCpf(consultant.getCpf());
            newConsultant.setEmail(consultant.getEmail());
            newConsultant.setAddress(consultant.getAddress());

            return repository.save(newConsultant);
        } else throw new IOException("Id not found");
    }

    //deleteById
    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
