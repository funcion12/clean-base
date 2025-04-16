package usecase;

import curso.output.ICrearCursoRepositorio;
import curso.modelo.Curso;
import curso.usecase.CrearCursoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class CrearCursoUseCaseUnitTest {

    @Mock
    ICrearCursoRepositorio crearCursoRepositorio;

    @Test
    public void crearCurso() {

//      arrange
        Curso elCurso = Curso.instancia(1234,"Alberto","10-12-2023","Inicial");

        CrearCursoUseCase crearCursoUseCase= new CrearCursoUseCase(crearCursoRepositorio);

        when(crearCursoRepositorio.exist(elCurso.getNombre())).thenReturn(false);
//        act
        boolean resultado=crearCursoUseCase.crearCurso(elCurso);

//        Assert
        Assertions.assertTrue(resultado);

    }

}
