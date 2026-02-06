package com.meucrm.crmbackend.repository;

import com.meucrm.crmbackend.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByEmail(String email);
    boolean existsByTelefone(String telefone);

    Cliente findByEmail(String email);
    Cliente findByTelefone(String telefone);
}
