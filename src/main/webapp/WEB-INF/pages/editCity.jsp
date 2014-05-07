<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>

    <form:form commandName="cityview" action="/city/save/">

        <form:hidden path="persisted" />

        Code <form:input path="city.code" readonly="true"/> <br />
        Name <form:input path="city.name" /> <br />

        <input type="submit" value="Go!">

    </form:form>

</body>
</html>
