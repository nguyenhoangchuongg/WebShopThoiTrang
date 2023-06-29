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
  <%@ include file="menuthongke.jsp" %> 
   <main class="main-content position-relative max-height-vh-100 h-100 border-radius-lg " style="padding-left:280px">
<!-- Page wrapper  -->

	<!-- End Container fluid  -->

<div class="container-fluid py-4">
      <div class="row">
        <div class="col-12">
          <div class="card my-4">
            <div class="card-header p-0 position-relative mt-n4 mx-3 z-index-2">
              <div class="bg-gradient-primary shadow-primary border-radius-lg pt-4 pb-3">
                <h6 class="text-white text-capitalize ps-3">Best Seller</h6>
              </div>
            </div>
            <div class="card-body px-0 pb-2">
              <div class="table-responsive p-0">
                <table class="table align-items-center mb-0">
                  <thead>
                    <tr>
                      <th class=" text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Product Image</th>
                      <th class=" text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">No.</th>
                      <th class=" text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Product ID</th>
                      <th class=" text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Product Name</th>
                      <th class=" text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Product Price</th>
                      <th class=" text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Quantity</th>
                    </tr>
                  </thead>
                  <tbody>
                  <c:set var="i" value="0"/>
                  <c:forEach var="item" items="${topList.content}">
                    <tr>
                      <td>
                        <div class="d-flex px-2 py-1">
                          <div>
                            <img src="/img/${item.product.image}" class="avatar avatar-sm me-3 border-radius-lg" alt="user1">
                          </div>
                          <div class="d-flex flex-column justify-content-center">
                            
                          
                          </div>
                        </div>
                      </td>
                      <td>
                        <p class="text-xs font-weight-bold mb-0">${i = i + 1 }</p>
                      </td>
                      <td>
                        <p class="text-xs font-weight-bold mb-0">${item.product.id}</p>
                      </td>
                       <td>
                        <p class="text-xs font-weight-bold mb-0">${item.product.name}</p>
                      </td>
                      <td>
                        <p class="text-xs font-weight-bold mb-0">${item.product.price}</p>
                      </td>
                      <td class="align-middle text-center text-sm">
                        <span class="badge badge-sm bg-gradient-success">${item.sum }</span>
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
	<!-- footer -->



	<!-- End footer -->

</div>
</main> <%@ include file="footer.jsp" %> 
</body>