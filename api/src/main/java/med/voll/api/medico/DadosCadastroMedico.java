package med.voll.api.medico;

import med.voll.api.endereco.DadosEndereco;
/*
 *A classe é um record ou seja nao precisa dos getters e setters explicitos
 * Obs: os atributos Especialidade é um ENUM
 * o atributo DadosEndereco é outro record
 */
public record DadosCadastroMedico(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {

}
