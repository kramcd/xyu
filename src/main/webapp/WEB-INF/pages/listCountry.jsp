<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Countries List</title>
</head>
<body>
    <table>
        <tr>

            <c:forEach items="${countries}" var="country">

            <td>
                <c:forEach items="${country.code}"/>
            </td>

            <td>
                <a href="/country/edit/?code=<c:out value="${country.code}"/>">
                    <c:out value="${country.name}"/>
                </a>
            </td>
            </c:forEach>

        </tr>

        <a href="/country/edit/">Add new Country</a>
    </table>
</body>
</html>
