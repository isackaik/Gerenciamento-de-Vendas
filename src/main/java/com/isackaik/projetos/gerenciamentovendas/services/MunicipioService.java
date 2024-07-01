package com.isackaik.projetos.gerenciamentovendas.services;

import com.isackaik.projetos.gerenciamentovendas.exceptions.RequiredObjectIsNullException;
import com.isackaik.projetos.gerenciamentovendas.exceptions.ResourceNotFoundException;
import com.isackaik.projetos.gerenciamentovendas.models.Municipio;
import com.isackaik.projetos.gerenciamentovendas.repositories.MunicipioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class MunicipioService {

    private MunicipioRepository municipioRepository;
    private Logger logger;

    public MunicipioService(MunicipioRepository municipioRepository) {
        this.municipioRepository = municipioRepository;
        this.logger = Logger.getLogger(MunicipioService.class.getName());
    }

    public Municipio findById(Long id){
        logger.info("Pesquisando município pelo ID");
        Optional<Municipio> municipio = municipioRepository.findById(id);
        if(municipio.isEmpty()){
            throw new ResourceNotFoundException("Município não encontrado para este ID");
        }
        return municipio.get();
    }

    public Municipio findByNome(String nome){
        logger.info("Pesquisando município pelo nome");
        Municipio municipio = municipioRepository.findByNome(nome);
        if(municipio == null){
            throw new ResourceNotFoundException("Município não encontrado para este nome");
        }
        return municipio;
    }

    public Municipio create(Municipio municipio){
        logger.info("Criando um município");
        if(municipio == null) throw new RequiredObjectIsNullException();
        if(municipio.getEstado() == null) {
            throw new RequiredObjectIsNullException("Estado não informado na criação do endereço.");
        }
        return municipioRepository.save(municipio);
    }

}