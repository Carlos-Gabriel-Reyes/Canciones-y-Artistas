<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Detalle de canción</title>
        <!--puse aca los estilos por que en la hoja de estilos no me lo tomaba-->
        <style>
            body{font-family:Arial,Helvetica,sans-serif;margin:24px}
            .card{border:1px solid #ddd;border-radius:8px;padding:16px;max-width:600px}
            .muted{color:#666}
            a{display:inline-block;margin-top:16px}
        </style>
    </head>
    <body>
        <h2>Detalle</h2>

        <c:choose>
            <c:when test="${cancion != null}">
                <div class="card">
                    <p><strong>Titulo:</strong> <c:out value="${cancion.titulo}"/></p>
                    <p><strong>Artista:</strong> <c:out value="${cancion.artista.nombre}"/></p>
                    <p><strong>Album:</strong> <c:out value="${cancion.album}"/></p>
                    <p><strong>Genero:</strong> <c:out value="${cancion.genero}"/></p>
                    <p><strong>Idioma:</strong> <c:out value="${cancion.idioma}"/></p>
                    <p class="muted">
                        <strong>Creada:</strong> <c:out value="${cancion.fechaCreacion}"/> |
                        <strong>Actualizada:</strong> <c:out value="${cancion.fechaActualizacion}"/>
                    </p>
                </div>
            </c:when>
            <c:otherwise>
                <p class="muted">No se encontró la canción solicitada (id inválido).</p>
            </c:otherwise>
        </c:choose>

        <a href="${pageContext.request.contextPath}/canciones">Volver a lista de canciones</a>
        <p><a href="${pageContext.request.contextPath}/canciones/formulario/editar/${cancion.id}">Editar canción</a></p>
        <p><a href="${pageContext.request.contextPath}/canciones/eliminar/${cancion.id}">Eliminar canción</a></p>
    </body>
</html>


