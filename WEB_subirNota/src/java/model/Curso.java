package model;

public class Curso {

    private int id;
    private String nombre;
    private int fk_Docente;
    private boolean Asignar;
    
    public Curso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFk_Docente() {
        return fk_Docente;
    }

    public void setFk_Docente(int fk_Docente) {
        this.fk_Docente = fk_Docente;
    }

    public boolean isAsignar() {
        return Asignar;
    }

    public void setAsignar(boolean Asignar) {
        this.Asignar = Asignar;
    }

}
