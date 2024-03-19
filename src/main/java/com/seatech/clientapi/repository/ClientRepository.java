package com.seatech.clientapi.repository;

import com.seatech.clientapi.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByCpf(String cpf);

}
