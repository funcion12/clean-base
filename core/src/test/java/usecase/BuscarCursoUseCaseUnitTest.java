package usecase;


import curso.exception.CursoNoExisteException;
import curso.exception.CursoNullOVacio;
import curso.modelo.Curso;
import curso.modelo.NIVELES_VALIDOS;
import curso.output.IBuscarCursoRepositorio;
import curso.usecase.BuscarCursoUseCase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.UUID;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)

public class BuscarCursoUseCaseUnitTest   {

        @Mock
        IBuscarCursoRepositorio buscarCursoRepositorio;

        @Test
        public void buscarCurso() throws  CursoNullOVacio, CursoNoExisteException  {
                // Arrange
                String nombreCurso = "Alberto";
                Curso elCurso = Curso.instancia(UUID.randomUUID(), nombreCurso, LocalDate.of(2023, 12, 3), NIVELES_VALIDOS.INICIAL);
                BuscarCursoUseCase buscarCursoUseCase = new BuscarCursoUseCase(buscarCursoRepositorio);

                when(buscarCursoRepositorio.exist(nombreCurso)).thenReturn(true);
                when(buscarCursoRepositorio.buscarCurso(nombreCurso)).thenReturn(elCurso);

                // Act
                Curso resultado = buscarCursoUseCase.buscarCurso(nombreCurso);

                // Assert
                Assertions.assertNotNull(resultado);
                Assertions.assertEquals(nombreCurso, resultado.getNombre());
        }

        @Test
        public void buscarCurso_cursoNoExiste_CursoNoExisteException()throws  CursoNullOVacio, CursoNoExisteException  {
                // Arrange
                String nombreCurso = "Alberto";
                BuscarCursoUseCase buscarCursoUseCase = new BuscarCursoUseCase(buscarCursoRepositorio);

                when(buscarCursoRepositorio.exist(nombreCurso)).thenReturn(false);

                // Assert + Act
                Assertions.assertThrows(CursoNoExisteException.class, () -> buscarCursoUseCase.buscarCurso(nombreCurso));
        }

}
