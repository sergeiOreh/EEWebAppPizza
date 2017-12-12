<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Enter</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12"></div>
    </div>
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4">
            <form id="form_aut" name="form_aut" method="post" action="/login">
                <div class="form-group">
                    <label for="use">Name:</label>
                    <input type="text" name="username" class="form-control" id="use">
                </div>
                <div class="form-group">
                    <label for="pass">Password:</label>
                    <input type="password" name="password" class="form-control" id="pass">
                </div>
                <button type="submit" class="btn btn-default">Enter</button>
            </form>
        </div>
        <div class="col-lg-4"></div>
    </div>
    <div class="row">
        <div class="col-lg-12"></div>
    </div>
</div>
</body>
</html>
