<%--
  Created by IntelliJ IDEA.
  User: schna_000
  Date: 15.04.14
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Главная страница</title>

</head>
<body>
<security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
<a href="/employees/">Список сотрудников</a><br>
</security:authorize>
<a class="text-info" href="/career/?employees_code=<c:out value="${employeesview.employees.id}"/>">
<button style="width:100%" class="btn btn-warning" value=" Посмотреть историю карьеры    ">
    <span class="glyphicon glyphicon-signal"></span>
    Посмотреть историю карьеры
</button>
</a></br></br>

<a class="text-info" href="/mission/?employees_code=<c:out value="${employeesview.employees.id}" />">
<button style="width:100%" class="btn btn-warning" value=" Посмотреть список командировок">
    <span class="glyphicon glyphicon-road"></span>
    Посмотреть список командировок
</button>
</a><br/></br>

<a class="text-info" href="/statement/?employees_code=<c:out value="${employeesview.employees.id}" />">
<button style="width:100%" class="btn btn-warning" value=" Посмотреть список заявлений   ">
    <span class="glyphicon glyphicon-file"></span>
    Посмотреть список заявлений
</button>

</body>
</html>
