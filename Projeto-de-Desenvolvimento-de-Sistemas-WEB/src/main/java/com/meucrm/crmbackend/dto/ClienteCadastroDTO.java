package com.meucrm.crmbackend.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteCadastroDTO {
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    public ClienteCadastroDTO() {
    }
}
