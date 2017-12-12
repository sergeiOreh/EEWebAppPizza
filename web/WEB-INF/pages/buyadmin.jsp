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

            <h3>Orders:</h3>

            <table class="table">
                <thead>
                <tr class="label-info">
                    <th>Buyer</th>
                    <th>Name pizza</th>
                    <th>Price one pizza</th>
                    <th>Quantity</th>
                    <th>Status</th>
                    <th>Options</th>
                </tr>
                </thead>
                <c:forEach var="order" items="${orders}">
                    <tbody>
                    <tr class="active">
                        <td>${order.firstName} ${order.surname}</td>
                        <td>${order.orderPizzaName}</td>
                        <td>${order.orderPriceOnePizza}</td>
                        <td>${order.quantity}</td>
                        <td>${order.status}</td>

                        <td>
                        <form action="${pageContext.request.contextPath}/admin/orders" method="post">
                            <input type="hidden" name="id" value="${order.id}">
                            <input type="submit" value="delete" class="btn">
                        </form>
                            change status<br>
                            <form action="${pageContext.request.contextPath}/admin/status" method="post">
                                <input type="hidden" name="id" value="${order.id}"><br>
                                <label>
                                    <select name="status" id=status">
                                        <option>SENT</option>
                                        <option>DELIVERED</option>
                                        <option selected>WAITING...</option>
                                    </select>
                                </label>
                                <input type="submit" value="Ok" class="btn">
                            </form>
                        </td>
                    </tr>
                    </tbody>
                </c:forEach>
            </table>


            <div class="col-lg-2">

            </div>
        </div>
        <div class="row">
            <div class="col-lg-12"></div>
        </div>
    </div>
</body>

</html>
