package com.isackaik.projetos.gerenciamentovendas.repositories;

import com.isackaik.projetos.gerenciamentovendas.models.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, String> {
}
