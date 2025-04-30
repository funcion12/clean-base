package curso.exception;

public class CursoNoExisteException extends Exception {
    @Override
    public String getMessage() {
        return "No existe un curso con ese nombre";
    }
}
