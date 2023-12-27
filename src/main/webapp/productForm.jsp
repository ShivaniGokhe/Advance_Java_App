<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>
</head>
<body>
	<h1 align="center">Product Details</h1>

	<form action="product" method="post" align="center">

		<font color="green"> <c:out value="${success}" />
		</font>
		<table align="center" cellpadding="5" cellspacing="5">

			<tr>
				<td>Product Name</td>
				<td><input type="text" name="Product_Name"></td>
			</tr>
			<tr>
				<td>Product Price</td>
				<td><input type="number" name="Product_Price"></td>
			</tr>
			<tr>
				<td>Product Qty</td>
				<td><input type="number" name="Product_Qty"></td>
			</tr>
		</table>
		<input type="submit" value="Submit"><br> 
		<a href="productsearch">Get Products</a>
	</form>

</body>
</html>