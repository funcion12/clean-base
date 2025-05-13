package usecase;

import curso.exception.CursoExisteException;
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
import java.util.UUID;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class CrearCursoUseCaseUnitTest {

    @Mock
    ICrearCursoRepositorio crearCursoRepositorio;

    @Test
    public void crearCurso_cursoNoExiste_CrearCurso() throws CursoExisteException {

//      arrange
        Curso elCurso = Curso.instancia(UUID.randomUUID(),"Alberto", LocalDate.of(2023,12,3), NIVELES_VALIDOS.INICIAL);

        CrearCursoUseCase crearCursoUseCase= new CrearCursoUseCase(crearCursoRepositorio);

        //SIMULACION DE BASE DE DATOS
        when(crearCursoRepositorio.exist(elCurso.getNombre())).thenReturn(false);
        when(crearCursoRepositorio.save(elCurso)).thenReturn(true);

//        act

        boolean resultado=crearCursoUseCase.crearCurso(elCurso);

//        Assert
        Assertions.assertTrue(resultado);

    }

    @Test
    public void crearCurso_cursoExiste_CursoExisteException() {

//      arrange
        Curso elCurso = Curso.instancia(UUID.randomUUID(),"Alberto", LocalDate.of(2023,12,3)
        , NIVELES_VALIDOS.INICIAL);

        CrearCursoUseCase crearCursoUseCase = new CrearCursoUseCase(crearCursoRepositorio);



        //SIMULACION DE BASE DE DATOS
        when(crearCursoRepositorio.exist("Alberto")).thenReturn(true);

//        act
//        Assert

        Assertions.assertThrows(CursoExisteException.class,()->crearCursoUseCase.crearCurso(elCurso));

    }

}
