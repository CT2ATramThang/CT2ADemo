<%-- 
    Document   : payment
    Created on : Oct 5, 2020, 8:37:19 AM
    Author     : Admin
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment</title>
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
        
        <!-- Checkout Section End -->
        <jsp:include page="${pageContext.request.contextPath}/../WEB-INF/jsp/header.jsp" />
        <div id="colorlib-subscribe" style="background-image: url(${pageContext.request.contextPath}/template/images/images/flight4.jpg);" data-stellar-background-ratio="0.5">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3 text-center colorlib-heading animate-box">
                        <h2>Payment</h2>
                        <p>Thanh toán chuyến bay <c:forEach var="flight" items="${flightList}" >${flight.flightRoute.airPortStationFrom.airportName} -> ${flight.flightRoute.airPortStationTo.airportName}</c:forEach> của bạn.</p>

                        </div>
                    </div>
                </div>
            </div>


            <!-- Checkout Section Begin -->
            <!-- Shopping Cart Section Begin -->
            <section id="colorlib-subscribe" style="background-image: url(${pageContext.request.contextPath}/template/images/images/flight4.jpg);" data-stellar-background-ratio="0.5">
            <div class="overlay"></div>
            <div class="container">
                <mvc:form modelAttribute="customer" action="${pageContext.request.contextPath}/checkAccount" method="post">
                    <div class="row">
                        <div class="col-lg-8 col-md-6">

                            <h6 class="checkout__title">Billing Details</h6>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p style="color: white;"">Customer FirstName<span>*</span></p>
                                        <mvc:input type="text" path="customerFirstName" />
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p style="color: white;"">Customer LastName<span>*</span></p>
                                        <mvc:input type="text" path="customerLastName" />
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p style="color: white;"">Customer Address<span>*</span></p>
                                    <mvc:input type="text" path="customerAddress" />
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p style="color: white;"">Customer Birthdate<span>*</span></p>
                                    <mvc:input type="date" path="customerBirthdate" />
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p style="color: white;"">Email<span>*</span></p>
                                    <mvc:input type="email" path="email" />
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p style="color: white;"">Phone<span>*</span></p>
                                    <mvc:input type="phone" path="phone" />
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-8 col-md-6">

                            <h6 class="checkout__title">Billing Details</h6>
                            <div class="row">
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p style="color: white;"">Account Number<span>*</span></p>
                                        <input type="text" name="accountNumber" />
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p style="color: white;"">Account Name<span>*</span></p>
                                        <input type="text" name="accountName" />
                                    </div>
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p style="color: white;"">Releases Date<span>*</span></p>
                                    <input type="date" name="releasesDate" />
                                </div>
                            </div>
                            <div class="col-lg-6">
                                <div class="checkout__input">
                                    <p style="color: white;"">Security Code<span>*</span></p>
                                    <input type="text" name="securityCode" />
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-lg-6 ">
                                    <div class="continue__btn">

                                    </div>
                                </div>
                                <div class="col-lg-6 ">
                                    <div class="continue__btn update__btn">
                                        <input type="submit" name="payment" class="site-btn" value="Payment" />
                                    </div>
                                </div>
                            </div>
                        </mvc:form>

                    </div>
                    <div class="col-lg-4 col-md-6">
                        <div class="checkout__order">
                            <h6 class="order__title">Chi tiết chuyến bay</h6>
                            <div class="checkout__order__products"> <span>Total</span></div>
                            <ul class="checkout__total__products">
                                <c:forEach var="ticket" items="${booking.ticketList}">
                                    <li><samp>${ticket.ticketId}.</samp> ${ticket.ticketType.type} <span>$ ${ticket.realPriceTicket}</span></li>
                                    </c:forEach>
                            </ul>
                            <ul class="checkout__total__all">
                                <li>Total <span>$ ${booking.total}</span></li>
                            </ul>

                           <%-- <button type="submit" class="site-btn">PLACE ORDER</button> --%>
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
