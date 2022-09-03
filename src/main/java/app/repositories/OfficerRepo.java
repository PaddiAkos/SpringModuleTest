package app.repositories;

import app.models.Officer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OfficerRepo extends CrudRepository<Officer, Long > {

    Officer findAllByUsername(String username);

}
