package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;
/*
 *A classe é um record ou seja nao precisa dos getters e setters explicitos
 * Obs: os atributos Especialidade é um ENUM
 * o atributo DadosEndereco é outro record
 */
public record DadosCadastroMedico(
    
    /*
     * AQUI VAMOS USAR A DEPENCIA VALIDATION QUE FAZ USO DO BEAN VALIDATION ASSIM NAO TEM QUE FICA  * FAZENDO IF PRA TUDO 
     */

    /*
     * CADA NOTATION É BEM ESPECIFICA SOBRE O QUE FAZ, VALE COMENTAR SOBRE A @Valid QUE INDICA PARA O BEAN VALIDATION QUE DENTRO DESSA RECORD(DadosCadastroMedico) POSSUI OUTRA RECORD(endereco) QUE PRECISA SER VALIDADA DE ACORDO COM AS NOTATIONS DENTRO DELA MESMO
     */

    @NotBlank
    String nome, 
    @NotBlank
    @Email
    String email,
    @NotBlank
    String telefone,
    @NotBlank
    @Pattern(regexp = "\\d{4,6}") 
    String crm, 
    @NotNull
    Especialidade especialidade, 
    @NotNull
    @Valid
    DadosEndereco endereco) {

}
