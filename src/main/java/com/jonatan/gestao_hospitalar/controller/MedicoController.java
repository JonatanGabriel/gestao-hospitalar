package com.jonatan.gestao_hospitalar.controller;

import com.jonatan.gestao_hospitalar.model.Medico;
import com.jonatan.gestao_hospitalar.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    // CREATE - cadastrar novo médico
    @PostMapping
    public Medico criarMedico(@RequestBody Medico medico) {
        return medicoRepository.save(medico);
    }

    // READ - listar todos os médicos
    @GetMapping
    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    // READ - buscar médico por ID
    @GetMapping("/{id}")
    public Optional<Medico> buscarMedico(@PathVariable Long id) {
        return medicoRepository.findById(id);
    }

    // UPDATE - atualizar dados do médico
    @PutMapping("/{id}")
    public Medico atualizarMedico(@PathVariable Long id, @RequestBody Medico medicoAtualizado) {
        return medicoRepository.findById(id).map(medico -> {
            medico.setNome(medicoAtualizado.getNome());
            medico.setEspecialidade(medicoAtualizado.getEspecialidade());
            medico.setCrm(medicoAtualizado.getCrm());
            medico.setEmail(medicoAtualizado.getEmail());
            medico.setTelefone(medicoAtualizado.getTelefone());
            return medicoRepository.save(medico);
        }).orElseThrow(() -> new RuntimeException("Médico não encontrado com id: " + id));
    }

    // DELETE - excluir médico
    @DeleteMapping("/{id}")
    public void deletarMedico(@PathVariable Long id) {
        medicoRepository.deleteById(id);
    }
}
