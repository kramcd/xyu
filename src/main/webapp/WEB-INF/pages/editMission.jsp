<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/resources/css/calendar.css" /> "/>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.7.2.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.ui.core.js" /> "></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.ui.datepicker.js"/>"></script>
    <script type="text/javascript">
        $(function () {
            var today = new Date();
            $('#dispatchDate').datepicker();
            $('#returnDate').datepicker();
        });
    </script>
    <title>
        <ol class="breadcrumb">
            <li><a href="/mission/?employees_code=${missionview.mission.employees.id}">Список командировок</a></li>
        <li><a href="/employees/edit/?code=${missionview.mission.employees.id}">Cотрудник: ${missionview.mission.employees.name}
            ${missionview.mission.employees.famaly} ${missionview.mission.employees.middleName}</a></li>
        <li><a href="#">Редактирование записи</a></li>


    </ol></title>
</head>
<body>
<div class="col-sm-8 blog-main">
<form:form commandName="missionview" action="save/">
    <form:input cssClass="form-control" placeholder="Место дислокации" path="mission.place"/></br>
    <div class="input-group"><span class="input-group-addon">Руб.</span>
    <form:input cssClass="form-control" placeholder="Сумма командировачных" path="mission.money"/></div></br>
    <form:input cssClass="form-control" placeholder="Дата отъезда" readonly="false" path="dispatchDate" id="dispatchDate"/></br>

    <form:input cssClass="form-control" placeholder="Дата возвращения" path="returnDate" id="returnDate" readonly="false"/></br>

    <button class="btn btn-default btn-info btn-lg" value="Сохранить" type="submit"><span
            class="glyphicon glyphicon-ok"></span>
        Сохранить
    </button>
</form:form>
</div>
</body>
</html>
