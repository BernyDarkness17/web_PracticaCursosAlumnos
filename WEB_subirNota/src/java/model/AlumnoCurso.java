package model;

public class AlumnoCurso {
    private int id;
    private int fk_Alumno;
    private int fk_curso;
    
    public AlumnoCurso(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_Alumno() {
        return fk_Alumno;
    }

    public void setFk_Alumno(int fk_Alumno) {
        this.fk_Alumno = fk_Alumno;
    }

    public int getFk_curso() {
        return fk_curso;
    }

    public void setFk_curso(int fk_curso) {
        this.fk_curso = fk_curso;
    }
    
    
}
