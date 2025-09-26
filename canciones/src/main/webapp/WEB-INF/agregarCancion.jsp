<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head><title>Agregar Canción</title></head>
<body>
    <h2>Agregar Cancion</h2>
    <form:form method="post" modelAttribute="cancion" action="${pageContext.request.contextPath}/canciones/procesa/agregar">
        Titulo: <form:input path="titulo"/> <form:errors path="titulo"/><br/>
        <label>Artista:</label>
        <form:select path="artista.id" items="${artistas}" itemValue="id" itemLabel="nombre" required="true">
        <form:option value="" label="Selecciona un artista"/>
        </form:select>
        <form:errors path="artista" cssClass="error"/>
        <br/>
        Album: <form:input path="album"/> <form:errors path="album"/><br/>
        Genero: <form:input path="genero"/> <form:errors path="genero"/><br/>
        Idioma: <form:input path="idioma"/> <form:errors path="idioma"/><br/>

        <input type="submit" value="Guardar"/>
    </form:form>

    <a href="${pageContext.request.contextPath}/canciones">Volver a lista de canciones</a>
</body>
</html>
