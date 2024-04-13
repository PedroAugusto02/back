package pedro.biblioteca.model;


import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

import java.util.Date;


@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank(message = "Obrigátorio possuir um título")
    @Length(max = 100, message = "O título deve ter no máximo 100 caracteres")
    private String title;

    @NotBlank(message = "Obrigátorio possuir um autor")
    @Length(max = 50, message = "O autor deve ter no máximo 50 caracteres")
    private String author;

    @Length(max = 50, message = "O gênero do livro deve ter no máximo 50 caracteres")
    private String genre;

    @NotNull(message = "Obrigátorio possuir um ano de publicação")
    @Pattern(regexp = "^[0-9]{4}$", message = "Informe o ano com 4 digitos")
    private String publication_year;

    @NotNull(message = "Obrigátorio possuir uma página")
    @Min(value = 1,message = "É obrigatorio ao menos 1 página no livro")
    private Integer pages;

    @NotNull(message = "Obrigátorio possuir indicar se o livro está disponível ou não")
    private boolean available;

    @Min(value = 1,message = "Valor deve ser entre entre 1 e 5")
    @Max(value = 5,message = "Valor deve ser menor que 5")
    private Integer rating;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    @Column(nullable = false)
    private Date updated_at;

}
