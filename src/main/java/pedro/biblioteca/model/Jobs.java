
package pedro.biblioteca.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Jobs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Obrigatório possuir um título")
    @Length(max = 15, message = "O titulo deve ter no máximo 15 caracteres")
    private String title;

    @Length(max = 50, message = "A descrição deve ter no máximo 25 caracteres")
    private String description;

    @NotNull(message = "Obrigatório informar se o trabalho está ativo ou não")
    private Boolean active;

    @Temporal(TemporalType.DATE)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date creation_date;

    @Temporal(TemporalType.DATE)
    @LastModifiedDate
    @Column(nullable = false)
    private Date updated_at;

    // Chave estrangeira para Usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

}
