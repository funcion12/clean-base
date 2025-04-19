package curso.usecase;

import curso.input.IBuscarCursoInput;
import curso.output.IBuscarCursoRepositorio;

public class BuscarCursoUseCase implements IBuscarCursoInput {

    private final IBuscarCursoRepositorio buscarCursoRepositorio;

    public BuscarCursoUseCase(IBuscarCursoRepositorio buscarCursoRepositorio) {
        this.buscarCursoRepositorio = buscarCursoRepositorio;
    }

    @Override
    public boolean buscarCurso(String nombreCurso) {
        if (nombreCurso == null || nombreCurso.isEmpty()) {
            return false;
        }
        return buscarCursoRepositorio.exist(nombreCurso);
    }
}
