<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form:form commandName="careerview" action="save/">


    Должность <form:select path="career.post">
                <%--<jsp:useBean id="Post" scope="page" type="ru.tusur.domain.Post"/>--%>
                <c:forEach var="item" items="${ru.tusur.domain.Post}">
                    <form:option value="{item.text}"><spring:eval expression="item"/></form:option>
                </c:forEach>
                <form:options />
              </form:select> <br />

    Дата <form:input path="career.date"/> <br>

    Комментарий <form:textarea path="career.coment"/>

    <input type="submit" value="Go!">
   
</form:form>

</body>
</html>
