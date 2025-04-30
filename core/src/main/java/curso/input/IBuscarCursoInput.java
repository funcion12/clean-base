package curso.input;

import curso.exception.CursoNoExisteException;
import curso.exception.CursoNullOVacio;
import curso.modelo.Curso;

public interface IBuscarCursoInput {
    public Curso buscarCurso(String nombreCurso) throws  CursoNullOVacio, CursoNoExisteException;

}
