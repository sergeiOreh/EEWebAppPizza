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
        <div class="col-lg-1"></div>
        <div class="col-lg-10">

            <h2>Your order:</h2>

            <table class="table table-striped">
                <thead>
                    <tr>

                        <th>Pizza Name</th>
                        <th>Price One Pizza, $</th>
                        <th>Quantity</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                <c:forEach var="pizza" items="${orders}">
                    <tr>

                        <td>${pizza.pizzaName}</td>
                        <td>${pizza.price}</td>
                        <td>${pizza.quantity}</td>
                        <td>
                            <form action="${pageContext.request.contextPath}/user/products" method="post">
                                <input type="hidden" name="id" value="${pizza.idOrderItem}">
                                <label>
                                    <input type="submit" value="delete" class="btn">
                                </label>
                            </form>
                            <form action="${pageContext.request.contextPath}/user/editing" method="post">
                                <input type="hidden" name="name" value="${pizza.pizzaName}">
                                <input type="hidden" name="price" value="${pizza.price}">
                                <input type="hidden" name="quantity" value="${pizza.quantity}">
                                <label>
                                    <input type="submit" value="edit" class="btn">
                                </label>
                            </form>
                            <form action="${pageContext.request.contextPath}/user/buy" method="post">
                                <input type="hidden" name="name" value="${pizza.pizzaName}">
                                <input type="hidden" name="price" value="${pizza.price}">
                                <input type="hidden" name="quantity" value="${pizza.quantity}">
                                <label>
                                    <input type="submit" value="Buy" class="btn">
                                </label>
                            </form>

                        </td>

                    </tr>

                </c:forEach>

                </tbody>
            </table>



        </div>
        <div class="col-lg-1">

        </div>
    </div>
    <div class="row">
        <div class="col-lg-12"></div>
    </div>
</div>
</body>

</html>