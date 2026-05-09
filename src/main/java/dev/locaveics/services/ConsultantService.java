package dev.locaveics.services;

import dev.locaveics.entities.Consultant;
import dev.locaveics.entities.dtos.ConsultantDto;
import dev.locaveics.entities.mappers.ConsultantMapper;
import dev.locaveics.repositories.ConsultantRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ConsultantService {

    private final ConsultantRepository repository;


    public ConsultantService(ConsultantRepository repository) {
        this.repository = repository;
    }

    //create
    public ConsultantDto create(ConsultantDto consultantDto){
        Consultant consultant = ConsultantMapper.map(consultantDto);

        consultant = repository.save(consultant);
        return ConsultantMapper.map(consultant);

    }

    //getAll
    public List<ConsultantDto> getAll(){
        List <Consultant> consultantList = repository.findAll();
        return consultantList.stream()
                .map(ConsultantMapper::map)
                .collect(Collectors.toList());
    }

    //getById
    public ConsultantDto getById(Long id){
        Optional<Consultant> optionalConsultant = repository.findById(id);

        return optionalConsultant.map(ConsultantMapper::map).orElse(null);

    }

        //getByFullName
        public ConsultantDto getByFullName(String name){
            Optional<Consultant> optionalConsultant = repository.findByName(name);

            return optionalConsultant.map(ConsultantMapper::map).orElse(null);
        }

        //getByCpf
        public ConsultantDto getByCpf(String cpf){
            Optional<Consultant> optionalConsultant = repository.findByCpf(cpf);

            return optionalConsultant.map(ConsultantMapper::map).orElse(null);
        }

        //getByEmail
        public ConsultantDto getByEmail(String email){
            Optional<Consultant> optionalConsultant = repository.findByEmail(email);

            return optionalConsultant.map(ConsultantMapper::map).orElse(null);
        }

    //updateById
    public ConsultantDto updateById(Long id, ConsultantDto consultant) throws IOException {
        Optional<Consultant> oldConsultant = repository.findById(id);

        if(oldConsultant.isPresent()){
            Consultant newConsultant = ConsultantMapper.map(consultant);
            newConsultant.setId(id);
            repository.save(newConsultant);
            return ConsultantMapper.map(newConsultant);

        } else throw new IOException("Id not found");
    }

    //deleteById
    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
