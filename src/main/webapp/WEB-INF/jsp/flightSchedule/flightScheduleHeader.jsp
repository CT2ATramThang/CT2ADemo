<%-- 
    Document   : flightHeader
    Created on : Oct 1, 2020, 9:08:15 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="" />
        <meta name="keywords" content="" />
        <meta name="author" content="" />

        <!-- Facebook and Twitter integration -->
        <meta property="og:title" content=""/>
        <meta property="og:image" content=""/>
        <meta property="og:url" content=""/>
        <meta property="og:site_name" content=""/>
        <meta property="og:description" content=""/>
        <meta name="twitter:title" content="" />
        <meta name="twitter:image" content="" />
        <meta name="twitter:url" content="" />
        <meta name="twitter:card" content="" />

        <link href="https://fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">

        <!-- Animate.css -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/animate.css">
        <!-- Icomoon Icon Fonts-->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/icomoon.css">
        <!-- Bootstrap  -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/bootstrap.css">

        <!-- Magnific Popup -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/magnific-popup.css">

        <!-- Flexslider  -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/flexslider.css">

        <!-- Owl Carousel -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/owl.carousel.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/owl.theme.default.min.css">

        <!-- Date Picker -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/bootstrap-datepicker.css">
        <!-- Flaticons  -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/fonts/flaticon/font/flaticon.css">

        <!-- Theme style  -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/style.css">

        <!-- Modernizr JS -->
        <script src="${pageContext.request.contextPath}/template/js/modernizr-2.6.2.min.js"></script>






        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/template/plugins/OwlCarousel2-2.2.1/owl.carousel.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/template/plugins/OwlCarousel2-2.2.1/owl.theme.default.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/template/plugins/OwlCarousel2-2.2.1/animate.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/template/styles/single_listing_styles.css">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/template/styles/single_listing_responsive.css">
    </head>
    <body>
        <div class="colorlib-loader"></div>

        <div id="page">
            <nav class="colorlib-nav" role="navigation">
                <div class="top-menu">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-xs-2">
                                <div id="colorlib-logo"><a href="homePage">Diamond Airline</a></div>
                            </div>
                            <div class="col-xs-10 text-right menu-1">
                                <ul>
                                    <li class="active"><a href="${pageContext.request.contextPath}/homePage.jsp">Home</a></li>
                                    <li class="has-dropdown">
                                        <a href="#">Plan</a>
                                        <ul class="dropdown">
                                            <li><a href="#">Flight Net</a></li>
                                            <li><a href="#">Airport Information</a></li>
                                        </ul>
                                    </li>
                                    <li><a href="#">Booking Ticket</a></li>
                                    <li><a href="#">Promotion</a></li>
                                    <li><a href="#">About</a></li>
                                    <li><a href="${pageContext.request.contextPath}/operationFlight">Login</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </nav>
    </body>
</html>
