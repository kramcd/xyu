<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cities list</title>
</head>
<body>
    <table>
            <tr>
                <c:forEach items="${cities}" var="city">
                <td><c:out value="${city.code}" /> </td>
                <td>
                    <a href="/city/edit/?code=<c:out value="${city.code}"/>">
                        <c:out value="${city.name}" />
                    </a>
                </td>
                </c:forEach>
            </tr>
            <a href="/city/edit/">Add new city</a>
    </table>
</body>
</html>
