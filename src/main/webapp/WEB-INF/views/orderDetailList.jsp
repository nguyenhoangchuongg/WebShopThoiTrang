<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
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
 <%@ include file="menuadmin.jsp" %> 
  <main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg " style="padding-left:280px"><div class="page-wrapper py-2">
	<!-- Container fluid  -->
	<div class="container-fluid">
		<!-- Sales Cards  -->
		<div class="row">
			<div class="col-md-10 offset-md-1">
				<div class="col row" >
					<div style="margin-left:00px" class="col  alert alert-info " >
						<h3 class="text-center">Order</h3>
						<h5>ID: ${ord.id }</h5>
						<h5>Create Date: ${ord.createDate }</h5>
					</div>
					<div class="col alert alert-primary">
						<h3 class="text-center">Customer</h3>
						<h5>ID: ${ord.account.username }</h5>
						<h5>Name: ${ord.account.fullname }</h5>
						<h5>Address: ${ord.address }</h5>
						<h5>Email: ${ord.account.email }</h5>
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
            </div>
            <div class="card-body px-0 pb-2">
              <div class="table-responsive p-0">
                <table class="table align-items-center mb-0">
                  <thead>
                    <tr>
                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">OrderDetail
								ID</th>
                      
                      <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Product ID</th>
                      <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Product
								Name</th>
                      <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Product
								Price</th>
 <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Quantity</th>
								 <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">
								Order ID</th>
                      <th class="text-secondary opacity-7"></th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:forEach var="item" items="${page.content}">
                    <tr>
                      <td>
                        <div class="d-flex px-2 py-1">
                          <div>
                            <div>
                            <img src="/forUser/img/products/${item.product.image}" class="avatar avatar-sm me-3 border-radius-lg" alt="user1">
                          </div>
                          </div>
                          <div class="d-flex flex-column justify-content-center">
                            <h6 class="mb-0 text-sm">${item.id}</h6>
                            
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-xs font-weight-bold mb-0">${item.product.id}</p>
                      </td>
                      <td>
                        <p class="text-xs font-weight-bold mb-0">${item.product.name}</p>
                      </td>
                      <td class="align-middle text-center text-sm">
                        <span class="badge badge-sm bg-gradient-success">${item.product.price}</span>
                      </td>
                      <td class="align-middle text-center">
                        <span class="text-secondary text-xs font-weight-bold">${item.quantity }</span>
                      </td>
                      <td>
                        <p class="text-xs font-weight-bold mb-0">${item.order.id}</p>
                      </td>
                      <%-- <td class="align-middle">
                        <a href="/admin/orderDetail?id=${item.id }" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip" data-original-title="Edit user">
                          Edit
                        </a>
                      </td> --%>
                    </tr>
                    </c:forEach>
                    
                  </tbody>
                </table>
                <div class="text-center">
					<a href="/admin/order?p=0" class="btn btn-primary">First</a> 
					<a	href="/admin/order?p=${page.number-1}" class="btn btn-primary">Previous</a>
					<a href="/admin/order?p=${page.number+1}" class="btn btn-primary">Next</a>
					<a href="/admin/order?p=${page.totalPages-1}"	class="btn btn-primary">Last</a>
					
					<div class="text-center" >
			<a href="/admin/order"	class="btn btn-primary">Order List</a>
		</div>
				</div>
              </div>
            </div>
          </div>
        </div>
      </div>
      </div>
</main>
</body>
    <%@ include file="footer.jsp" %> 
  <script src="/js/core/popper.min.js"></script>
  <script src="/js/core/bootstrap.min.js"></script>
  <script src="/js/plugins/perfect-scrollbar.min.js"></script>
  <script src="/js/plugins/smooth-scrollbar.min.js"></script>
  <script>
    var win = navigator.platform.indexOf('Win') > -1;
    if (win && document.querySelector('#sidenav-scrollbar')) {
      var options = {
        damping: '0.5'
      }
      Scrollbar.init(document.querySelector('#sidenav-scrollbar'), options);
    }
  </script>

  <script async defer src="https://buttons.github.io/buttons.js"></script>

  <script src="/js/material-dashboard.min.js?v=3.1.0"></script> 
	<!-- End footer -->

</div>