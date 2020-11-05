<%-- 
    Document   : booking
    Created on : Oct 5, 2020, 9:29:55 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
        <jsp:include page="bookingHeader.jsp" />
        <div id="colorlib-subscribe" style="background-image: url(${pageContext.request.contextPath}/template/images/images/flight4.jpg);" data-stellar-background-ratio="0.5">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3 text-center colorlib-heading animate-box">
                        <h2>Booking</h2>
                        <p>Chọn chuyến bay <c:forEach var="flight" items="${flightList}" >${flight.flightRoute.airPortStationFrom.airportName} -> ${flight.flightRoute.airPortStationTo.airportName}</c:forEach> của bạn.</p>

                        </div>
                    </div>
                </div>
            </div>


            <!-- Checkout Section Begin -->
            <!-- Shopping Cart Section Begin -->
            <section id="colorlib-subscribe" style="background-image: url(${pageContext.request.contextPath}/template/images/images/flight4.jpg);" data-stellar-background-ratio="0.5">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="col-lg-8 text-center colorlib-heading animate-box">
                        <div class="shopping__cart__table" >
                            <table style="background-color: white;">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>Product</th>
                                        <th>Type</th>
                                        
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td class="product__cart__item">
                                            <div class="product__cart__item__pic">
                                                <div class="room_image"><a href="#demo${flight.flightId}"  class="btn btn-primary" data-toggle="collapse">View Details</a>
                                                    <div id="demo${flight.flightId}" class="collapse">
                                                        <div style="color: black;">${flight.flightTimeFrom}&nbsp;${flight.flightRoute.airPortStationFrom.airportName} </div><br>
                                                        <div style="color: black;">Flight Name:&nbsp;${flight.aircraft.airNumber}</div><br>
                                                        <div style="color: black;">Flight Time:&nbsp;${flight.flightRoute.duration}&nbsp;minutes</div><br>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="product__cart__item__text">
                                                <div class="email">
                                                    <div class="room_content">
                                                        <div class="room_price">${flight.flightTimeFrom}&nbsp;${flight.flightRoute.airPortStationFrom.airportName} ->&nbsp;${flight.flightTimeTo} ${flight.flightRoute.airPortStationTo.airportName}</div>
                                                        <div class="room_price">Flight Time:&nbsp;${flight.flightRoute.duration}&nbsp;minutes</div>
                                                        <div class="room_price">Flight Date:&nbsp;${flight.flightDate}</div>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                        
                                        <td class="cart__price">${ticketClass}</td>

                                    </tr>

                                </tbody>
                            </table>
                        </div>
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="continue__btn">

                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="continue__btn update__btn">
                                    <a href="${pageContext.request.contextPath}/customer">continue</a>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="checkout__order">
                            <h6 class="order__title">Chi tiết chuyến bay</h6>
                            <div class="checkout__order__products"> <span>Total</span></div>

                            <ul class="checkout__total__products">
                                <c:forEach var="ticket" items="${booking.ticketList}">
                                    <li> ${ticket.ticketType.type} x1  <span>$ ${ticket.realPriceTicket}</span></li>
                                    </c:forEach>
                            </ul>

                            <ul class="checkout__total__all">
                                <li>Total <span>$ ${booking.total}</span></li>
                            </ul>

                            <button type="submit" class="site-btn">PLACE ORDER</button>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Shopping Cart Section End -->




        <!-- Js Plugins -->
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
