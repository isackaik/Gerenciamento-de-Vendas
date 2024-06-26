package com.isackaik.projetos.gerenciamentovendas.dtos;

import java.io.Serializable;
import java.util.Objects;

public class AccountCredentialsDTO {

    private String username;
    private String password;

    public AccountCredentialsDTO() {
    }

    public AccountCredentialsDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountCredentialsDTO that = (AccountCredentialsDTO) o;
        return Objects.equals(username, that.username) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
