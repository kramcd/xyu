<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <ol class="breadcrumb">

            <li><a href="/career/?employees_code=${careerview.id}">Карьерный рост</a></li>
            <li>
                <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
                <a href="/employees/edit/?code=${careerview.id}">
                    </security:authorize>
                    Сотрудник: ${careerview.famaly} ${careerview.name}
                    ${careerview.middleName}
                    <security:authorize
                            access="isAuthenticated() and hasRole('ROLE_ADMIN')">    </a> </security:authorize>
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
        <th>Должность</th>
        <th>Дата</th>
        <th>Комментарий</th>
        <th>Действие</th>
    </tr>


    <c:forEach items="${careers}" var="career">
        <tr>
            <td>
                <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
                <a href="/career/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${career.id}"/> ">
                    </security:authorize>
                        <c:out value="${career.post}"/>
            </td>
            <td>
                <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
                <a href="/career/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${career.id}"/> ">
                    </security:authorize>
                        <c:out value="${career.dDate}"/>
            </td>
            <td>
                <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')"> <a
                    href="/career/edit/?code=<c:out value="${career.id}"/> ">
                </security:authorize>
                    <c:out value="${career.coment}"/>
            </td>
            <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
                <td>
                    <a class="text-success"
                       href="/career/<%=request.getParameter("employees_code")%>/delete/?code=<c:out value="${career.id}"/>">
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
    <a class="text-success" href="/career/<%=request.getParameter("employees_code")%>/edit/">
        <button class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>
            <b>Добавить запись</b>
        </button>
    </a>
</security:authorize>
</body>
</html>
