<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head><meta charset="UTF-8"><title>Lista de artistas</title></head>
    <body>
        <h2>Artistas</h2>
        <ul>
            <c:forEach var="a" items="${artistas}">
                <li>
                    <a href="${pageContext.request.contextPath}/artistas/detalle/${a.id}">
                        ${a.nombre} ${a.apellido}
                    </a>
                </li>
            </c:forEach>
        </ul>
        <a href="${pageContext.request.contextPath}/artistas/formulario/agregar">Agregar Artista</a>
        <a>\</a>  <!--esta linea es solo para separacion y que quede hacia la derecha y no hacia abajo-->
        <a href="${pageContext.request.contextPath}/canciones">canciones</a>
    </body>
</html>
