<%-- 
    Document   : customer
    Created on : Oct 10, 2020, 7:50:41 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer</title>
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
        <jsp:include page="${pageContext.request.contextPath}/../WEB-INF/jsp/header.jsp" />
        <div id="colorlib-subscribe" style="background-image: url(${pageContext.request.contextPath}/template/images/images/flight4.jpg);" data-stellar-background-ratio="0.5">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3 text-center colorlib-heading animate-box">
                        <h2>Customer</h2>
                        <p>Bhaapj thoon</p>

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
                    <div class="col-lg-8 col-md-6">
                        <h6 class="coupon__code"><span class="icon_tag_alt"></span> Have a coupon? <a href="#">Click
                                here</a> to enter your code</h6>
                                <mvc:form modelAttribute="booking" action= "${pageContext.request.contextPath}/inforCustomer" id="mailSender" method= "post">
                                    <c:forEach begin="0" end="${booking.ticketList.size()-1}" var="i" >
                                <h6 class="checkout__title" style="color: white;">${booking.ticketList.get(i).ticketType.type}</h6>
                                <div class="row">
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <p style="color: white;">Name Of TheFlyer<span>*</span></p>
                                            <mvc:input type="text" path="ticketList[${i}].nameOfTheFlyer" required="true" />
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
                                        <div class="checkout__input">
                                            <p style="color: white;">Child DateOfBirth<span>*</span></p>
                                            <mvc:input type="date" path="ticketList[${i}].childDateOfBirth" required="true"/>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p style="color: white; ">CMND<span>*</span></p>
                                        <mvc:input type="text" path="ticketList[${i}].cmnd" required="true" />
                                    </div>
                                </div>
                                <div class="col-lg-6">
                                    <div class="checkout__input">
                                        <p style="color: white; visibility: hidden;""><span>*</span></p>
                                        <input type="text" name="text"  style="visibility: hidden;" />
                                    </div>
                                </div>
                            </c:forEach>
                            <div class="row">
                                <div class="col-lg-6 ">
                                    <div class="continue__btn">

                                    </div>
                                </div>
                                <div class="col-lg-6 ">
                                    <div class="continue__btn update__btn">
                                        <input type="submit" name="continue" class="site-btn" value="Continue"/>
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
