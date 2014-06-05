<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>
        <ol class="breadcrumb">
            <li>Вход в приложение</li>
        </ol>
    </title>

</head>
<body>

<div  style="margin-left: 290px; font-weight: bold; font-size: 16px">
    Если вы знаете ваш логин и пароль, авторизуйтесь, пожалуйста
    <img src="/resources/arrow.png" alt="Русское ТВ логотип"/>
</div>
   <!-- <form class="form-horizontal" action="<c:url value="/j_spring_security_check"/>" method="POST">

        <div class="form-group">
            <label for="email" class="col-sm-2 control-label">E-mail</label>
            <div class="col-sm-10">
                <input type="text" id="email" name="j_username" class="form-control"/>
            </div>
        </div>

        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">Пароль</label>
            <div class="col-sm-10">
                <input type="password" id="password" name="j_password" class="form-control"/>
            </div>
        </div>

        <div class="checkbox">
            <label>
                <input type="checkbox" name="_spring_security_remember_me" /> Запомнить
            </label>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" value="Войти" class="btn btn-primary"/>
            </div>
        </div>

    </form> -->



</body>
</html>
