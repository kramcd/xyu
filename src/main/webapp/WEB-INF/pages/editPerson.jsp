<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: kramc_000
  Date: 18.04.14
  Time: 19:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <form:form commandName="personview" action="/person/save/" >
        <form:hidden path="persisted" />
        Code <form:input path="person.code" readonly="true"/> <br>
        Name <form:input path="person.name"/> <br>
        Age <form:input path="person.age"/><br>
        City <form:select path="person.city">
                <form:options items="${cityview.city}" itemValue="code" itemLabel="name" />
            </form:select> <br>
    </form:form>
</body>
</html>
