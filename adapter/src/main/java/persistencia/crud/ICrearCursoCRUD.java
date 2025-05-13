package persistencia.crud;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import persistencia.entity.CursoEntity;

import java.util.UUID;

@Repository
public interface ICrearCursoCRUD extends CrudRepository<CursoEntity, UUID> {
    boolean existsByNombre(String nombre);
}
