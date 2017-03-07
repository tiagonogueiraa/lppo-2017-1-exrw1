<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listagem de Registros</title>
    </head>
    <body>
        <h1>Listagem de Registros</h1>
        <ol>
            <c:forEach var="pessoa" items="${pessoas}">
                <li>${pessoa}</li>
            </c:forEach>
        </ol>
    </body>
</html>
