package usecase;

import curso.modelo.NIVELES_VALIDOS;
import curso.output.ICrearCursoRepositorio;
import curso.modelo.Curso;
import curso.usecase.CrearCursoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class CrearCursoUseCaseUnitTest {

    @Mock
    ICrearCursoRepositorio crearCursoRepositorio;

    @Test
    public void crearCurso() {

//      arrange
        Curso elCurso = Curso.instancia(1234,"Alberto", LocalDate.of(2023,12,3), NIVELES_VALIDOS.INICIAL);

        CrearCursoUseCase crearCursoUseCase= new CrearCursoUseCase(crearCursoRepositorio);

        when(crearCursoRepositorio.exist(elCurso.getNombre())).thenReturn(false);
        when(crearCursoRepositorio.save(elCurso)).thenReturn(true);


//        act
        boolean resultado=crearCursoUseCase.crearCurso(elCurso);

//        Assert
        Assertions.assertTrue(resultado);

    }

}
