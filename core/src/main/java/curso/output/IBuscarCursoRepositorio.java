package curso.output;

import curso.modelo.Curso;

public interface IBuscarCursoRepositorio {
    boolean exist(String nombreCurso);
    Curso buscarCurso(String nombreCurso);
}
