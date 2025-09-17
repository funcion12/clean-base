package curso.usecase;

import curso.exception.CursoNoExisteException;
import curso.exception.CursoNullOVacio;
import curso.input.IBuscarCursoInput;
import curso.modelo.Curso;
import curso.output.IBuscarCursoRepositorio;

public class BuscarCursoUseCase implements IBuscarCursoInput {

    private final IBuscarCursoRepositorio buscarCursoRepositorio;

    public BuscarCursoUseCase(IBuscarCursoRepositorio buscarCursoRepositorio) {
        this.buscarCursoRepositorio = buscarCursoRepositorio;
    }

    @Override
    public Curso buscarCurso(String nombreCurso) throws CursoNullOVacio, CursoNoExisteException {
        if (nombreCurso == null || nombreCurso.trim().isEmpty()) {
            throw new CursoNullOVacio();
        }

        boolean existe = buscarCursoRepositorio.exist(nombreCurso);
        if (!existe) {
            throw new CursoNoExisteException();
        }

        return buscarCursoRepositorio.buscarCurso(nombreCurso);
    }

}
