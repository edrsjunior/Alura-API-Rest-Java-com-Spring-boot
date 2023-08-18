package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.medicoRepository;


@RestController
@RequestMapping("medicos")
public class medicoController {
    /*A TAG 
     * @RequestBody indica que o conteudo a ser recebido vira no corpo da requisicao
     * DadosCadastroMedico é uma record que é um tipo de classe para armazenagem de dados de forma facilidade, sem necessitar criar diversos getters e setters, veja mais em: https://medium.com/experiencecode/usando-records-em-java-9afecf7495b3
     */
    /*
     * SOBRE O FUNCIONAMENTO
     * Para receber um json de forma que os dados estejam serializados e nao apenas em uma string é necessário passar os dados para uma classe como exemplicidado abaixo com a record <DadosCadastroMedico>
     */

    @Autowired //Essa notation serve para indicar ao spring que ele deve fazer o instanciamento desse atributo, isso se chama "INJECAO DE DEPENDENCIAS";
    private medicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }
}
