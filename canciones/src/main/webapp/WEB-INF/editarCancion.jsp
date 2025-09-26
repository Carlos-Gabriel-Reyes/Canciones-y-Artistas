<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Editar canción</title>
    </head>
    <body>
        <h2>Editar canción</h2>
        <form:form modelAttribute="cancion" method="post" action="${pageContext.request.contextPath}/canciones/procesa/editar/${cancion.id}">
            <table>
                <tr>
                    <td>Título</td>
                    <td>
                        <form:input path="titulo"/>
                        <form:errors path="titulo" cssClass="error"/>
                    </td>
                </tr>
                <tr> 
                    <td>Artista</td>
                        <td> 
                            <form:select path="artista.id"> <!-- para que salga la lista de artistas y sea con select-->
                                <form:options items="${artistas}" itemValue="id" itemLabel="nombre"/>
                            </form:select>
                            <form:errors path="artista" cssClass="error"/>
                        </td>          
                </tr>
                <tr>
                    <td>Álbum</td>
                    <td>
                        <form:input path="album"/>
                        <form:errors path="album" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td>Género</td>
                    <td>
                        <form:input path="genero"/>
                        <form:errors path="genero" cssClass="error"/>
                    </td>
                </tr>
                <tr>
                    <td>Idioma</td>
                    <td>
                        <form:input path="idioma"/>
                        <form:errors path="idioma" cssClass="error"/>
                    </td>
                </tr>
            </table>

            <button type="submit">Actualizar</button>
        </form:form>

        <p><a href="${pageContext.request.contextPath}/canciones">Volver a lista de canciones</a></p>
    </body>
</html>
