<%-- 
    Document   : flight
    Created on : Sep 21, 2020, 11:46:03 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1"> 
        <title>Flight Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <link href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">



        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/css/animate.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/css/owl.carousel.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/css/owl.theme.default.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/css/magnific-popup.css">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/css/flaticon.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/template/css/css/style.css">
    </head>
    <body>
        <jsp:include page="flightHeader.jsp" />
        <div id="colorlib-subscribe" style="background-image: url(${pageContext.request.contextPath}/template/images/images/flight4.jpg);" data-stellar-background-ratio="0.5">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="col-md-6 col-md-offset-3 text-center colorlib-heading animate-box">
                        <h2>Chọn chuyến bay</h2>
                        <p>Chọn chuyến bay <c:forEach var="flight" items="${flightList}" >${flight.flightRoute.airPortStationFrom.airportName} -> ${flight.flightRoute.airPortStationTo.airportName}</c:forEach> của bạn.</p>

                        </div>
                    </div>
                </div>
            </div>

            <section id="colorlib-subscribe" style="background-image: url('${pageContext.request.contextPath}/template/images/images/flight4.jpg');" data-stellar-background-ratio="0.5">
            <div class="overlay"></div>
            <div class="container">
                <div class="row">
                    <div class="table-wrap " >
                        <table class="table">
                            <thead class="thead-primary">
                                <tr>
                                    <th>&nbsp;</th>
                                    <th>&nbsp;</th>
                                    <th>&nbsp;</th>
                                    <th>&nbsp;</th>
                                    <th>Economy</th>
                                    <th>Business</th>
                                    <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:if test="${flightList.size()>0}" >
                                    <c:forEach var="flight" items="${flightList}">
                                        <tr class="alert" role="alert">
                                            <td>
                                                <div class="room_image"><a href="#demo${flight.flightId}"  class="btn btn-primary" data-toggle="collapse">View Details</a>
                                                    <div id="demo${flight.flightId}" class="collapse">
                                                        <div>${flight.flightTimeFrom}&nbsp;${flight.flightRoute.airPortStationFrom.airportName} </div><br>
                                                        <div>Flight Name:&nbsp;${flight.aircraft.airNumber}</div><br>
                                                        <div>Flight Time:&nbsp;${flight.flightRoute.duration}&nbsp;minutes</div><br>
                                                    </div>
                                                </div>
                                            </td>
                                            <td>

                                            </td>
                                            <td>
                                                <div class="email">
                                                    <div class="room_content">
                                                        <div class="room_price">${flight.flightTimeFrom}&nbsp;${flight.flightRoute.airPortStationFrom.airportName} ->&nbsp;${flight.flightTimeTo} ${flight.flightRoute.airPortStationTo.airportName}</div>
                                                        <div class="room_price">Flight Time:&nbsp;${flight.flightRoute.duration}&nbsp;minutes</div>
                                                        <div class="room_price">Flight Date:&nbsp;${flight.flightDate}</div>
                                                    </div>
                                                </div>
                                            </td>
                                            <td class="quantity">

                                            </td>
                                            <td>
                                                <div class="button book_button trans_200"><a href="${pageContext.request.contextPath}/addTicketToCart/${flight.flightId}/${1}/${adult}/${child}">${flight.flightRoute.standPrice}</a></div>
                                            </td>
                                            <td>
                                                <div class="button book_button trans_200"><a href="${pageContext.request.contextPath}/addTicketToCart/${flight.flightId}/${2}/${adult}/${child}"><c:out value="${flight.flightRoute.standPrice*ticketClass.exchangeRateClass}"/></a></div>
                                            </td>

                                        </tr>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${flightList.size()==0}" >
                                <span>No Flight is found</span>
                            </c:if>
                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
        </section>



        <script src="${pageContext.request.contextPath}/template/js/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/js/jquery-migrate-3.0.1.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/js/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/js/jquery.easing.1.3.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/js/jquery.waypoints.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/js/jquery.stellar.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/js/owl.carousel.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/js/jquery.magnific-popup.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/js/jquery.animateNumber.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/js/scrollax.min.js"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
        <script src="${pageContext.request.contextPath}/template/js/js/google-map.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
        <script src="${pageContext.request.contextPath}/template/js/js/main.js"></script>

        <jsp:include page="${pageContext.request.contextPath}/../WEB-INF/jsp/footer.jsp" />


    </body>
</html>
