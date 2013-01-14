<%--<%@page contentType="text/html;charset=UTF-8" %>--%>
<%--<%@page pageEncoding="UTF-8" %>--%>
<%--<%@ page session="false" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>--%>
<%--<!DOCTYPE html>--%>

<%--<html>--%>
<%--<head>--%>
<%--<title>Apollo Medical Image Star</title>--%>

<%--<link rel="stylesheet" href="<c:url value="/resources/css/ext-all.css" />" type="text/css">--%>
<%--<link rel="stylesheet" href="<c:url value="/public-resources/css/desktop.css" />" type="text/css">--%>
<%--</head>--%>

<%--<body>--%>

<%--&lt;%&ndash;<script src="http://localhost:8080/mi/socket.io/socket.io.js"></script>&ndash;%&gt;--%>
<%--<script type="text/javascript" src="<c:url value="/js-libs/extjs/ext-debug.js" />"></script>--%>
<%--<script type="text/javascript" src="<c:url value="/client-js/Login.js" />"></script>--%>
<%--</body>--%>
<%--</html>--%>

<%@page contentType="text/html;charset=UTF-8" %>
<%@page pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
    <title>Messages : List</title>
    <c:url var="bootstrapUrl" value="/public-resources/css/bootstrap.css"/>
    <link rel="stylesheet" href="${bootstrapUrl}">
    <!-- -->
    </link>
</head>
<body>

<c:url value="/securityCheck" var="securityCheck"/>
<form action="${securityCheck}" method="post">
<div class="container">
    <div class="row">
        <div class="well span6 offset2">
            <form class="form-stacked">
                <c:if test="${param.error != null}">
                    <div class="alert alert-error">
                        Failed to login.
                        <c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
                            Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
                        </c:if>
                    </div>
                </c:if>
                <c:if test="${param.logout != null}">
                    <div class="alert alert-success">
                        You have been logged out.
                    </div>
                </c:if>

                <h2>Log In</h2>
                <div class="cleaner_h20"></div>
                <div class="clearfix">
                    <div class="input">
                        <label for="username">Username</label>
                        <input type="text" class="xlarge" id="username" name="username" size="30" placeholder="Enter E-mail..."/>
                    </div>

                </div>

                <div class="clearfix">
                    <div class="input">
                        <label for="password">Password</label>
                        <input type="password" class="xlarge" id="password" name="password" size="30" placeholder="Enter Password..."/>


                    </div>

                </div>

                <div class="cleaner_h20"></div>
                <div class="form-actions">
                    <input id="submit" class="btn btn-primary btn-large" name="submit" type="submit" value="Login"/>
                </div>

            </form>
        </div>
    </div>




</div>
</form>

<%--<div class="navbar navbar-fixed-bottom">--%>
    <%--<div class="navbar-inner">--%>
        <%--<div class="container">--%>
            <%--<c:url var="homeUrl" value="/"/>--%>
            <%--<a href="${homeUrl}" class="brand">Messages</a>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

</body>
</html>
