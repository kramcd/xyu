<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><ol class="breadcrumb">
        <li><a href="">Главная страница</a></li>
    </ol></title>

</head>
<body>




<div  style="margin:0 auto;">
    <security:authorize access="isAuthenticated() and hasRole('ROLE_ADMIN')">
        <a class="text-info" href="/employees/">
            <button style="width:100%" class="btn btn-warning" value=" Список сотрудников">
                <span class="glyphicon glyphicon-user"></span>
                Список сотрудников
            </button>
        </a><br/></br>
    </security:authorize>
    <a class="text-info" href="" >
        <button style="width:100%" class="btn btn-warning" value=" Посмотреть историю карьеры    ">
            <span class="glyphicon glyphicon-signal"></span>
            Посмотреть историю карьеры
        </button>
    </a></br></br>

    <a class="text-info" href="/mission/?employees_code=<c:out value="${view.id}" />">
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
    </a><br/></br>
</div>
</body>
</html>
