package com.jonatan.gestao_hospitalar.repository;

import com.jonatan.gestao_hospitalar.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    // Aqui vc pode add métodos para customizar
}
