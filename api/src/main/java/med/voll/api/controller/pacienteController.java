package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.pacienteRepository;

@RestController
@RequestMapping("pacientes")
public class pacienteController {
    
@Autowired
private pacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarPacientes(@RequestBody DadosCadastroPaciente dados){
        repository.save(new Paciente(dados));
    }
}
