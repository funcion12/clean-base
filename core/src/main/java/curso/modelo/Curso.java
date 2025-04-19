package curso.modelo;

import java.time.LocalDate;

public class Curso {

    private String nombre;
    private final LocalDate fechaCierreInscripcion;
    private final NIVELES_VALIDOS nivel;

    private Curso(String nombre, LocalDate fechaCierreInscripcion, NIVELES_VALIDOS nivel) {
        this.nombre = nombre;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.nivel = nivel;
    }

    public static Curso instancia(int id, String nombre, LocalDate fecha_cierre_inscripcion, NIVELES_VALIDOS nivel) {
        return new Curso(nombre, fecha_cierre_inscripcion, nivel);
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaCierreInscripcion() {
        return fechaCierreInscripcion;
    }

    public NIVELES_VALIDOS getNivel() {
        return nivel;
    }
}
