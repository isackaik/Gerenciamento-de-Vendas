package com.isackaik.projetos.gerenciamentovendas.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private LocalDateTime dataCadastro;
    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(Long id, String nome, LocalDateTime dataCadastro, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.dataCadastro = dataCadastro;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}
