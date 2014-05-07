<%--
  Created by IntelliJ IDEA.
  User: kramc_000
  Date: 18.04.14
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table>
    <tr>
        <c:forEach items="${persons}" var="person">
            <td><c:out value="${person.code}" /> </td>

            <td>
                <a href="/person/edit/?code=<c:out value="${person.code}"/>">
                <c:out value="${person.name}" />
                </a>
            </td>

            <td>
                <a <c:out value="${person.code}"/>">
                <c:out value="${person.age}" />
                </a>
            </td>

            <td>
                <a <c:out value="${person.code}"/>">
                <c:out value="${person.city}" />
                </a>
            </td>
        </c:forEach>
    </tr>
    <a href="/person/edit/">Add new person</a>
    <a href="/person/?adult=true">View adult persons</a>
</table>
</body>
</html>
