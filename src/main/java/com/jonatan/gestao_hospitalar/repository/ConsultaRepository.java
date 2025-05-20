package com.jonatan.gestao_hospitalar.repository;

import com.jonatan.gestao_hospitalar.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    // Aqui vc pode add métodos para customizar
}
