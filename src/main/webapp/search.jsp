<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Page</title>
</head>
<body>
    
	<div class="container">
	<h2 align="center"><font><strong>LIST OF PRODUCT</strong></font></h2>
		<form action="productsearch">
			Product Id:<input type="number" name="Product_Id" /><br> <input
				type="submit" value="Search" class=btnbtn-primary />
		</form>
     <hr />

		<table border="1" align="center">
			<tr>
				<th>Product ID</th>
				<th>Product Name</th>
				<th>Product Price</th>
				<th>Product Quantity</th>
			</tr>
			<c:forEach var="product" items="${prods}">
				<tr>
					<td>${product.prodId}</td>
					<td>${product.prodName}</td>
					<td>${product.prodPrice}</td>
					<td>${product.prodQty}</td>
				</tr>
			</c:forEach>

		</table>

	</div>
</body>
</html>