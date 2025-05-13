package persistencia.repository;

import curso.modelo.Curso;
import curso.output.ICrearCursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import persistencia.crud.ICrearCursoCRUD;
import persistencia.entity.CursoEntity;

@Repository
public class CrearCursoRepositoryImpl implements ICrearCursoRepositorio {

    ICrearCursoCRUD crearCursoCRUD;

    @Autowired
    public CrearCursoRepositoryImpl(ICrearCursoCRUD crearCursoCRUD) {
        this.crearCursoCRUD = crearCursoCRUD;
    }

    @Override
    public boolean exist(String nombreCurso) {
        if(nombreCurso==null || nombreCurso.isEmpty()) return false;
        try{return crearCursoCRUD.existsByNombre(nombreCurso);
        }catch(Exception e){return false;}

    }

    @Override
    public boolean save(Curso curso) {
        try{
            crearCursoCRUD.save(CursoEntity.instancia(curso));
            return true;
        }catch(Exception e){return false;}

    }
}
