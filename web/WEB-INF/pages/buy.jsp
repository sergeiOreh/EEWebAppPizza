<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Pizza</title>
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
        <div class="col-lg-2"></div>
        <div class="col-lg-8">

            <h3>My orders:</h3>

            <table class="table">
                <thead>
                <tr class="label-info">
                    <th>Name</th>
                    <th>Price one pizza</th>
                    <th>Quantity</th>
                    <th>Status</th>
                </tr>
                </thead>
                <c:forEach var="order" items="${orders}">
                    <tbody>
                    <tr class="active">
                        <td>${order.orderPizzaName}</td>
                        <td>${order.orderPriceOnePizza}</td>
                        <td>${order.quantity}</td>
                        <td>${order.status}</td>

                    </tr>

                    </tbody>
                </c:forEach>
            </table>

        </div>
            <div class="col-lg-2">
                <h2><a href="${pageContext.request.contextPath}/user/products">BACK TO PRODUCTS</a></h2>

            </div>

        <div class="row">
            <div class="col-lg-12"></div>
        </div>
    </div>
</body>

</html>