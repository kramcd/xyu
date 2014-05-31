<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        <ol class="breadcrumb">
            <li><a href="/employees/edit/?code=<%=request.getParameter("employees_code")%>">
                Сотрудник: ${careerview.career.employees.name}
                ${careerview.career.employees.famaly} ${careerview.career.employees.middleName}</a></li>
            <li><a href="/career/<%=request.getParameter("employees_code")%>">Карьерный рост cписок записей</a></li>

        </ol>
    </title>


</head>
<body>
<table class="table">

    <tr>
        <td>Должность</td>
        <td>Дата</td>
        <td>Комментарий</td>
    </tr>

    <tr>
        <c:forEach items="${careers}" var="career">

            <td>
                <a href="/career/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${career.id}"/> ">
                        <c:out value="${career.post}"/>
            </td>
            <td>
                <a href="/career/<%=request.getParameter("employees_code")%>/edit/?code=<c:out value="${career.id}"/> ">
                        <c:out value="${career.date}"/>
            </td>
            <td>
                <a href="/career/edit/?code=<c:out value="${career.id}"/> ">
                        <c:out value="${career.coment}"/>
            </td>
            <td>
                <a class="text-success" href="/career/delete/?code=<c:out value="${employees.id}"/>">
                    <button class="btn btn-sm btn-danger"><span class="glyphicon glyphicon-minus"></span>  <b>Удалить  запись</b>
                    </button>
                </a>

            </td>

        </c:forEach>
    </tr>

</table>

<a class="text-success" href="/career/<%=request.getParameter("employees_code")%>/edit/">
    <button class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>
        <b>Добавить запись</b>
    </button></a>
</body>
</html>
