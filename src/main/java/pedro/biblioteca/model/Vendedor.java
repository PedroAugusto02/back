package pedro.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Obrigatório possuir um nome")
    private String nome;

    @NotNull(message = "Obrigatório possuir um email")
    private String email;

    @ManyToMany(mappedBy = "vendedores")
    private List<Estacionamento> estacionamentos;

}
