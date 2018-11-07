package model;

import java.sql.*;

public class Conexion {

    private Connection con;
    private Statement sen;
    private ResultSet rs;

    public Conexion(String server, String bd, String user, String pass) throws SQLException, ClassNotFoundException {
        String protocolo = "jdbc:mysql://";
        String lineaUser = "user=" + user;
        String lineaPass = "password=" + pass;

        String url = protocolo
                + server + "/"
                + bd + "?"
                + lineaUser + "&"
                + lineaPass;

        System.out.println(url);

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url);
    }

    public void ejecutar(String query) throws SQLException {
        System.out.println(query);
        sen = con.createStatement();
        sen.executeUpdate(query);
        close();
    }

    // select
    public ResultSet ejecutarSelect(String query) throws SQLException {
        System.out.println(query);
        sen = con.createStatement();
        rs = sen.executeQuery(query);
        return rs;
    }

    public void close() throws SQLException {
        sen.close();
    }
}
