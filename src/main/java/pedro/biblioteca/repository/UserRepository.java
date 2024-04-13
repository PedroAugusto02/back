package pedro.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pedro.biblioteca.model.Usuario;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByAge(Integer age);
    List<Usuario> findByActive(Boolean active);

}
