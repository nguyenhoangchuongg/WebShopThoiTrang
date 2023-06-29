<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Products</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">

<style type="text/css">
.input1 {
	width: 300px;
}
</style>
</head>
<body>
	<div class="container">
		<br>
		<form action="/product/SearchAndPage" method="post">
			<input class="form-control input1" name="keywords"
				value="${keywords}"><br> <input
				class="form-control input1" name="price" value="${price}"><br>
			 <select name="category">
				<option value="">Tất cả danh mục</option>
				<option value="electronics">Áo</option>
				<option value="fashion">Túi xách</option>
				<option value="home">Quần</option>
			</select>
			<button class="btn btn-primary">Search</button>
		</form>
		<br>
		<table class="table table-borderless table-hover caption-top"
			style="width: 100%">
			<thead class="table-dark">
				<tr>
					<th scope="col">Category Id</th>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
					<th scope="col">Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${page.content}">
					<tr>
						<td>${page.id}</td>
						<td>${page.name}</td>
						<td>${page.price}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="btn-toolbar" role="toolbar"
			aria-label="Toolbar with button groups">
			<div class="btn-group me-2" role="group" aria-label="First group">
				<button type="button" class="btn btn-outline-danger">
					<a href="/product/SearchAndPage?p=0"
						style="color: black; text-decoration: none;">First</a>
				</button>
				<button type="button" class="btn btn-outline-danger">
					<a href="/product/SearchAndPage?p=${page.number-1}"
						style="color: black; text-decoration: none;">Previous</a>
				</button>
				<button type="button" class="btn btn-outline-danger">
					<a href=/product/SearchAndPage?p=${page.number+1}
						"
						style="color: black; text-decoration: none;">Next</a>
				</button>
				<button type="button" class="btn btn-outline-danger">
					<a href="/product/SearchAndPage?p=${page.totalPages-1}"
						style="color: black; text-decoration: none;">Last</a>
				</button>
			</div>
		</div>
		<br>
		<div class="tagUl">
			<caption style="font-weight: bold; color:;">Số thực thể
				hiện tại : ${page.numberOfElements}</caption>
			<br>
			<caption style="font-weight: bold; color:;">Trang số :
				${page.number+1}</caption>
			<br>
			<caption style="font-weight: bold; color:;">Kích thước
				trang : ${page.size}</caption>
			<br>
			<caption style="font-weight: bold; color:;">Tổng số thực
				thể : ${page.totalElements}</caption>
			<br>
			<caption style="font-weight: bold; color:;">Tổng số trang :
				${page.totalPages}</caption>
		</div>
	</div>
</body>
</html>