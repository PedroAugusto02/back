package pedro.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Estacionamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Obrigatório possuir um nome")
    private String nome;

    @NotNull(message = "Obrigatório possuir um endereço")
    private String endereco;

    @NotNull(message = "Obrigatório informar a quantidade de vagas")
    private Integer quantidadeVagas;

    @OneToMany(mappedBy = "estacionamento")
    private List<Vaga> vagas;

    @ManyToMany
    @JoinTable(
            name = "estacionamento_vendedor",
            joinColumns = @JoinColumn(name = "estacionamento_id"),
            inverseJoinColumns = @JoinColumn(name = "vendedor_id")
    )
    private List<Vendedor> vendedores;

}
