<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
    <head><title>Agregar Artista</title></head>
    <body>
        <h2>Agregar Artista</h2>
        <form:form method="post" modelAttribute="artista" action="${pageContext.request.contextPath}/artistas/procesa/agregar">
            Nombre: <form:input path="nombre"/> <form:errors path="nombre"/><br/>
            Apellido: <form:input path="apellido"/> <form:errors path="apellido"/><br/>
            Biografía: <form:textarea path="biografia"/><form:errors path="biografia"/><br/>
            <input type="submit" value="Guardar"/>
        </form:form>
        <a href="${pageContext.request.contextPath}/artistas">Volver</a>
    </body>
</html>
