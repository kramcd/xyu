<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/resources/favicon.ico">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/css/bootstrap.css"/>
    <link rel="stylesheet" href="/resources/css/bootstrap-responsive.css"/>
    <title>АИС учета персональных данных сотрудников ИП Кунгуров А.Н (сеть магазинов Русское ТВ) <decorator:title
            default="Undefined page"/></title>

    <decorator:head/>
    <!-- Bootstrap core CSS -->
    <!--<link href="/resources/css/bootstrap.min.css" rel="stylesheet">  --!>

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]>
    <script src="/resources/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <img src="/resources/logo.png" alt="Русское ТВ логотип"/>
        </div>
        <div class="navbar-collapse collapse">
            <security:authorize access="isAuthenticated()">
                <div class="navbar-brand"> Добро пожаловать, ${view.name} !
                    <a href="j_spring_security_logout">
                        <button class="btn btn-danger">Выйти</button>
                    </a>
                </div>
            </security:authorize>
            <security:authorize access="isAnonymous()">
                <form class="navbar-form navbar-right" role="form">
                    <div class="form-group">
                        <input type="text" placeholder="Email" class="form-control">
                    </div>
                    <div class="form-group">
                        <input type="password" placeholder="Password" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-success">Войти</button>
                </form>
            </security:authorize>
        </div><!--/.navbar-collapse -->
    </div>
</div>

<div class="jumbotron">
    <decorator:title/>
    </div>
<div class="container">
    <decorator:body/>


    <footer style="float: left; width: 100%">
        <hr>
        <p style="text-align: center">&copy; Разработал Верещагин Роман Евгеньевич в 2014 г.</p>
    </footer>
</div>
<!-- /container -->


</body>
</html>



