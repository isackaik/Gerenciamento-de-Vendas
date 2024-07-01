package com.isackaik.projetos.gerenciamentovendas.services;

import com.isackaik.projetos.gerenciamentovendas.exceptions.RequiredObjectIsNullException;
import com.isackaik.projetos.gerenciamentovendas.exceptions.ResourceNotFoundException;
import com.isackaik.projetos.gerenciamentovendas.models.Cliente;
import com.isackaik.projetos.gerenciamentovendas.models.Endereco;
import com.isackaik.projetos.gerenciamentovendas.models.Municipio;
import com.isackaik.projetos.gerenciamentovendas.repositories.ClienteRepository;
import com.isackaik.projetos.gerenciamentovendas.repositories.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class EnderecoService {

    private EnderecoRepository enderecoRepository;
    private MunicipioService municipioService;
    private Logger logger;

    public EnderecoService(EnderecoRepository enderecoRepository, MunicipioService municipioService) {
        this.enderecoRepository = enderecoRepository;
        this.municipioService = municipioService;
        this.logger = Logger.getLogger(ClienteService.class.getName());
    }

    public Endereco findById(Long id){
        logger.info("Pesquisando endereço pelo ID");
        Optional<Endereco> endereco = enderecoRepository.findById(id);
        if(endereco.isEmpty()){
            throw new ResourceNotFoundException("Endereço não encontrado para este ID");
        }
        return endereco.get();
    }

    public Endereco create(Endereco endereco){
        logger.info("Criando um endereço");
        if(endereco == null) throw new RequiredObjectIsNullException();
        if(endereco.getMunicipio() == null) {
            throw new RequiredObjectIsNullException("Município não informado na criação do endereço.");
        }
        Municipio municipioEncontrado = municipioService.findByNome(endereco.getMunicipio().getNome());
        if(municipioEncontrado == null){
            municipioService.create(endereco.getMunicipio());
        }
        return enderecoRepository.save(endereco);
    }

}
