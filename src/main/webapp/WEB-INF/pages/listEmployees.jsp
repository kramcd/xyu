<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>
        <ol class="breadcrumb">
            <li><a href="#">Список сотрудников</a></li>

        </ol>
    </title>
</head>
<body>
<table class="table">
    <tr>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Отчество</th>
        <th>Должность</th>
        <th>Действие</th>
    </tr>
    <tr>
        <c:forEach items="${employeeses}" var="employees">
        <td>
            <a href="/employees/edit/?code=<c:out value="${employees.id}"/>">
                    <c:out value="${employees.famaly}"/>
        </td>

        <td>
            <a href="/employees/edit/?code=<c:out value="${employees.id}"/>">
                    <c:out value="${employees.name}"/>
        </td>


        <td>
            <a href="/employees/edit/?code=<c:out value="${employees.id}"/>">
                    <c:out value="${employees.middleName}"/>
        </td>

        <td>
            <a href="/employees/edit/?code=<c:out value="${employees.id}"/>">
                    <c:out value="${employees.post}"/>
        </td>

        <td>
            <a class="text-success" href="/employees/delete/?code=<c:out value="${employees.id}"/>">
                <button class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-minus"></span>  <b>Удалить  сотрудника</b>
                </button>
            </a>

        </td>


    </tr>
    </c:forEach>

</table>
<a class="text-success" href="/employees/edit/">
    <button class="btn btn-success"><span class="glyphicon glyphicon-plus"></span> <b>Добавить нового сотрудника</b>
    </button>
</a>
</body>
</html>
