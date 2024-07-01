package com.isackaik.projetos.gerenciamentovendas.repositories;

import com.isackaik.projetos.gerenciamentovendas.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
