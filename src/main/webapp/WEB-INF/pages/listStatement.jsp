<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>
        <ol class="breadcrumb">
            <li><a href="/employees/edit/?code=<%=request.getParameter("employees_code")%>">
                Сотрудник:  ${statementview.famaly} ${statementview.name}
                ${statementview.middleName}</a></li>
            <li><a href="/statement/<%=request.getParameter("employees_code")%>">Список заявлений</a></li>

        </ol>
    </title>
</head>
<body>

    <table class="table">
        <tr>
            <th>Дата составления</th>
            <th>С(дата)</th>
            <th>По(дата)</th>
            <th>Тип</th>
            <th>Стутас</th>
            <th>Действия</th>
        </tr>
        <c:forEach items="${statements}" var="statement">
        <tr>
        <td>
            <a href="/statement/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${statement.id}"/> ">
                <c:out value="${statement.dpDate}"/>
            </a>
        </td>


        <td>
            <a href="/statement/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${statement.id}"/> ">
                <c:out value="${statement.startDate}"/>
            </a>
        </td>
        <td>
            <a href="/statement/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${statement.id}"/> ">
                <c:out value="${statement.endDate}"/>
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
                <a class="text-success" href="/statement/<%=request.getParameter("employees_code")%>/delete/?code=<c:out value="${statement.id}"/>">
                    <button class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-minus"></span>  <b>Удалить  запись</b>
                    </button>
                </a>

            </td>

        </tr>
        </c:forEach>
    </table>

    <a class="text-success" href="/statement/<%=request.getParameter("employees_code")%>/edit/">
        <button class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>
            <b>Добавить запись</b>
        </button>
    </a>



</body>
</html>
