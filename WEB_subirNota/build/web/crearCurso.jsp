<%@page import="model.Docente"%>
<%@page import="model.Data"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Curso</title>
    </head>
    <body>
        <h1>Crear Curso</h1>
        <form action="crearCurso.do" method="post">
            <input type="text" name="nombreCurso" placeholder="Ingrese nombre..." required>
            
            <select name="cmbDocente">
                <%
                Data d = new Data();
                for(Docente doc : d.listarDocentes()){
                %>
                <option value="<%=doc.getId()%>" ><%=doc.getNombre() %>  </option>

                <%               
                }
                %>
            </select>

            <input type="submit" value="Crear Curso">
        </form>
           <br>
        <a href="Sesion.jsp">Volver</a>
    </body>
</html>
