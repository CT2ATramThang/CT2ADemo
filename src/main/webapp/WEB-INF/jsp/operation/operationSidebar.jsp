<%-- 
    Document   : setupSidebar
    Created on : Sep 22, 2020, 8:05:33 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Setup Manager</title>
    </head>
    <body>
        <!-- start: sidebar -->
        <aside id="sidebar-left" class="sidebar-left">

            <div class="sidebar-header">
                <div class="sidebar-title">
                    Navigation
                </div>
                <div class="sidebar-toggle hidden-xs" data-toggle-class="sidebar-left-collapsed" data-target="html" data-fire-event="sidebar-left-toggle">
                    <i class="fa fa-bars" aria-label="Toggle sidebar"></i>
                </div>
            </div>

            <div class="nano">
                <div class="nano-content">
                    <nav id="menu" class="nav-main" role="navigation">
                        <ul class="nav nav-main">
                            <li class="nav-active">
                                <a href="${pageContext.request.contextPath}/operation/showOperationPage">
                                    <i class="fa fa-home" aria-hidden="true"></i>
                                    <span>Dashboard</span>
                                </a>
                            </li>
                            
                            <li>
                                <a href="${pageContext.request.contextPath}/listBooking">

                                    <i class="fa fa-table" aria-hidden="true"></i>
                                    <span>Booking</span>
                                </a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/listFlight">

                                    <i class="fa fa-table" aria-hidden="true"></i>
                                    <span>Flight</span>
                                </a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/listFlightRoute">

                                    <i class="fa fa-table" aria-hidden="true"></i>
                                    <span>Flight Route</span>
                                </a>
                            </li>
                            
                            <li>
                                <a href="${pageContext.request.contextPath}/listAircraft">

                                    <i class="fa fa-table" aria-hidden="true"></i>
                                    <span>AirCraft</span>
                                </a>
                            </li>
                            
                            <li>
                                <a href="${pageContext.request.contextPath}/listTicketType">

                                    <i class="fa fa-table" aria-hidden="true"></i>
                                    <span>Ticket Type</span>
                                </a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/listPromotion">

                                    <i class="fa fa-table" aria-hidden="true"></i>
                                    <span>Promotion</span>
                                </a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/listPopularDestination">

                                    <i class="fa fa-table" aria-hidden="true"></i>
                                    <span>Popular Destination</span>
                                </a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/listImageBanner">

                                    <i class="fa fa-file-image-o" aria-hidden="true"></i>
                                    <span>Image Banner</span>
                                </a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/listImagePromotion">

                                    <i class="fa fa-file-image-o" aria-hidden="true"></i>
                                    <span>Image Promotion</span>
                                </a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/listImagePopularDestination">

                                    <i class="fa fa-file-image-o" aria-hidden="true"></i>
                                    <span>Image Popular Destination</span>
                                </a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/report">
                                    
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                    <span>Report</span>
                                </a>
                            </li>
                            <li class="nav-parent">
                                <a>
                                    <i class="fa fa-map-marker" aria-hidden="true"></i>
                                    <span>Maps</span>
                                </a>

                            </li>

                        </ul>
                    </nav>

                </div>

            </div>

        </aside>
        <!-- end: sidebar -->
    </body>
</html>
