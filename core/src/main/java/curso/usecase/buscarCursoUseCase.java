package curso.usecase;
import curso.input.IBuscarCursoInput;
import curso.output.IBuscarCursoRepositorio;
import curso.modelo.Curso;


public class BuscarCursoUseCase implements  IBuscarCursoInput {
   
    private final IBuscarCursoRepositorio buscarCursoRepositorio;
    
    public BuscarCursoUseCase(IBuscarCursoRepositorio buscarCursoRepositorio) {
        
        this.buscarCursoRepositorio = buscarCursoRepositorio;
    }

    @Override
    public boolean buscarCurso(String nombreCurso) {
        if (nombreCurso == null || nombreCurso.isEmpty()) {
            return false;
        }
        
        return buscarCursoRepositorio.buscarCurso(nombreCurso);
    }   
}
