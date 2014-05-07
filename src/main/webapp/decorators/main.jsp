<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>[TEST APPLICATION] :: <decorator:title default="Undefined page"/></title>
    <decorator:head />
</head>
<body>
<h1><decorator:title default="Undefined page"/></h1>
<decorator:body />
</body>
</html>
