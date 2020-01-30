package modelo;


import java.awt.*;
import java.util.StringJoiner;

public class AlumnoModelo {

    private String nombre;
    private String apellido;
    private Integer id;

    public AlumnoModelo() {
        nombre = "Luis";
        apellido = "Hernandez";
        id = 0;
    }

    public AlumnoModelo(String nombre, String apellido, Integer id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", AlumnoModelo.class.getSimpleName() + "[", "]")
                .add("nombre='" + nombre + "'")
                .add("apellido='" + apellido + "'")
                .add("id=" + id)
                .toString();
    }
}
