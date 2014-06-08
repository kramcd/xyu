<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>  <ol class="breadcrumb">
        <li><a href="/statement/?employees_code=${statementview.statement.employees.id}">Заявления</a></li>
        <li><a href="/employees/edit/?code=${statementnview.statement.employees.id}">Cотрудник: ${statementnview.statement.employees.name}
            ${statementnview.statement.employees.famaly} ${statementnview.statement.employees.middleName}</a></li>
        <li><a href="#">Редактирование записи</a></li>


    </ol></title>
    <link rel="stylesheet" href="<c:url value="/resources/css/calendar.css" /> "/>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.7.2.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.ui.core.js" /> "></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.ui.datepicker.js"/>"></script>
    <script type="text/javascript">
        $(function () {
            var today = new Date();
            $('#dpDate').datepicker();
            $('#startDate').datepicker();
            $('#endDate').datepicker();
        });
    </script>
</head>
<body>
<div class="col-sm-8 blog-main">
<form:form commandName="statementview" action="save/">

    <form:select cssClass="form-control" placeholder="Тип заявки" path="statement.applicationType">
                <c:forEach var="item" items="${ru.tusur.domain.applicationType}">
                    <form:option value="{item.text}"><spring:eval expression="item"/></form:option>
                </c:forEach>
                <form:options/>
            </form:select> </br>
           <form:select cssClass="form-control" placeholder="Статус заявки" path="statement.applicationStatus">
                <c:forEach var="item" items="${ru.tusur.domain.applicationStatus}">
                    <form:option value="{item.text}"><spring:eval expression="item"/></form:option>
                </c:forEach>
                <form:options/>
            </form:select></br>

    <form:input cssClass="form-control" placeholder="Дата с" path="startDate" id="startDate"/></br>
    <form:input cssClass="form-control" placeholder="Дата по" path="endDate" id="endDate"/></br>
    <form:input cssClass="form-control" placeholder="Дата подачи заявления" path="dpDate" id="dpDate"/></br>

    <button class="btn btn-default btn-info btn-lg" value="Сохранить" type="submit"><span
            class="glyphicon glyphicon-ok"></span>
        Сохранить
    </button>

</form:form>
    </div>
</body>
</html>
