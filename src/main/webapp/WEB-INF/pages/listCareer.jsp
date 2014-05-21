<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Профессиональный рост </title>
</head>
<body>
    <table>
        <tr>
            <c:forEach items="${careers}" var="career">
                <td>
                <c:out value="${career.id}"/>
                </td>

            <td>
                <a href="/career/edit/?code=<c:out value="${career.id}"/> ">
                        <c:out value="${career.employees}"/>
            </td>
            <td>
                <a href="/career/edit/?code=<c:out value="${career.id}"/> ">
                    <c:out value="${career.post}"/>
            </td>
            <td>
                <a href="/career/edit/?code=<c:out value="${career.id}"/> ">
                    <c:out value="${career.date}"/>
            </td>
            <td>
                <a href="/career/edit/?code=<c:out value="${career.id}"/> ">
                    <c:out value="${career.comment}"/>
            </td>

            </c:forEach>
        </tr>
            <a href="/career/edit/">Повысить или понизить сотрудника в должности</a>
        </table>
</body>
</html>
