package curso.output;

import curso.modelo.Curso;

public interface ICrearCursoRepositorio {
    boolean exist(String nombreCurso);

    boolean save(Curso elCurso);


}
