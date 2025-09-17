package curso.exception;

public class CursoNullOVacio extends Exception {

    @Override
    public String getMessage() {
        return "El nombre del curso no puede ser nulo o vacio";
    }
}
