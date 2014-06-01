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
            $('#dDate').datepicker();

        });
    </script>
    <title>
        <ol class="breadcrumb">
            <li><a href="/employees/edit/?code=<%=request.getParameter("employees_code")%>">
                Сотрудник: ${careerview.career.employees.name}
                ${careerview.career.employees.famaly} ${careerview.career.employees.middleName}</a></li>
            <li><a href="/career/<%=request.getParameter("employees_code")%>/edit/">Карьерный рост редактирование
                записей</a></li>

        </ol>
    </title>
</head>
<body>
<div class="col-sm-8 blog-main">
    <form:form commandName="careerview" action="save/">


        <form:select cssClass="form-control" placeholder="Должность" path="career.Post"></br>
            <c:forEach var="item" items="${ru.tusur.domain.Post}">
                <form:option value="{item.text}"><spring:eval expression="item"/></form:option>
            </c:forEach>
            <form:options/>
        </form:select></br>
        <form:input cssClass="form-control" placeholder="Дата" readonly="true" path="dDate" id="dDate"/></br>
        <form:textarea cssClass="form-control" placeholder="Комментарий" path="career.coment"/></br>


        <button class="btn btn-default btn-info btn-lg" value="Сохранить" type="submit"><span
                class="glyphicon glyphicon-ok"></span>
            Сохранить
        </button>
    </form:form>
</div>
</body>
</html>