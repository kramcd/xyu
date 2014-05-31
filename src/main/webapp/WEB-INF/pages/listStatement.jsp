<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заявления, сотрудник:<b> ${careerview.career.employees.name}
        ${careerview.career.employees.famaly} ${careerview.career.employees.middleName} </b></title>
</head>
<body>
<c:forEach items="${statements}" var="statement">
    <table class="table">
        <tr>
            <td>
                <c:out value="${statement.id}"/>
            </td>

            <td>
                <a href="/statement/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${statement.id}"/> ">
                    <c:out value="${statement.employees.name}"/>
                </a>
            </td>

            <td>
                <a href="/statement/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${statement.id}"/> ">
                    <c:out value="${statement.employees.famaly}"/>
                </a>
            </td>

            <td>
                <a href="/statement/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${statement.id}"/> ">
                    <c:out value="${statement.employees.middleName}"/>
                </a>
            </td>

            <td>
                <a href="/statement/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${statement.id}"/> ">
                    <c:out value="${statement.startDate}"/>
                </a>
            </td>

            <td>
                <a href="/statement/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${statement.id}"/> ">
                    <c:out value="${statement.applicationType}"/>
                </a>
            </td>

            <td>
                <a href="/statement/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${statement.id}"/> ">
                    <c:out value="${statement.applicationStatus}"/>
                </a>
            </td>

            <td>
                <a href="/statement/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${statement.id}"/> ">
                    <c:out value="${statement.endDate}"/>
                </a>
            </td>

        </tr>
    </table>

</c:forEach>
<a class="text-info" href="/statement/<%=request.getParameter("employees_code")%>/edit/">
    Составить заявление</a> <br/>
</body>
</html>
