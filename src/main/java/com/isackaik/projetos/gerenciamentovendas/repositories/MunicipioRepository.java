package com.isackaik.projetos.gerenciamentovendas.repositories;

import com.isackaik.projetos.gerenciamentovendas.models.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {

    @Query("SELECT m FROM Municipio m WHERE m.nome =:nome")
    Municipio findByNome(@Param("nome") String nome);

}
