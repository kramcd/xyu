<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>
        <ol class="breadcrumb">

            <li><a href="/mission/?employees_code=${missionview.id}">Командировки</a></li>
            <li>
                <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
            <a href="/employees/edit/?code=<%=request.getParameter("employees_code")%>">
                </security:authorize>
                Сотрудник: ${missionview.famaly} ${missionview.name}
                ${missionview.middleName}
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
        <th>Место назначени</th>
        <th>Дата отъезда</th>
        <th>Дата приезда</th>
        <th>Сумма денег в подотчет</th>
        <th>Действия</th>
    </tr>


    <c:forEach items="${missions}" var="mission">
        <tr>
            <td>
                <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
                <a href="/mission/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${mission.id}"/> ">
                    </security:authorize>
                        <c:out value="${mission.place}"/>
            </td>
            <td>
                <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
                <a href="/mission/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${mission.id}"/> ">
                    </security:authorize>
                        <c:out value="${mission.dispatchDate}"/>
            </td>
            <td>
                <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
                <a href="/mission/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${mission.id}"/> ">
                    </security:authorize>
                        <c:out value="${mission.returnDate}"/>
            </td>
            <td>
                <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
                <a href="/mission/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${mission.id}"/> ">
                    </security:authorize>
                        <c:out value="${mission.money}"/>
            </td>
            <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
                <td>

                    <a class="text-success"
                       href="/mission/<%=request.getParameter("employees_code")%>/delete/?code=<c:out value="${mission.id}"/>">
                        <button class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-minus"></span> <b>Удалить
                            запись</b>
                        </button>
                    </a>

                </td>
            </security:authorize>

        </tr>
    </c:forEach>


</table>
<security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
    <a class="text-success" href="/mission/<%=request.getParameter("employees_code")%>/edit/">
        <button class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>
            <b>Добавить запись</b>
        </button>
    </a>
</security:authorize>
</body>
</html>
