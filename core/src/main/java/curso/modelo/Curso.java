package curso.modelo;

public class Curso {


    private String nombre;
    private final String fechaCierreInscripcion;
    private final String nivel;

    private Curso(String nombre, String fechaCierreInscripcion, String nivel) {
        this.nombre = nombre;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.nivel = nivel;
    }


    public static Curso instancia(int id, String nombre, String fecha_cierre_inscripcion, String nivel) {
        return new Curso(nombre,fecha_cierre_inscripcion,nivel);
    }

    public String getNombre(){
        return nombre;
    }


}
