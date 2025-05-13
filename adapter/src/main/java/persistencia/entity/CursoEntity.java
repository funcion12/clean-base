package persistencia.entity;

import curso.modelo.Curso;
import curso.modelo.NIVELES_VALIDOS;
import java.time.LocalDate;
import java.util.UUID;
import jakarta.persistence.*;


@Entity (name= "curso")
public class CursoEntity {

    @Column(name="nombre")
    private String nombre;

    @Column(name="fecha_cierre_inscripcion")
    private LocalDate fechaCierreInscripcion;

    @Column(name="nivel")
    private NIVELES_VALIDOS nivel;

    @Id
    private UUID id;

    public CursoEntity() {}

    public CursoEntity(UUID id,String nombre, LocalDate fechaCierreInscripcion, NIVELES_VALIDOS nivel) {
        this.id = id;
        this.nombre = nombre;
        this.fechaCierreInscripcion = fechaCierreInscripcion;
        this.nivel = nivel;
    }

    public UUID getId() {return id;}
    public String getNombre() {return nombre;}
    public LocalDate getFechaCierreInscripcion() {return fechaCierreInscripcion;}
    public NIVELES_VALIDOS getNivel() {return nivel;}

    public static CursoEntity instancia(Curso curso) {
        return new CursoEntity(curso.getId(),curso.getNombre(),curso.getFechaCierreInscripcion(),curso.getNivel());
    }

}
