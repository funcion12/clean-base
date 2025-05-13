package ar.edu.undec.adapter.data.curso;

import curso.modelo.Curso;
import curso.modelo.NIVELES_VALIDOS;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import persistencia.crud.ICrearCursoCRUD;
import persistencia.entity.CursoEntity;
import persistencia.repository.CrearCursoRepositoryImpl;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CrearCursoDataTest {

    @Mock
    ICrearCursoCRUD crearCursoCRUD;

    @InjectMocks
    CrearCursoRepositoryImpl crearCursoRepositoryImpl;

    @Test
    public void saveCurso_Curso_Exitosa() {
        Curso curso = Curso.instancia(UUID.randomUUID(),"Alberto", LocalDate.MAX, NIVELES_VALIDOS.AVANZADO);
        CursoEntity cursoEntity = CursoEntity.instancia(curso);
        when(crearCursoCRUD.save(any(CursoEntity.class))).thenReturn(cursoEntity);
        boolean resultado = crearCursoRepositoryImpl.save(curso);
        Assertions.assertTrue(resultado);
    }

    @Test
    public void saveCurso_Curso_Erroriamente() {
        Curso course = Curso.instancia(UUID.randomUUID(), "name", LocalDate.MAX, NIVELES_VALIDOS.AVANZADO);
        when(crearCursoCRUD.save(any(CursoEntity.class))).thenThrow(RuntimeException.class);
        boolean result = crearCursoRepositoryImpl.save(course);
        Assertions.assertFalse(result);
    }
}
