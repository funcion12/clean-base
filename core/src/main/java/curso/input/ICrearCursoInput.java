package curso.input;

import curso.exception.CursoExisteException;
import curso.modelo.Curso;

public interface ICrearCursoInput {
   boolean crearCurso(Curso elCurso) throws CursoExisteException;
}
