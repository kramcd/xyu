<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Профессиональный рост, сотрудник:<b> ${careerview.career.employees.name}
        ${careerview.career.employees.famaly} ${careerview.career.employees.middleName} </b> </title>


</head>
<body>
<table>

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

        </c:forEach>
    </tr>

</table>

<a class="text-success" href="/career/<%=request.getParameter("employees_code")%>/edit/">
    <button class="btn btn-success"><span class="glyphicon glyphicon-plus"></span>
        <b>Повысить или понизить сотрудника в должности</b>
    </button></a>
</body>
</html>
