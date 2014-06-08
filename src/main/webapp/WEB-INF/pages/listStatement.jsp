<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>
        <ol class="breadcrumb">
            <li><a href="/statement/?employees_code=${statementview.id}">Заявления</a></li>
            <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
            <li><a href="/employees/edit/?code=<%=request.getParameter("employees_code")%>">
                </security:authorize>
                Сотрудник:  ${statementview.famaly} ${statementview.name}
                ${statementview.middleName}
                    <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
            </a>
                </security:authorize>
            </li>
            <li>
                <a href="#">Список записей</a>
                </li>

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
            <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
            <a href="/statement/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${statement.id}"/> ">
            </security:authorize>
            <c:out value="${statement.dpDate}"/>
            </a>
        </td>


        <td>
            <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
            <a href="/statement/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${statement.id}"/> ">
            </security:authorize>
            <c:out value="${statement.startDate}"/>
            </a>
        </td>
        <td>
            <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
            <a href="/statement/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${statement.id}"/> ">
            </security:authorize>
            <c:out value="${statement.endDate}"/>
            </a>
        </td>
        <td>
            <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
            <a href="/statement/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${statement.id}"/> ">
            </security:authorize>
            <c:out value="${statement.applicationType}"/>
            </a>
        </td>

        <td>
            <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
            <a href="/statement/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${statement.id}"/> ">
            </security:authorize>
            <c:out value="${statement.applicationStatus}"/>
            </a>
        </td>
            <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
            <td>

                <a class="text-success" href="/statement/<%=request.getParameter("employees_code")%>/delete/?code=<c:out value="${statement.id}"/>">
                    <button class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-minus"></span>  <b>Удалить  запись</b>
                    </button>
                </a>

            </td>
            </security:authorize>
        </tr>
        </c:forEach>
    </table>
    <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
    <a class="text-success" href="/statement/<%=request.getParameter("employees_code")%>/edit/">
        <button class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>
            <b>Добавить запись</b>
        </button>
    </a>
    </security:authorize>


</body>
</html>
