package persistencia.crud;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import persistencia.entity.CursoEntity;

import java.util.UUID;

@Repository
public interface IBuscarCursoCRUD extends CrudRepository<CursoEntity, UUID> {
    CursoEntity encontrarNombre(String nombre);

}
