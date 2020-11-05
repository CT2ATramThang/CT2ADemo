<%-- 
    Document   : homePage
    Created on : Sep 16, 2020, 8:50:22 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Diamond Airline</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="<c:url value='/resources/js/listDes.js'/>"></script>
        <style>
            #expand-toggle {
                display: none;
            }
            #expand-thang {
                display: none;
            }
            .expandable {
                visibility: collapse;

            }

            #expand-toggle:checked ~ * .expandable {
                visibility: collapse;
            }
            #expand-thang:checked ~ * .expandable {
                visibility: visible;
            }
            #expand-toggle:checked ~ #expand-btn {
                background-color: #ccc;
            }
            
            #black{
                background-color: #333544;
            }
            #option{
                background-color: #333544!important;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <aside id="colorlib-hero">
            <div class="flexslider">
                <ul class="slides">
                    <c:forEach var="banner" items="${imageList}">
                        <li style="background-image: url(${pageContext.request.contextPath}/template/images/banner/${banner.imgName});">
                            <div class="overlay"></div>
                        </li>                       
                    </c:forEach>	   	
                </ul>
            </div>
        </aside>
        <div id="colorlib-reservation">
            <!-- <div class="container"> -->
            <div class="row">
                <div class="search-wrap">
                    <div class="container">
                        <ul class="nav nav-tabs">
                            <li class="active"><a data-toggle="tab" href="#flight"><i class="flaticon-plane"></i> Booking Trip</a></li>
                            <li><a  data-toggle="tab" href="#hotel"><i class="flaticon-resort"></i>Check Booking</a></li>
                            <li><a data-toggle="tab" href="#car"><i class="flaticon-car"></i> Flight Schedules</a></li>

                        </ul>
                    </div>
                    <div class="tab-content">
                        <div id="flight" class="tab-pane fade in active">
                            <form  class="colorlib-form" name="flight" action= "${pageContext.request.contextPath}/findFlight" method="post" >
                                <input type="radio" name=radio" id="expand-toggle" checked />
                                <input type="radio" name=radio" id="expand-thang" />
                                <div class="row">
                                    <div class="col-md-3" >
                                        <div class="form-group" >
                                            <label for="date" >From:</label>
                                            <div class="form-field">                             
                                                <select name="airPortStationFrom" type="text" id="airPortStationFrom" class="form-control  " onchange="findDes();" >
                                                    <option id="option" value="">Select</option>
                                                    <c:forEach var="airport" items="${airPortList}">
                                                        <option id="option" value="${airport.airPortStationId}">${airport.airportName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3">                             
                                        <div class="form-group">
                                            <div class="form-field" id="demo">                             
                                                <label for="date">To:</label>
                                                <select name="airPortStationTo" id="black" class="form-control" >
                                                    <option value="">Select</option>
                                                   <c:forEach var="destination" items="${destinations}">
                                                       <option id="option" value="${destination.airPortStationId}">${destination.airportName}</option>
                                                   </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="date">Depart:</label>
                                            <div class="form-field" >
                                                <input name ="depart" type="date"  class="form-control">
                                            </div>
                                        </div>
                                    </div>
                                    <input type="checkbox" id="expand-toggle" />
                                    <div class="col-md-3 expandable">
                                        <div class="form-group" id="black">
                                            <label for="date">Return:</label>
                                            <div class="form-field">

                                                <input name ="return" type="date" id="date" class="form-control" placeholder="Return">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="guests">Adult:(12+ yrs)</label>
                                            <div class="form-field" >
                                                <i class="icon icon-arrow-down3"></i>
                                                <select name="adult"  id="black" class="form-control">
                                                    <option value="1" >1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="guests">Child:(2-11 yrs)</label>
                                            <div class="form-field">
                                                <i class="icon icon-arrow-down3"></i>
                                                <select name="child"  id="black" class="form-control">
                                                    <option value="0" >0</option>
                                                    <option value="1" >1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                    <option value="5">5</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="guests">Infant:(0-2 yrs)</label>
                                            <div class="form-field">
                                                <i class="icon icon-arrow-down3"></i>
                                                <select name="infant" value="infantpeople" id="black" class="form-control">
                                                    <option value="0">0</option>
                                                    <option value="1">1</option>

                                                </select>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-2">
                                        <input type="submit" name="submit" id="submit" value="Find Flights" class="btn btn-primary btn-block">
                                    </div>
                                    <div class="col-md-2">
                                        <label for="expand-toggle" class="btn btn-primary btn-block" id="expand-btn">One way</label>
                                    </div>
                                    <div class="col-md-1">
                                        <label for="expand-thang" class="btn btn-primary btn-block" id="expand-btn">Round Trip</label>
                                    </div>
                                </div>

                            </form>
                        </div>
                        <div id="hotel" class="tab-pane fade">
                            <mvc:form class="colorlib-form" action="${pageContext.request.contextPath}/findBooking" method="post">
                                <div class="row">
                                    <div class="col-md-2">
                                        <div class="booknow">
                                            
                                        </div>
                                    </div>
                                    <div class="col-md-4">
                                        <div class="form-group">
                                            <label for="date">Check</label>
                                            <div class="form-field">
                                                
                                                <input name ="searchInput" type="text" value="${SearchText}" class="form-control" placeholder="Search for (name,author,isbn)..." />
                                            </div>
                                        </div>
                                    </div>
                                   
                                    <div class="col-md-1">
                                        <div class="form-group">
                                            
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <input type="submit" name="submit" id="submit" value="Search" class="btn btn-primary btn-block">
                                    </div>
                                </div>
                            </mvc:form>
                        </div>
                        <div id="car" class="tab-pane fade">
                            <form name="flight" action= "${pageContext.request.contextPath}/findSchedule" method="post" class="colorlib-form">
                                <div class="row">
                                    <div class="col-md-1">
                                        <input type="hidden"  class="btn btn-primary btn-block">
                                    </div>
                                    <div class="col-md-3" >
                                        <div class="form-group" >
                                            <label for="date">From:</label>
                                            <div class="form-field">                             
                                                <select name="airPortStationFrom" type="text" id="airPortStationFrom" class="form-control  " onchange="findDes();" >
                                                    <option value="">Select</option>
                                                    <c:forEach var="airport" items="${airPortList}">
                                                        <option value="${airport.airPortStationId}">${airport.airportName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3">                             
                                        <div class="form-group">
                                            <div class="form-field" id="demo">                             
                                                <label for="date">To:</label>
                                                <select name="airPortStationTo" id="black" class="form-control" >
                                                    <option value="">Select</option>
                                                   <c:forEach var="destination" items="${destinations}">
                                                       <option value="${destination.airPortStationId}">${destination.airportName}</option>
                                                   </c:forEach>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3">
                                        <div class="form-group">
                                            <label for="date">Depart:</label>
                                            <div class="form-field" id="black">
                                                <input name ="depart" type="date"  class="form-control">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-2">
                                        <input type="submit" name="submit" id="submit" value="Find Schedule" class="btn btn-primary btn-block">
                                    </div>
                                </div>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Intro -->

    <div class="intro">
        <div class="container">
            <div class="row">
                <div class="col">
                    <div class="section_title_container text-center">
                        <div class="section_title"><h1>Welcome to Diamond Airline</h1></div>
                        <div class="section_text">Diamond AirLine là một hãng hàng không quốc gia, được thành lập bởi Miss.NGUYEN KHANH BAO TRAM vào ngày 20-10-1998. Ceo là Mr.HO TRONG THANG</div>
                    </div>
                </div>
            </div>
            <div class="row intro_row">

                <!-- Intro Image -->
                <div class="col-lg-6">
                    <div class="intro_image"><img src="${pageContext.request.contextPath}/template/images/vietnamairlines-khuyen-mai-2.jpg" alt="https://unsplash.com/@papao03"></div>
                </div>

                <!-- Intro Content -->
                <div class="col-lg-6 intro_col">
                    <div class="intro_content">
                        <div class="quote"><img src="${pageContext.request.contextPath}/template/images/quote.png" alt=""></div>
                        <div class="intro_text">
                            <p>Tôi đã từng có chuyến bay trải nghiệm bởi hãng hàng không Diamond Airline, đó là một trãi nghiệm vô cùng thú vị. Dịch vụ tại đây rất tốt. Chúng tôi được cung cấp các bữa ăn ngon và được tiếp viên chu đáo ân cần trong từng dịch vụ. Vô cùng hài lòng.</p>
                        </div>
                        <div class="intro_author d-flex flex-row align-items-center justify-content-start">
                            <div class="author_image"><img src="${pageContext.request.contextPath}/template/images/bright.jpg" alt="https://unsplash.com/@onurozkardes"></div>
                            <div class="intro_author_content">
                                <div class="intro_author_name">Bright Vachirawit</div>
                                <div class="intro_author_title">client</div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div id="colorlib-intro" class="intro-img" style="background-image: url(${pageContext.request.contextPath}/template/images/cover-img-1.jpg);" data-stellar-background-ratio="0.5">
        <div class="overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-md-6 animate-box">
                    <div class="intro-desc">
                        <div class="text-salebox">
                            <div class="text-lefts">
                                <div class="sale-box">
                                    <div class="sale-box-top">
                                        <h2 class="number">80</h2>
                                        <span class="sup-1">%</span>
                                        <span class="sup-2">Off</span>
                                    </div>
                                    <h2 class="text-sale">Sale</h2>
                                </div>
                            </div>
                            <div class="text-rights">
                                <h3 class="title">Just hurry up limited offer!</h3>
                                <p>Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
                                <p><a href="#" class="btn btn-primary">Book Now</a> <a href="#" class="btn btn-primary btn-outline">Read more</a></p>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 animate-box">
                    <div class="video-wrap">
                        <div class="video colorlib-video" style="background-image: url(${pageContext.request.contextPath}/template/images/vietnamairlines-khuyen-mai-2.jpg);">
                            <a href="https://www.youtube.com/watch?v=Mi8vioN2Xps" class="popup-vimeo"><i class="icon-video"></i></a>
                            <div class="video-overlay"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div id="colorlib-hotel">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3 text-center colorlib-heading animate-box">
                    <h2>Popular Destination</h2>
                    <p>We love to tell our successful far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 animate-box">
                    <div class="owl-carousel">
                        <c:forEach var="popularDestination" items="${popularDestinationList}">
                            <div class="item">
                                <div class="hotel-entry">
                                    <a href="#" class="hotel-img" style="background-image: url(${pageContext.request.contextPath}/template/images/popular/${popularDestination.imgPopularDestination});">
                                        <p class="price"><span>$${popularDestination.price}</span></p>
                                    </a>
                                    <div class="desc">
                                        <p class="star"><span><i class="icon-star-full"></i><i class="icon-star-full"></i><i class="icon-star-full"></i><i class="icon-star-full"></i><i class="icon-star-full"></i></span></p>
                                        <h3><a href="#">${popularDestination.tourName}</a></h3>
                                        <span class="place">${popularDestination.place}</span>

                                    </div>
                                </div>
                            </div>

                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>




    <div class="colorlib-tour colorlib-light-grey">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3 text-center colorlib-heading animate-box">
                    <h2>Experience Once In Your Life Time</h2>
                    <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 col-lg-4 mb-4" data-aos="fade-up">
                <div class="d-block ftco-img-flaticon">
                    <img src="template/fonts/flaticon/svg/001-breakfast.svg" alt="Image" class="img-fluid mb-4">
                    <h3>Good Foods</h3>
                    <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
                </div>
            </div>
            <div class="col-md-6 col-lg-4 mb-4" data-aos="fade-up" data-aos-delay="100">
                <div class="d-block ftco-img-flaticon">
                    <img src="template/fonts/flaticon/svg/002-planet-earth.svg" alt="Image" class="img-fluid mb-4">
                    <h3>Travel Anywhere</h3>
                    <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
                </div>
            </div>
            <div class="col-md-6 col-lg-4 mb-4" data-aos="fade-up" data-aos-delay="200">
                <div class="d-block ftco-img-flaticon">
                    <img src="template/fonts/flaticon/svg/003-airplane.svg" alt="Image" class="img-fluid mb-4">
                    <h3>Airplane</h3>
                    <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. </p>
                </div>
            </div>

        </div>
    </div>


    <jsp:include page="footer.jsp" />
</body>
</html>
