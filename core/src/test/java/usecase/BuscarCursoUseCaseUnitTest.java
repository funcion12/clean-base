package usecase;

import curso.modelo.Curso;
import curso.modelo.NIVELES_VALIDOS;
import curso.output.IBuscarCursoRepositorio;
import curso.usecase.CrearCursoUseCase;
import curso.usecase.BuscarCursoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)

public class BuscarCursoUseCaseUnitTest   {

        @Mock
        IBuscarCursoRepositorio buscarCursoRepositorio;

        @Test
        public void buscarCurso() {
                // Arrange
                Curso elCurso = Curso.instancia(1234, "Alberto", LocalDate.of(2023,12,3), NIVELES_VALIDOS.INICIAL);
                BuscarCursoUseCase buscarCursoUseCase = new BuscarCursoUseCase(buscarCursoRepositorio);

                when(buscarCursoRepositorio.exist(elCurso.getNombre())).thenReturn(true);

                // Act
                boolean resultado = buscarCursoUseCase.buscarCurso(elCurso.getNombre());


                // Assert
                Assertions.assertTrue(resultado);
        }
}
