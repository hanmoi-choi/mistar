<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>

<html>
<head>
    <title>Apollo Medical Image Star</title>

    <link rel="stylesheet" href="<c:url value="/resources/css/ext-all.css" />" type="text/css">
    <link rel="stylesheet" href="<c:url value="/public-resources/css/desktop.css" />" type="text/css">
</head>

<body>

    <%--<script src="http://localhost:8080/mi/socket.io/socket.io.js"></script>--%>
    <script type="text/javascript" src="<c:url value="/js-libs/extjs/ext-debug.js" />"></script>
    <script type="text/javascript" src="<c:url value="/js-libs/jquery/jquery.js" />"></script>
    <script type="text/javascript" src="<c:url value="/js-libs/jquery/jquery.atmosphere.js" />"></script>
    <script type="text/javascript" src="<c:url value="/client-js/EntryPoint.js" />"></script>

</body>
</html>
