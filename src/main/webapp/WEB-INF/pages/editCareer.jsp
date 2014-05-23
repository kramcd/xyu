<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form commandName="careerview" action="/career/save/">
    Сотрудник <form:select path="career.employees">
                <jsp:useBean id="Employees" scope="request" type="ru.tusur.domain.Employees"/>
                <c:forEach var="item" items="${Employees}">
                    <form:option value="{item.text}"><spring:eval expression="item"/></form:option>
                </c:forEach>
                <form:options />
              </form:select> <br>

    Должность <form:select path="career.post">
                <jsp:useBean id="Post" scope="request" type="ru.tusur.domain.Post"/>
                <c:forEach var="item" items="${Post}">
                    <form:option value="{item.text}"><spring:eval expression="item"/></form:option>
                </c:forEach>
                <form:options />
              </form:select> <br>

    Дата <form:input path="career.date"/> <br>

    Комментарий <form:textarea path="career.comment"/>
   
   
</form:form>

</body>
</html>
