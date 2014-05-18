<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Список сотрудников</title>
</head>
<body>
    <table>
        <tr>
            <c:forEach items="${employeeses}" var="employees">
                <td>
                <c:forEach items="${employees.id}"/>
                </td>

                <td>
                <a href="/employees/edit/?code=<c:out value="${employees.id}"/>">
                <c:out value="${employees.name}"/>
                </td>

                <td>
                <a href="/employees/edit/?code=<c:out value="${employees.id}"/>">
                <c:out value="${employees.famaly}"/>
                </td>

                <td>
                <a href="/employees/edit/?code=<c:out value="${employees.id}"/>">
                <c:out value="${employees.middleName}"/>
                </td>

                <td>
                <a href="/employees/edit/?code=<c:out value="${employees.id}"/>">
                <c:out value="${employees.post}"/>
                </td>
                </c:forEach>
        </tr>
                <a href="/employees/edit/">Добавить нового сотрудника</a>
    </table>
</body>
</html>
