package com.meucrm.crmbackend.dto;

import lombok.Getter;

import com.meucrm.crmbackend.model.Cliente;

import java.time.LocalDate;

@Getter
public class ClienteResponseDTO {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private LocalDate dataCadastro;

    public ClienteResponseDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();
        this.dataCadastro = cliente.getDataCadastro();
    }
}
