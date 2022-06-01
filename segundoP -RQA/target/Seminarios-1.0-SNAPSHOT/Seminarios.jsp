
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">

        <title>Seminarios disponibles</title>
    </head>
    <body>

        <jsp:include page="META-INF/menu.jsp">
            <jsp:param name="opcion" value="seminarios"/>
        </jsp:include> 
        <div align="center">
            <table width="280" cellspacing="1" cellpadding="3" border ="1">
                <tr>
                <td><font  face="arial,verdana,helvetica">
                    SEGUNDO PARCIAL TEM-742<br>
                    Nombre: RUBEN QUISPE ALEJO<br>
                Carnet: 8344097
                </font>
                </td>
                </tr>
            </table>
        </div>

        <div class="container" >
            <h1>SEMINARIOS</h1>
            <br>
            <a href="SeminariosControlador?action=add" class="btn btn-primary btn-sm"><i class="fa-solid fa-circle-plus"></i> Nuevo</a>
            <br><br>
            <table class="table table-striped">
                <tr>
                    <th>Id</th>
                    <th>Titulo</th>
                    <th>Fecha</th>
                    <th>Cupo</th>
                    <th>Editar</th>
                    <th>Eliminar</th>
                </tr>
                <c:forEach var="item" items="${seminarios}">
                    <tr>
                        <td>${item.id}</td>
                        <td>${item.titulo}</td>
                        <td>${item.fecha}</td>
                        <td>${item.cupo}</td>
                        <td><a href="SeminariosControlador?action=edit&id=${item.id}"><i class="fa-solid fa-pen-to-square"></i></a></td>
                        <td><a href="SeminariosControlador?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro??'))"><i class="fa-solid fa-trash"></i></a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>