package usecase;

import curso.modelo.Curso;
import curso.output.IBuscarCursoRepositorio;
import curso.usecase.CrearCursoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)

public class BuscarCursoUseCaseUnitTest   {

        @Mock
        IBuscarCursoRepositorio buscarCursoRepositorio;

        @Test
        public void buscarCurso() {
                // Arrange
                Curso elCurso = Curso.instancia(1234, "Alberto", "10-12-2023", "Inicial");
                BuscarCursoUseCase buscarCursoUseCase = new BuscarCursoUseCase(buscarCursoRepositorio);

                when(buscarCursoRepositorio.exist(elCurso.getNombre())).thenReturn(true);

                // Act
                boolean resultado = buscarCursoUseCase.buscarCurso(elCurso);

                // Assert
                Assertions.assertTrue(resultado);
        }
}
