package com.jonatan.gestao_hospitalar.controller;

import com.jonatan.gestao_hospitalar.model.Consulta;
import com.jonatan.gestao_hospitalar.model.Paciente;
import com.jonatan.gestao_hospitalar.repository.ConsultaRepository;
import com.jonatan.gestao_hospitalar.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    // GET /relatorios/consultas-por-paciente
    @GetMapping("/consultas-por-paciente")
    public Map<String, Integer> relatorioConsultasPorPaciente() {
        List<Consulta> consultas = consultaRepository.findAll();
        Map<String, Integer> resultado = new HashMap<>();

        for (Consulta consulta : consultas) {
            Paciente paciente = consulta.getPaciente();
            String nome = paciente.getNome();
            resultado.put(nome, resultado.getOrDefault(nome, 0) + 1);
        }

        return resultado;
    }
}
