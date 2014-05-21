<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form:form commandName="employeesview" action="/employees/save/">
        № <form:input path="employees.id" readonly="true"/><br>
        Имя <form:input path="employees.name"/><br>
        Отчество <form:input path="employees.middleName"/><br>
        Фамилия <form:input path="employees.famaly"/><br>
        Должность <form:select path="employees.post">
                    <jsp:useBean id="Post" scope="request" type="ru.tusur.domain.Post"/>
                    <c:forEach var="item" items="${Post}">
                        <form:option value="{item.text}"><spring:eval expression="item"/></form:option>
                    </c:forEach>
                        <form:options />
                  </form:select>
        Возраст <form:input path="employees.age"/><br>
        Паспорт(серия, номер) <form:input path="employees.pasport"/><br>
        Номер телефона <form:input path="employees.numberTel"/><br>
        Домашний адрес <form:input path="employees.address"/><br>
        Адрес электронной почты <form:input path="employees.email"/><br>
        Логин <form:input path="employees.login"/><br>
        Пароль <form:input  path="employees.password"/><br>
        <input type="submit" value="Go!">
    </form:form>

</body>
</html>
