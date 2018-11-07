package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Data {

    private final Conexion con;
    private ResultSet rs;

    public Data() throws SQLException, ClassNotFoundException {
        con = new Conexion(
                "localhost",
                "asd",
                "root",
                ""
        );
    }

    public void crearAlumno(Alumno a) throws SQLException {
        con.ejecutar("INSERT INTO alumnos VALUES(null, '" + a.getNombre() + "');");
    }

    public void crearDocente(Docente d) throws SQLException {
        con.ejecutar("INSERT INTO docentes VALUES(null, '" + d.getNombre() + "');");
    }

    public void crearCurso(Curso c) throws SQLException {
        con.ejecutar("INSERT INTO cursos VALUES(null, '" + c.getNombre() + "', " + c.getFk_Docente() + ", " + c.isAsignar() + ");");
    }

    public void crearAlumnoCurso(AlumnoCurso ac) throws SQLException {
        con.ejecutar("INSERT INTO alumnoCurso VALUES(null, " + ac.getFk_Alumno() + ", " + ac.getFk_curso() + ");");
    }

    //CONSULTAS
    public List<Docente> listarDocentes() throws SQLException {
        List<Docente> docente = new ArrayList<>();
        Docente doc = null;

        rs = con.ejecutarSelect("select * from docentes;");

        while (rs.next()) {
            doc = new Docente();

            doc.setId(rs.getInt(1));
            doc.setNombre(rs.getString(2));

            docente.add(doc);
        }
        con.close();
        return docente;
    }

    public List<Curso> listarCursos() throws SQLException {
        List<Curso> cursos = new ArrayList<>();
        Curso c = null;

        rs = con.ejecutarSelect("select * from cursos where asignar=true;");

        while (rs.next()) {
            c = new Curso();

            c.setId(rs.getInt(1));
            c.setNombre(rs.getString(2));

            cursos.add(c);
        }
        con.close();
        return cursos;
    }

    public List<Alumno> listarAlumnos() throws SQLException {
        List<Alumno> alum = new ArrayList<>();
        Alumno a = null;

        rs = con.ejecutarSelect("select * from alumnos;");

        while (rs.next()) {
            a = new Alumno();

            a.setId(rs.getInt(1));
            a.setNombre(rs.getString(2));

            alum.add(a);
        }
        con.close();
        return alum;
    }
    
    public void validarAsignacion(int id) throws SQLException{
        con.ejecutar("update cursos set cursos.asignar = false where id="+id);
    
    }

}
