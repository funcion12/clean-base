package curso.exception;

public class CursoExisteException extends Exception {

    @Override
    public String getMessage() {
        return "Ya existe un curso con ese nombre";
    }
}
