<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Docente</title>
    </head>
    <body>
        <h1>Crear Docente</h1>
        <form action="crearDocente.do" method="post">
            <input type="text" name="nombreDocente" placeholder="Ingrese nombre..." required>
            <input type="submit" value="Crear Docente">
        </form>
        <br>
        <a href="Sesion.jsp">Volver</a>
    </body>
</html>
