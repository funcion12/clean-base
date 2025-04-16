package curso.output;

public interface IBuscarCursoRepositorio {
    boolean exist(String nombreCurso);
    boolean buscarCurso(String nombreCurso);
}
