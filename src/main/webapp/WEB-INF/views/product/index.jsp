
<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 10/4/2024
  Time: 9:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <h1 class="text-center text-primary">Danh sách sản phẩm nè</h1>
        <table class="table">
            <thead>
            <tr>
                <th>STT</th>
                <th>Name</th>
                <th>Price</th>
                <th>Image</th>
                <th>Category</th>
                <th>Status</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${products}" var="product" varStatus="loop">
                <tr>
                    <td scope="row">${loop.count}</td>
                    <td>${product.productName}</td>
                    <td>${product.price}</td>
                    <td><img src=""></td>
                    <td>${product.category.categoryName}</td>
                    <td>${product.status ?
                     '<span class="badge badge-primary">Active</span>'
                     :'<span class="badge badge-danger">Inactive</span>'}</td>
                    <td>
                        <a href="/product/edit/${product.id}" class="btn btn-primary">Edit</a>
                        <a href="/product/delete/${product.id}" class="btn btn-danger">Delete</a>
                    </td>
                </tr>
            </c:forEach>


            </tbody>
        </table>
        <a href="/product/add" class="btn btn-success">Thêm mới</a>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
</body>
</html>