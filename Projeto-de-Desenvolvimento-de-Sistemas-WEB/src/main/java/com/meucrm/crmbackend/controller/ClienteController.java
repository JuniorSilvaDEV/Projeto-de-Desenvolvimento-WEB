package com.meucrm.crmbackend.controller;

import com.meucrm.crmbackend.dto.ClienteCadastroDTO;
import com.meucrm.crmbackend.dto.ClienteResponseDTO;
import com.meucrm.crmbackend.model.Cliente;
import com.meucrm.crmbackend.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping(consumes = "application/json")
    public ResponseEntity<ClienteResponseDTO>Cadastrar(@RequestBody ClienteCadastroDTO dto) {
        Cliente salvo = clienteService.cadastrarCliente(dto.getNome(), dto.getTelefone(), dto.getEmail(), dto.getSenha());

        return ResponseEntity.status(HttpStatus.CREATED).body(new ClienteResponseDTO(salvo));
    }

    @GetMapping("/email")
    public ResponseEntity<ClienteResponseDTO>buscarPorEmail(@RequestParam String email) {
        Cliente cliente = clienteService.buscarPorEmail(email);

        ClienteResponseDTO dto = new ClienteResponseDTO(cliente);

        return ResponseEntity.ok(dto);
    }

    @GetMapping("/telefone")
    public ResponseEntity<ClienteResponseDTO>buscarPorTelefone(@RequestParam String telefone) {
        Cliente cliente = clienteService.buscarPorTelefone(telefone);

        ClienteResponseDTO dto = new ClienteResponseDTO(cliente);

        return ResponseEntity.ok(dto);
    }

    @PutMapping("/{id}/email")
    public ResponseEntity<Void>alterarEmail(@PathVariable Long id, @RequestParam String email) {
        clienteService.alterarEmail(id, email);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/senha")
    public ResponseEntity<Void>alterarSenha(@PathVariable Long id, @RequestParam String senha) {
        clienteService.alterarSenha(id, senha);

        return ResponseEntity.noContent().build();
    }
}
