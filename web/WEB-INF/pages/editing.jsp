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
        <div class="col-lg-3"></div>
        <div class="col-lg-6">

                <h3>Edit order:</h3>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>Pizza Name</th>
                        <th>Price One Pizza, $</th>
                        <th>Quantity</th>
                        <th>New quantity:</th>
                    </tr>
                    </thead>
                    <tbody>

                        <tr>
                            <td>${name}</td>
                            <td>${price}</td>
                            <td>${quantity}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/user/editing" method="post">
                                    <input type="number" name="quantity" min="1" max="20" step="1" required>
                                    <input type="hidden" name="name" value="${name}">
                                    <input type="hidden" name="price" value="${price}">
                                    <input type="hidden" name="quantity" value="${quantity}">
                                    <input type="submit" value="OK" class="btn">
                                </form><br>
                                <form action="${pageContext.request.contextPath}/user/products" method="post">
                                    <label>
                                        <input type="submit" value="delete" class="btn">
                                    </label>
                                </form>
                                <form action="${pageContext.request.contextPath}/user/buy" method="post">
                                    <input type="hidden" name="name" value="${name}">
                                    <input type="hidden" name="price" value="${price}">
                                    <input type="hidden" name="quantity" value="${quantity}">
                                    <label>
                                        <input type="submit" value="Buy" class="btn">
                                    </label>
                                </form>
                            </td>
                        </tr>

                    </tbody>
                </table>


        </div>
        <div class="col-lg-3">
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12"></div>
    </div>
</div>
</body>
</html>
