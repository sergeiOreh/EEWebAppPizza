<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Pizza</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap.min.css">
    <script src="${pageContext.request.contextPath}/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-lg-12"></div>
    </div>
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8">

            <h3>My orders:</h3>

            <table class="table">
                <thead>
                <tr class="label-info">
                    <th>Number</th>
                    <th>Month</th>
                    <th>Year</th>
                    <th>Description</th>
                </tr>
                </thead>
                <c:forEach var="card" items="${cards}">
                    <tbody>
                    <tr class="active">
                        <td>${card.number}</td>
                        <td>${card.month}</td>
                        <td>${card.year}</td>
                        <td>${card.description}</td>

                    </tr>

                    </tbody>
                </c:forEach>
            </table>

            <form action="${pageContext.request.contextPath}/user/add" method="post">

                <label>
                    Number <input type="number" id="number" name="number"  required>
                </label><br>
                <label>
                    Month <input type="number" id="month" name="month" required>
                </label><br>
                <label>
                    Year <input type="number" id="year" name="year"  required>
                </label><br>
                <label>
                    Description <input type="text" id="descr" name="descr"  required>
                </label><br>
                <label>
                    <input type="submit" value="add" class="btn">
                </label>
            </form>

        </div>
        <div class="col-lg-2">


        </div>

        <div class="row">
            <div class="col-lg-12"></div>
        </div>
    </div>
</body>

</html>
