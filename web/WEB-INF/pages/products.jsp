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
            <table class="table">
                <thead>
                <tr class="danger">

                    <th>Pizza Name</th>
                    <th>Price, $</th>
                    <th>Action</th>

                </tr>
                </thead>
                <tbody>
                <c:forEach var="item" items="${products}">
                    <tr class="warning">

                        <td>${item.pizzaName}</td>
                        <td>${item.price}</td>

                        <td>
                            <form action="${pageContext.request.contextPath}/user/cart" method="post">
                                <input type="hidden" name="idOrderItem" value="${item.idOrderItem}">
                                <label>
                                    Quantity <input type="number" id="number" name="number" min="1" max="20" step="1" required>
                                </label>
                                <input type="submit" value="Add to Cart" class="btn">
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col-lg-2">
            <h2><a href="${pageContext.request.contextPath}/user/orders">MY ORDERS</a></h2> <!-- -->
            <h2><a href="${pageContext.request.contextPath}/user/cards">MY CARDS</a></h2> <!-- -->



        </div>
    </div>
    <div class="row">
        <div class="col-lg-12"></div>
    </div>
</div>
</body>

</html>
