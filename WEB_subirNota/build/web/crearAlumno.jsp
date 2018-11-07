<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumno</title>
    </head>
    <body>
        <h1>Crear Alumno</h1>
        <form action="crearAlumno.do" method="post">
            <input type="text" name="nombreAlumno" placeholder="Ingrese nombre..." required>
            <input type="submit" value="Crear Alumno">
        </form>
        <br>
        <a href="Sesion.jsp">Volver</a>

    </body>
</html>
