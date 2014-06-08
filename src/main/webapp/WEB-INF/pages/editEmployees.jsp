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
            $('#bithDay').datepicker();
            $('#employeementDate').datepicker();
        });
    </script>
    <title>
        <ol class="breadcrumb">
            <li><a href="/employees/">Список сотрудников</a></li>
            <li><a href="#">Добавление или изменение данных о сотрудниках</a></li>


        </ol>
    </title>
</head>
<body>
<div class="col-sm-8 blog-main">
    <form:form commandName="employeesview" action="/employees/save/">
        <form:input placeholder="Фамилия" cssClass="form-control" path="employees.famaly"/> </br>
        <form:input placeholder="Имя" cssClass="form-control" path="employees.name"/> </br>
        <form:input placeholder="Отчество" cssClass="form-control" path="employees.middleName"/> </br>

        <form:select placeholder="Пол" cssClass="form-control" path="employees.gender"> </br>
            <c:forEach var="item" items="${ru.tusur.domain.Gender}">
                <form:option value="{item.text}"><spring:eval expression="item"/></form:option>
            </c:forEach>
            <form:options/>
        </form:select></br>

        <form:select placeholder="Должность" cssClass="form-control" path="employees.post"> </br>
            <c:forEach var="item" items="${ru.tusur.domain.Post}">
                <form:option value="{item.text}"><spring:eval expression="item"/></form:option>
            </c:forEach>
            <form:options/>
        </form:select></br>

        <form:hidden path="employees.id"/>
        <form:input placeholder="Паспорт(серсия, номер)" cssClass="form-control" path="employees.pasport"/>
        </br>

        <form:input placeholder="Номер ПФР " cssClass="form-control" path="employees.numberPFR"/>
        </br>

        <div class="input-group"><span class="input-group-addon">+7</span>
            <form:input placeholder="Номер телефона" cssClass="form-control" path="employees.numberTel"/></div>
        </br>

        <form:input placeholder="Домашний адрес" cssClass="form-control" path="employees.address"/>
        </br>

        <div class="input-group"><span class="input-group-addon">@</span>
            <form:input placeholder="Адрес электронной почты" cssClass="form-control" path="employees.email"/></div>
        </br>

        <form:input placeholder="Пароль" cssClass="form-control" path="employees.password"/> </br>

        <form:select placeholder="Роль" cssClass="form-control" path="employees.role"> </br>
            <c:forEach var="item" items="${ru.tusur.domain.Role}">
                <form:option value="{item.text}"><spring:eval expression="item"/></form:option>
            </c:forEach>
            <form:options/>
        </form:select></br>

        <form:input readonly="false" placeholder="День рождения" cssClass="form-control" path="bithDay"
                    id="bithDay"/> </br>

        <form:input readonly="false" placeholder="Дата приема на работу" cssClass="form-control" path="employeementDate"
                    id="employeementDate"/> </br>

        <button class="btn btn-default btn-info btn-lg" value="Сохранить" type="submit"><span
                class="glyphicon glyphicon-ok"></span>
            Сохранить
        </button>


        <br> <br>


    </form:form>
</div>
<div class="col-sm-3 col-sm-offset-1 blog-sidebar">
    <div style="width:100%">
        <h4 style="text-align: center">Действия</h4>
        </br>
        <a class="text-info" href="/career/?employees_code=<c:out value="${employeesview.employees.id}"/>">
            <button style="width:100%" class="btn btn-warning" value=" Посмотреть историю карьеры    ">
                <span class="glyphicon glyphicon-signal"></span>
                Посмотреть историю карьеры
            </button>
        </a></br></br>

        <a class="text-info" href="/mission/?employees_code=<c:out value="${employeesview.employees.id}" />">
            <button style="width:100%" class="btn btn-warning" value=" Посмотреть список командировок">
                <span class="glyphicon glyphicon-road"></span>
                Посмотреть список командировок
            </button>
        </a><br/></br>

        <a class="text-info" href="/statement/?employees_code=<c:out value="${employeesview.employees.id}" />">
            <button style="width:100%" class="btn btn-warning" value=" Посмотреть список заявлений   ">
                <span class="glyphicon glyphicon-file"></span>
                Посмотреть список заявлений
            </button>
        </a><br/></br>
    </div>
</div>

</body>
</html>
