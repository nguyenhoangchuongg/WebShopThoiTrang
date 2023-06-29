<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!--
=========================================================
* Material Dashboard 2 - v3.1.0
=========================================================

* Product Page: https://www.creative-tim.com/product/material-dashboard
* Copyright 2023 Creative Tim (https://www.creative-tim.com)
* Licensed under MIT (https://www.creative-tim.com/license)
* Coded by Creative Tim

=========================================================

* The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
-->
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <link rel="apple-touch-icon" sizes="76x76" href="/img/apple-icon.png">
  <link rel="icon" type="image/png" href="/img/favicon.png">
  <title>
   TEAM N2K2C
  </title>
  <!--     Fonts and icons     -->
  <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,900|Roboto+Slab:400,700" />
  <!-- Nucleo Icons -->
  <link href="/css/nucleo-icons.css" rel="stylesheet" />
  <link href="/css/nucleo-svg.css" rel="stylesheet" />
  <!-- Font Awesome Icons -->
  <script src="https://kit.fontawesome.com/42d5adcbca.js" crossorigin="anonymous"></script>
  <!-- Material Icons -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Round" rel="stylesheet">
  <!-- CSS Files -->
  <link id="pagestyle" href="/css/material-dashboard.css?v=3.1.0" rel="stylesheet" />
  <!-- Nepcha Analytics (nepcha.com) -->
  <!-- Nepcha is a easy-to-use web analytics. No cookies and fully compliant with GDPR, CCPA and PECR. -->
  <script defer data-site="YOUR_DOMAIN_HERE" src="https://api.nepcha.com/js/nepcha-analytics.js"></script>
</head>
 <body class="g-sidenav-show  bg-gray-200">
  <%@ include file="menuthongke.jsp" %> 
   <main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg " style="padding-left:280px">


	<!-- Bảng -->

	<div class="content">

		<div class="row">
			<div class="col-md-10 offset-md-1">

				<div class="row px-3 py-1">
					<div class="col-3 alert alert-primary">
						<form action="/admin/reportOrderByDate" method="post">
							<div class="form-group">
								Form Date:<input type="text" class="form-control" name="firstDate" id="firstDate" aria-describedby="firstDateHid" placeholder="MM-dd-yyyy" />
							</div>
							<div class="form-group">
								To Date: <input type="text" class="form-control" name="lastDate" id="lastDate" aria-describedby="lastDateHid" placeholder="MM-dd-yyyy" />
							</div>
							<button type="submit" class="btn btn-primary ">Search</button>
						</form>
					</div>
					<div class="col-3 alert alert-info offset-6">
						<h3 class="text-center">Order</h3>
						<h5>From: <fmt:formatDate pattern = "MM-dd-yyyy" value = "${firstDate }" /></h5>
						<h5>To: <fmt:formatDate pattern = "MM-dd-yyyy" value = "${lastDate }" /></h5>
						<h5>Total: ${page.totalElements }</h5>
					</div>
				</div>

			</div>
		</div>
			
			</div>


<div class="container-fluid py-4">
      <div class="row">
        <div class="col-12">
          <div class="card my-4">
            <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
              <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                <h6 class="text-white text-capitalize ps-3">Order Date Management</h6>
              </div>
            </div>
            <div class="card-body px-0 pb-2">
              <div class="table-responsive p-0">
                <table class="table align-items-center mb-0">
                  <thead>
                    <tr>
                      <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Order ID</th>
                      <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Address</th>
                      <th class=" text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Create Date</th>
                      
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="item" items="${page.content}">
                    <tr>
                     <%--  <td>
                        <div class="d-flex px-2 py-1">
                          <div>
                            <img src="/img/${item.photo}" class="avatar avatar-sm me-3 border-radius-lg" alt="user1">
                          </div>
                          <div class="d-flex flex-column justify-content-center">
                            <h6 class="mb-0 text-sm">${item.username}</h6>
                            <p class="text-xs text-secondary mb-0">${item.email}</p>
                          </div>
                        </div>
                      </td> --%>
                      <td>
                        <p class="text-xs font-weight-bold mb-0">${item.id }</p>
                      </td>
                      <td>
                        <p class="text-xs font-weight-bold mb-0">${item.address }</p>
                      </td>
                      <td>
                        <p class="text-xs font-weight-bold mb-0">${item.createDate }</p>
                      </td>
                      
                    </tr>
                    </c:forEach>
                    
                  </tbody>
                </table>
                
              </div>
            </div>
          </div>
        </div>
      </div>
      </div>
</main>
 <%@ include file="footer.jsp" %> 

	

</body>
</html>