package com.meucrm.crmbackend.service;

import com.meucrm.crmbackend.model.Cliente;
import com.meucrm.crmbackend.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente cadastrarCliente(String nome, String telefone, String email, String senha) {
        if (clienteRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email já cadastrado");
        }

        if (clienteRepository.existsByTelefone(telefone)) {
            throw new IllegalArgumentException("Telefone já cadastrado");
        }

        Cliente cliente = new Cliente(nome, telefone, email, senha, LocalDate.now());

        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorEmail(String email) {
        return clienteRepository.findByEmail(email);
    }

    public Cliente buscarPorTelefone(String telefone) {
        return clienteRepository.findByTelefone(telefone);
    }

    public void alterarEmail(Long id, String email) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        if(clienteRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email já existe");
        }

        cliente.setEmail(email);
        clienteRepository.save(cliente);
    }

    public void alterarSenha(Long id, String novaSenha) {
        Cliente cliente = clienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cliente.setSenha(novaSenha);
        clienteRepository.save(cliente);
    }
}
