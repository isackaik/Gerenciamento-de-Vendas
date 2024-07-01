package com.isackaik.projetos.gerenciamentovendas.services;

import com.isackaik.projetos.gerenciamentovendas.exceptions.RequiredObjectIsNullException;
import com.isackaik.projetos.gerenciamentovendas.exceptions.ResourceNotFoundException;
import com.isackaik.projetos.gerenciamentovendas.models.Cliente;
import com.isackaik.projetos.gerenciamentovendas.models.Endereco;
import com.isackaik.projetos.gerenciamentovendas.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class ClienteService {

    private ClienteRepository clienteRepository;
    private EnderecoService enderecoService;
    private Logger logger;

    public ClienteService(ClienteRepository clienteRepository, EnderecoService enderecoService) {
        this.clienteRepository = clienteRepository;
        this.enderecoService = enderecoService;
        this.logger = Logger.getLogger(ClienteService.class.getName());
    }

    public List<Cliente> findAll(){
        logger.info("Pesquisando por todos os Clientes.");
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id){
        logger.info("Pesquisando cliente pelo ID");
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isEmpty()){
            throw new ResourceNotFoundException("Cliente não encontrado para este ID.");
        }
        return cliente.get();
    }

    public Cliente create(Cliente cliente){
        logger.info("Criando um cliente");
        if(cliente == null) throw new RequiredObjectIsNullException();
        if(cliente.getEndereco() == null){
            throw new RequiredObjectIsNullException("Endereço não informado na cadastro do cliente.");
        }
        Endereco enderecoCriado = enderecoService.create(cliente.getEndereco());
        cliente.setEndereco(enderecoCriado);
        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente cliente){
        logger.info("Atualizando um cliente");
        Optional<Cliente> clienteEncontrado = clienteRepository.findById(cliente.getId());
        if(clienteEncontrado.isEmpty()){
            throw new ResourceNotFoundException("Cliente não encontrado para este ID");
        }
        Cliente clienteAtualizado = clienteEncontrado.get();
        clienteAtualizado.setEndereco(cliente.getEndereco());
        clienteAtualizado.setNome(cliente.getNome());
        clienteAtualizado.setDataCadastro(cliente.getDataCadastro());
        return clienteRepository.save(cliente);
    }

    public void delete(Long id){
        logger.info("Deletando um cliente");
        Optional<Cliente> clienteEncontrado = clienteRepository.findById(id);
        if(clienteEncontrado.isEmpty()){
            throw new ResourceNotFoundException("Cliente não encontrado para este ID");
        }
        clienteRepository.delete(clienteEncontrado.get());
    }

}
