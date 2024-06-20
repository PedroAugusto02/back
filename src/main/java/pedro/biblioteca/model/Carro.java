package pedro.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Obrigatório informar o nome")
    private String nome;

    @NotNull(message = "Obrigatório informar o modelo")
    private String modelo;

    @NotNull(message = "Obrigatório informar a marca")
    private String marca;

    @NotNull(message = "Obrigatório informar a placa")
    private String placa;

    @NotNull(message = "Obrigatório informar a cor")
    private String cor;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
