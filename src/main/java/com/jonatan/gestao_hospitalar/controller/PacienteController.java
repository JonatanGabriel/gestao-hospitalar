package com.jonatan.gestao_hospitalar.controller;

import com.jonatan.gestao_hospitalar.model.Paciente;
import com.jonatan.gestao_hospitalar.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    // CREATE - cadastrar paciente
    @PostMapping
    public Paciente criarPaciente(@RequestBody Paciente paciente) {
        return pacienteRepository.save(paciente);
    }

    // READ - listar todos
    @GetMapping
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }

    // READ - buscar por ID
    @GetMapping("/{id}")
    public Optional<Paciente> buscarPaciente(@PathVariable Long id) {
        return pacienteRepository.findById(id);
    }

    // UPDATE - editar paciente
    @PutMapping("/{id}")
    public Paciente atualizarPaciente(@PathVariable Long id, @RequestBody Paciente pacienteAtualizado) {
        return pacienteRepository.findById(id)
                .map(paciente -> {
                    paciente.setNome(pacienteAtualizado.getNome());
                    paciente.setCpf(pacienteAtualizado.getCpf());
                    paciente.setDataNascimento(pacienteAtualizado.getDataNascimento());
                    paciente.setTelefone(pacienteAtualizado.getTelefone());
                    paciente.setEmail(pacienteAtualizado.getEmail());
                    paciente.setEndereco(pacienteAtualizado.getEndereco());
                    return pacienteRepository.save(paciente);
                })
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com id: " + id));
    }

    // DELETE - excluir paciente
    @DeleteMapping("/{id}")
    public void deletarPaciente(@PathVariable Long id) {
        pacienteRepository.deleteById(id);
    }
}
