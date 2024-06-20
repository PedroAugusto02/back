package pedro.biblioteca.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.util.List;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Obrigatório possuir um nome")
    @Length(max = 50, message = "O nome deve ter no máximo 50 caracteres")
    private String name;

    @NotNull(message = "Obrigatório possuir um email")
    @Email
    private String email;

    @Min(value = 18, message = "Obrigatório ser maior de idade")
    private Integer age;

    @NotNull(message = "Obrigatório informar se o usuário está ativo ou não")
    private Boolean active;

    @Temporal(TemporalType.DATE)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date creation_date;

    @Temporal(TemporalType.DATE)
    @LastModifiedDate
    @Column(nullable = false)
    private Date updated_at;

    // Relacionamento um usuário pode ter muitos trabalhos
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Jobs> jobs;

    @OneToMany(mappedBy = "usuario")
    private List<Carro> carros;

    @OneToMany(mappedBy = "usuario")
    private List<Reserva> reservas;

}
