<%@page import="model.Alumno"%>
<%@page import="model.Curso"%>
<%@page import="model.Data"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asignar</title>
    </head>
    <body>
        <h1>Asignar alumnos a cursos</h1>
        <form action="crearAlumnoCurso.do" method="post">
            <select name="cmbCursos">
                <%
                    Data d = new Data();
                    for (Curso c : d.listarCursos()) {
                %>
                <option value="<%=c.getId()%>" ><%=c.getNombre()%>  </option>
                <%
                    }
                %>
            </select>
            <br><br>
            <table >
                <th>ID</th>
                <th>Nombre</th>
                <th>Asignar<th>

                    <%
                        for (Alumno al : d.listarAlumnos()) {
                    %>
                <tr>
                    <td><%=al.getId()%></td>
                    <td><%=al.getNombre()%></td>
                    <td><input type="checkbox" name="check" value="<%=al.getId()%>"/></td>
                </tr>

                <%
                    }
                %>
            </table>
            <input type="submit" value="Asignar">
        </form>
            <br>
            <a href="Sesion.jsp">Volver</a>
    </body>
</html>
