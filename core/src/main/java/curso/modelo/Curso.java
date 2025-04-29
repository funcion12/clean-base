package curso.modelo;

import java.time.LocalDate;
import java.util.UUID;
public class Curso {

    private String nombre;
    private final LocalDate fechaCierreInscripcion;
    private final NIVELES_VALIDOS nivel;
    private static UUID id;

    private Curso(UUID id,String nombre, LocalDate fechaCierreInscripcion, NIVELES_VALIDOS nivel) {
        this.id = id;
        this.nombre = nombre;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.nivel = nivel;
    }

    public static Curso instancia(UUID id, String nombre, LocalDate fecha_cierre_inscripcion, NIVELES_VALIDOS nivel) {

        return new Curso(id,nombre, fecha_cierre_inscripcion, nivel);
    }



    public UUID getId() {
        return id;
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
