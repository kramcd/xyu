<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>
        <ol class="breadcrumb">
            <li><a href="/employees/edit/?code=<%=request.getParameter("employees_code")%>">
                Сотрудник: ${missionview.famaly} ${missionview.name}
                 ${missionview.middleName}</a></li>
            <li><a href="/mission/<%=request.getParameter("employees_code")%>">Список коммандировок</a></li>

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
                <a href="/mission/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${mission.id}"/> ">
                        <c:out value="${mission.place}"/>
            </td>
            <td>
                <a href="/mission/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${mission.id}"/> ">
                        <c:out value="${mission.dispatchDate}"/>
            </td>
            <td>
                <a href="/mission/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${mission.id}"/> ">
                        <c:out value="${mission.returnDate}"/>
            </td>
            <td>
                <a href="/mission/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${mission.id}"/> ">
                        <c:out value="${mission.money}"/>
            </td>
            <td>
                <a class="text-success" href="/mission/<%=request.getParameter("employees_code")%>/delete/?code=<c:out value="${mission.id}"/>">
                    <button class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-minus"></span>  <b>Удалить  запись</b>
                    </button>
                </a>

            </td>
        </tr>
    </c:forEach>


</table>

<a class="text-success" href="/mission/<%=request.getParameter("employees_code")%>/edit/">
    <button class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>
        <b>Добавить запись</b>
    </button></a>
</body>
</html>
