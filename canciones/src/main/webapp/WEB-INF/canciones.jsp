<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" href="css/styles.css">
    <title>Lista de canciones</title>
</head>
<body>
    <h2>Canciones</h2>
    <table>
        <thead>
            <tr>
                <th>Título</th>
                <th>Autor</th>
                <th>Detalles</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="c" items="${canciones}">
                <tr>
                    <td><c:out value="${c.titulo}"/></td>
                    <td><c:out value="${c.artista.nombre}"/></td>
                    <td><a href="${pageContext.request.contextPath}/canciones/detalle/${c.id}">Detalles</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
        <a href="${pageContext.request.contextPath}/canciones/formulario/agregar">Agregar nueva canción</a>
        <a>\</a> <!-- Separador -->
        <a href="${pageContext.request.contextPath}/artistas">artistas</a>

</body>
</html>
