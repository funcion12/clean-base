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

        if (id == null) throw new IllegalArgumentException("id no puede ser nulo");

        if(nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("El nombre es obligatorio");

        if(fecha_cierre_inscripcion == null) throw new IllegalArgumentException("La fecha de cierre de inscripcion es obligatoria");

        if(fecha_cierre_inscripcion.isBefore(LocalDate.now())) throw new IllegalArgumentException("La fecha de cierre de inscripcion no puede ser anterior a la fecha actual");

        if(nivel == null) throw new IllegalArgumentException("El nivel del curso es obligatorio");

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
