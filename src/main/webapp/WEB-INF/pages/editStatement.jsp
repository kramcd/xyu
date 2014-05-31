<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Заявления, сотрудник:<b> ${statementnview.statement.employees.name}
        ${statementnview.statement.employees.famaly} ${statementnview.statement.employees.middleName} </b></title>
</head>
<body>
<h3>Редактирование данных</h3>
<form:form commandName="statementview" action="save/">

    <table>
        <tr>
            <td>
                Тип заявления
            </td>
            <td><form:select path="statement.applicationType">
                <c:forEach var="item" items="${ru.tusur.domain.applicationType}">
                    <form:option value="{item.text}"><spring:eval expression="item"/></form:option>
                </c:forEach>
                <form:options/>
            </form:select>
            </td>
        </tr>

        <tr>
            <td>Статус заявки</td>
            <td><form:select path="statement.applicationStatus">
                <c:forEach var="item" items="${ru.tusur.domain.applicationStatus}">
                    <form:option value="{item.text}"><spring:eval expression="item"/></form:option>
                </c:forEach>
                <form:options/>
            </form:select></td>
        </tr>

        <tr>
            <td>Дата начала</td>
            <td><form:input path="statement.startDate"/></td>
        </tr>

        <tr>
            <td>Дата окончания</td>
            <td><form:input path="statement.endDate"/></td>
        </tr>

    </table>
        <input class="btn-success" type="submit" value="Сохранить">

</form:form>
</body>
</html>
