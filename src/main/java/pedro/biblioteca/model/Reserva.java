package pedro.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Data
@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vaga_id", nullable = false)
    private Vaga vaga;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "vendedor_id", nullable = true)
    private Vendedor vendedor;

    @NotNull(message = "Obrigatório informar a data e hora da reserva")
    @CreatedDate
    private Date dataHoraReserva;

    @NotNull(message = "Obrigatório informar a data e hora de término da reserva")
    private Date dataHoraTermino;

    @NotNull(message = "Obrigatório informar o valor da reserva")
    private Double valor;
}
