package com.jonatan.gestao_hospitalar.repository;

import com.jonatan.gestao_hospitalar.model.Prontuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProntuarioRepository extends JpaRepository<Prontuario, Long> {
    // Aqui vc pode add métodos para customizar
}
