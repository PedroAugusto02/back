package pedro.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.biblioteca.model.Jobs;

import java.util.List;

public interface JobsRepository extends JpaRepository<Jobs, Long> {

    @Override
    List<Jobs> findAll();
}
