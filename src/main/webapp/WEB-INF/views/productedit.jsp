<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="apple-touch-icon" sizes="76x76" href="/img/apple-icon.png">
  <link rel="icon" type="image/png" href="/img/favicon.png">
  <title>
   TEAM N2K2C
  </title>
<!--     Fonts and icons     -->
<link rel="stylesheet" type="text/css"
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />
<!-- Nucleo Icons -->
<link href="/css/nucleo-icons.css" rel="stylesheet" />
<link href="/css/nucleo-svg.css" rel="stylesheet" />
<!-- Font Awesome Icons -->
<script src="https://kit.fontawesome.com/42d5adcbca.js"
	crossorigin="anonymous"></script>
<!-- Material Icons -->
<link
	href="https://fonts.googleapis.com/icon?family=Material+Icons+Round"
	rel="stylesheet">
<!-- CSS Files -->
<link id="pagestyle" href="/css/material-dashboard.css?v=3.1.0"
	rel="stylesheet" />
<!-- Nepcha Analytics (nepcha.com) -->
<!-- Nepcha is a easy-to-use web analytics. No cookies and fully compliant with GDPR, CCPA and PECR. -->
<script defer data-site="YOUR_DOMAIN_HERE"
	src="https://api.nepcha.com/js/nepcha-analytics.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
	integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
	crossorigin="anonymous">
	
</script>

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.min.js"
	integrity="sha384-7VPbUDkoPSGFnVtYi0QogXtr74QeVeeIs99Qfg5YCF+TidwNdjvaKZX19NZ/e6oz"
	crossorigin="anonymous">
	
</script>
<style>
.input {
	border: none;
	outline: none;
	border-radius: 15px;
	padding: 1em;
	background-color: #ccc;
	box-shadow: inset 2px 5px 10px rgba(0, 0, 0, 0.3);
	transition: 300ms ease-in-out;
	width: 500px;
	margin-bottom: 20px;
	margin-right: 20px
}

.input:focus {
	background-color: white;
	transform: scale(1.05);
	box-shadow: 13px 13px 100px #969696, -13px -13px 100px #ffffff;
}

.container form {
	display: flex;
	flex-wrap: wrap;
	flex-direction: column;
}

.container label {
	display: flex;
	cursor: pointer;
	font-weight: 500;
	position: relative;
	overflow: hidden;
	margin-bottom: 0.375em;
}

.container  label input {
	position: absolute;
	left: -9999px;
}

.container label input:checked+span {
	background-color: #414181;
	color: white;
}

.container label input:checked+span:before {
	box-shadow: inset 0 0 0 0.4375em #00005c;
}

.container label span {
	display: flex;
	align-items: center;
	padding: 0.375em 0.75em 0.375em 0.375em;
	border-radius: 99em;
	transition: 0.25s ease;
	color: #414181;
}

.container label span:hover {
	background-color: #d6d6e5;
}

.container label span:before {
	display: flex;
	flex-shrink: 0;
	content: "";
	background-color: #fff;
	width: 1.5em;
	height: 1.5em;
	border-radius: 50%;
	margin-right: 0.375em;
	transition: 0.25s ease;
	box-shadow: inset 0 0 0 0.125em #00005c;
}

.click {
	margin-left: 20px;
	padding: 15px 25px;
	border: unset;
	border-radius: 15px;
	color: #212121;
	z-index: 1;
	background: #e8e8e8;
	position: relative;
	font-weight: 1000;
	font-size: 17px;
	-webkit-box-shadow: 4px 8px 19px -3px rgba(0, 0, 0, 0.27);
	box-shadow: 4px 8px 19px -3px rgba(0, 0, 0, 0.27);
	transition: all 250ms;
	overflow: hidden;
}

.click::before {
	content: "";
	position: absolute;
	top: 0;
	left: 0;
	height: 100%;
	width: 0;
	border-radius: 15px;
	background-color: #212121;
	z-index: -1;
	-webkit-box-shadow: 4px 8px 19px -3px rgba(0, 0, 0, 0.27);
	box-shadow: 4px 8px 19px -3px rgba(0, 0, 0, 0.27);
	transition: all 250ms
}

.click:hover {
	color: #e8e8e8;
}

.click:hover::before {
	width: 100%;
}
</style>
</head>

<body>
	<%@ include file="menuadmin.jsp"%>
	<div class="card" style="padding-left: 300px">
		<div class="card-body">
			<h5 class="text-center">Product Management</h5>

			<form:form action="/admin/productedit" modelAttribute="item">
				<div style="padding-left: 00px;">
					<form:input path="id" id="input" type="text"
						autocomplete="off" name="text" class="input"
						placeholder="ID" />
					<form:input path="name" id="input" type="text"
						autocomplete="off" name="text" class="input"
						placeholder="Name" />
					<form:input path="price" id="input" type="text"
						autocomplete="off" name="text" class="input"
						placeholder="Price" />
					<form:input type="date" class="input" id="createdate" disabled="true" path="createdate"
											aria-describedby="createDateHid" placeholder="createDate" />
					<form:input path="quantity" id="input" type="text" autocomplete="off"
						name="text" class="input" placeholder="Quantity" />
					<form:input type="file"  id="photo"
											path="image" aria-describedby="photoHid" placeholder="photo" />
											<img src="/img/${item.image}" style="width:10%" alt="user1">
					 <div>
					 Category
					<form:select path="category" >
					 	 <form:options items="${categories}" itemLabel="name" /> 
					</form:select>
						</div>	 
					<div>
						Available
						<form:radiobuttons class="mx-2" path="avaliable" items="${avaliable }"
							delimiter="" />
					</div>
								
					

				</div>
		
		<hr>
		<div style="padding-left: 275px;">
			<button class="click" formaction="/admin/product/create">Create</button>
			<button class="click" formaction="/admin/product/update">Update</button>
			<button class="click" formaction="/admin/product/delete/${id}">Delete</button>
			<button class="click" formaction="/admin/productedit">Reset</button>
		</div>
		<div style="padding-left: 435px; padding-top:20px">
			<button class="click" formaction="/admin/product">Product List</button>

		</div>
		</form:form>
</div>
<hr></hr>
<hr></hr>
<hr></hr>
	</div>

	<%@ include file="footer.jsp"%>
<script type="text/javascript">
//Lấy đối tượng input date
var inputDate = document.querySelector('input[type="date"][id="createdate"]');

// Lấy ngày hôm nay và đặt giá trị cho đối tượng input date
var today = new Date().toISOString().substr(0, 10);
inputDate.value = today;
</script>
</body>
</html>