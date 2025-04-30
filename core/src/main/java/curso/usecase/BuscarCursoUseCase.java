package curso.usecase;

import curso.input.IBuscarCursoInput;
import curso.output.IBuscarCursoRepositorio;

public class BuscarCursoUseCase implements IBuscarCursoInput {

    private final IBuscarCursoRepositorio buscarCursoRepositorio;

    public BuscarCursoUseCase(IBuscarCursoRepositorio buscarCursoRepositorio) {
        this.buscarCursoRepositorio = buscarCursoRepositorio;
    }

    @Override
    public boolean buscarCurso(String nombreCurso) throws IllegalAccessException {
        if (nombreCurso == null || nombreCurso.isEmpty()) {
            throw new IllegalAccessException("El nombre del curso no puede ser nulo o vacio");
        }
        return buscarCursoRepositorio.exist(nombreCurso);
    }
}
