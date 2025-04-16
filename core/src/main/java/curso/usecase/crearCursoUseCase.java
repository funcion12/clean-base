package curso.usecase;

import curso.modelo.Curso;
import curso.input.ICrearCursoInput;
import curso.output.ICrearCursoRepositorio;

public class CrearCursoUseCase implements ICrearCursoInput {

    private final ICrearCursoRepositorio crearCursoRepositorio;

    public CrearCursoUseCase(ICrearCursoRepositorio crearCursoRepositorio) {

        this.crearCursoRepositorio = crearCursoRepositorio;

    }

    @Override
    public boolean crearCurso(Curso elCurso) {
        
        if (elCurso == null) {
            return false;
        }
        
        return crearCursoRepositorio.save(elCurso);
    }
}
