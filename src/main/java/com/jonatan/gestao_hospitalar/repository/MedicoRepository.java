package com.jonatan.gestao_hospitalar.repository;

import com.jonatan.gestao_hospitalar.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    // Aqui vc pode add métodos para customizar
}
