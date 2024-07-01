package com.isackaik.projetos.gerenciamentovendas.repositories;

import com.isackaik.projetos.gerenciamentovendas.models.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
