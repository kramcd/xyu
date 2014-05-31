<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/calendar.css" /> " />
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.7.2.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.ui.core.js" /> "></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.ui.datepicker.js"/>"></script>
    <script type="text/javascript">
        $(function () {
            var today = new Date();
            $('#date').datepicker({defaultDate: today});

        });
    </script>
    <title>Профессиональный рост, сотрудник:<b> ${careerview.career.employees.name}
        ${careerview.career.employees.famaly} ${careerview.career.employees.middleName} </b></title>
</head>
<body>
<h3>Редактирование данных</h3>
<form:form commandName="careerview" action="save/">

   Должность
            <form:select path="career.Post">
                <c:forEach var="item" items="${ru.tusur.domain.Post}">
                    <form:option value="{item.text}"><spring:eval expression="item"/></form:option>
                </c:forEach>
                <form:options/>
            </form:select>
       Дата<form:input readonly="true" path="date" id="date"/></td>
        Комментарий <form:textarea path="career.coment"/></td>

    <input class="btn-success" type="submit" value="Сохранить">

</form:form>

</body>
</html>