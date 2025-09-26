<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head><meta charset="UTF-8"><title>Detalle Artista</title></head>
    <body>
        <h2>Detalle de Artista</h2>
        <p><b>Nombre:</b> ${artista.nombre}</p>
        <p><b>Apellido:</b> ${artista.apellido}</p>
        <p><b>Biografía:</b> ${artista.biografia}</p>
        <p><b>Fecha Creación:</b> ${artista.fechaCreacion}</p>
        <p><b>Fecha Actualización:</b> ${artista.fechaActualizacion}</p>

        <h3>Canciones</h3>
        <ul>
            <c:forEach var="c" items="${artista.canciones}">
                <li>${c.titulo}</li>
            </c:forEach>
        </ul>

        <a href="${pageContext.request.contextPath}/artistas">Volver a lista de artistas</a>
    </body>
</html>
