package pedro.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pedro.biblioteca.model.Livro;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByGenre(String genre);
    List<Livro> findByAvailable(boolean available);
    List<Livro> findByRating(Integer rating);

}
