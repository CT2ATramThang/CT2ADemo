<%-- 
    Document   : listCheck
    Created on : Oct 19, 2020, 6:02:16 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@400;500;600;700;800;900&display=swap"
              rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@300;400;500;600;700;800;900&display=swap"
              rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/cssCake/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/cssCake/flaticon.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/cssCake/barfiller.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/cssCake/magnific-popup.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/cssCake/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/cssCake/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/cssCake/nice-select.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/cssCake/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/cssCake/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/cssCake/style.css" type="text/css">
    </head>
    <body>

        <jsp:include page="${pageContext.request.contextPath}/../WEB-INF/jsp/header.jsp" />
        <div id="colorlib-subscribe" style="background-image: url(${pageContext.request.contextPath}/template/images/banner/img_bg_4.jpg);" data-stellar-background-ratio="0.5">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3 text-center colorlib-heading animate-box">
                        <h2>Booking</h2>
                        <p></p>
                        
                    </div>
                </div>
            </div>
        </div>
        <!-- Breadcrumb Begin -->
        <div class="breadcrumb-option">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <div class="breadcrumb__text">
                            <h2></h2>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6 col-sm-6">
                        <div class="breadcrumb__links">

                            <span></span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Breadcrumb End -->
        <section class="wishlist spad">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="wishlist__cart__table">
                            <table>
                                <thead>
                                    <tr>
                                        <th>Booking ID</th>
                                        <th>Code Booking</th>
                                        <th>Date Booking</th>
                                        <th>Customer Booking</th>
                                        <th>Amount</th>
                                        <th>&nbsp;</th>

                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="cart__price">
                                            ${booking.bookingId}
                                        </td>
                                        <td class="cart__price">${booking.codeBooking}</td>
                                        <td class="cart__price">${booking.dateBooking}</td>
                                        <td class="cart__price">${booking.customer.customerFirstName}</td>
                                        <td class="cart__price">${booking.total}</td>
                                        <td class="cart__btn"><a href="${pageContext.request.contextPath}/viewTicketList/${booking.bookingId}" class="primary-btn">View Details</a></td>

                                    </tr>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="${pageContext.request.contextPath}/template/js/jsCake/jquery-3.3.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/jsCake/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/jsCake/jquery.nice-select.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/jsCake/jquery.barfiller.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/jsCake/jquery.magnific-popup.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/jsCake/jquery.slicknav.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/jsCake/owl.carousel.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/jsCake/jquery.nicescroll.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/jsCake/main.js"></script>
        <jsp:include page="${pageContext.request.contextPath}/../WEB-INF/jsp/footer.jsp" />

    </body>

</html>
