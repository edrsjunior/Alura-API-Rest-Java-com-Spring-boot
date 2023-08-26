package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedicos;
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
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedicos> listar(@PageableDefault(size = 10, sort = {"nome"} ) org.springframework.data.domain.Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemMedicos::new);
        /*
         * TA VAMO LA:
         * repository é o responsavel por fazer a conexão com a tabela medicos
         * FINDALL => Retorna todas as linhas da tabela
         * .MAP => Converte para o objeto da classe passada usando o construtor criado
         * O METODO PRECIS DEVOLVER UM PAGE COMO FOI PASSADO O ATRIBUTO DE SOBREPOSICAO Pageable ao method E TBM O OBJETO DE PAGINACAO AO METHOD findall
         */
    }
}
