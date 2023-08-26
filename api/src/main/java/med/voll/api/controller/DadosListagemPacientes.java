package med.voll.api.controller;

import med.voll.api.paciente.Paciente;

public record DadosListagemPacientes(String nome, String email, String cpf) {
    public DadosListagemPacientes(Paciente paciente){
        this(paciente.getNome(),paciente.getEmail(),paciente.getCpf());
    }
}
