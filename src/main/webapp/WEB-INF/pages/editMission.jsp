<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="<c:url value="/resources/css/calendar.css" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery-1.7.2.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.ui.core.js" /> "></script>
    <script type="text/javascript" src="<c:url value="/resources/js/jquery.ui.datepicker.js"/>"></script>
    <script type="text/javascript">
        $(function () {
            var today = new Date();
            $('#dispatchDate').datepicker({defaultDate: today});
            $('#returnDate').datepicker({defaultDate: today});
        });
    </script>
    <title>Командировачный лист, сотрудник:<b> ${missionview.mission.employees.name}
        ${missionview.mission.employees.famaly} ${missionview.mission.employees.middleName} </b></title>
</head>
<body>
<h3>Редактирование данных</h3>
<form:form commandName="missionview" action="save/">
    <table class="TABLE">
        <tr>
            <td>Дата отправки</td>
            <td><form:input path="dispatchDate" id="dispatchDate" readonly="true"/></td>
        </tr>

        <tr>
            <td>Пункт назначения</td>
            <td><form:input path="mission.place"/></td>
        </tr>

        <tr>
            <td>Сумма командировачных</td>
            <td><form:input path="mission.money"/></td>
        </tr>

        <tr>
            <td>Дата прибытия</td>
            <td><form:input path="returnDate" id="returnDate" readonly="true"/></td>
        </tr>


    </table>
    <input class="btn-success" type="submit" value="Сохранить">
</form:form>

</body>
</html>
