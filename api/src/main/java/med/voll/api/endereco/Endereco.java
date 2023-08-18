package med.voll.api.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String bairro;
    private String logradouro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;
}
