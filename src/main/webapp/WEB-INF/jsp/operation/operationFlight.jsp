<%-- 
    Document   : setupFlight
    Created on : Sep 19, 2020, 10:28:36 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Setup Flight</title>

    </head>
    <body>
        <jsp:include page="operationHeader.jsp" />
        <div class="inner-wrapper">
            <jsp:include page="operationSidebar.jsp" />
            <section role="main" class="content-body">
                <header class="page-header">
                    <h2>Dashboard</h2>

                    <div class="right-wrapper pull-right">
                        <ol class="breadcrumbs">
                            <li>
                                <a href="index.html">
                                    <i class="fa fa-home"></i>
                                </a>
                            </li>
                            <li><span>Dashboard</span></li>
                        </ol>

                        <a class="sidebar-right-toggle" data-open="sidebar-right"><i class="fa fa-chevron-left"></i></a>
                    </div>
                </header>



                <div class="row">
                    <div class="col-md-6 col-lg-12 col-xl-6">
                        <div class="row">
                            <div class="col-md-12 col-lg-6 col-xl-6">
                                <section class="panel panel-featured-left panel-featured-primary">
                                    <div class="panel-body">
                                        <div class="widget-summary">
                                            <div class="widget-summary-col widget-summary-col-icon">
                                                <div class="summary-icon bg-primary">
                                                    <i class="fa fa-life-ring"></i>
                                                </div>
                                            </div>
                                            <div class="widget-summary-col">
                                                <div class="summary">
                                                    <h4 class="title">Ticket Available</h4>
                                                    <div class="info">
                                                        <strong class="amount">${count2}</strong>

                                                    </div>
                                                </div>
                                                <div class="summary-footer">
                                                    <a class="text-muted text-uppercase">(view all)</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </section>
                            </div>
                            <div class="col-md-12 col-lg-6 col-xl-6">
                                <section class="panel panel-featured-left panel-featured-secondary">
                                    <div class="panel-body">
                                        <div class="widget-summary">
                                            <div class="widget-summary-col widget-summary-col-icon">
                                                <div class="summary-icon bg-secondary">
                                                    <i class="fa fa-usd"></i>
                                                </div>
                                            </div>
                                            <div class="widget-summary-col">
                                                <div class="summary">
                                                    <h4 class="title">Total</h4>
                                                    <div class="info">
                                                        <strong class="amount">$ ${sum}</strong>
                                                    </div>
                                                </div>
                                                <div class="summary-footer">
                                                    <a class="text-muted text-uppercase">(withdraw)</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </section>
                            </div>
                            <div class="col-md-12 col-lg-6 col-xl-6">
                                <section class="panel panel-featured-left panel-featured-tertiary">
                                    <div class="panel-body">
                                        <div class="widget-summary">
                                            <div class="widget-summary-col widget-summary-col-icon">
                                                <div class="summary-icon bg-tertiary">
                                                    <i class="fa fa-shopping-cart"></i>
                                                </div>
                                            </div>
                                            <div class="widget-summary-col">
                                                <div class="summary">
                                                    <h4 class="title">Booking</h4>
                                                    <div class="info">
                                                        <strong class="amount">${count1}</strong>
                                                    </div>
                                                </div>
                                                <div class="summary-footer">
                                                    <a class="text-muted text-uppercase">(statement)</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </section>
                            </div>
                            <div class="col-md-12 col-lg-6 col-xl-6">
                                <section class="panel panel-featured-left panel-featured-quartenary">
                                    <div class="panel-body">
                                        <div class="widget-summary">
                                            <div class="widget-summary-col widget-summary-col-icon">
                                                <div class="summary-icon bg-quartenary">
                                                    <i class="fa fa-user"></i>
                                                </div>
                                            </div>
                                            <div class="widget-summary-col">
                                                <div class="summary">
                                                    <h4 class="title">Customer</h4>
                                                    <div class="info">
                                                        <strong class="amount">${count}</strong>
                                                    </div>
                                                </div>
                                                <div class="summary-footer">
                                                    <a class="text-muted text-uppercase">(report)</a>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </section>
                            </div>
                        </div>
                    </div>
                </div>

                <script>

                    var flotDashSales1Data = [{
                            data: [
                                ["Jan", 140],
                                ["Feb", 240],
                                ["Mar", 190],
                                ["Apr", 140],
                                ["May", 180],
                                ["Jun", 320],
                                ["Jul", 270],
                                ["Aug", 180]
                            ],
                            color: "#0088cc"
                        }];

                    // See: assets/javascripts/dashboard/examples.dashboard.js for more settings.

                </script>
                <script>

                    var flotDashSales2Data = [{
                            data: [
                                ["Jan", 240],
                                ["Feb", 240],
                                ["Mar", 290],
                                ["Apr", 540],
                                ["May", 480],
                                ["Jun", 220],
                                ["Jul", 170],
                                ["Aug", 190]
                            ],
                            color: "#2baab1"
                        }];

                    // See: assets/javascripts/dashboard/examples.dashboard.js for more settings.

                </script>
                <script>

                    var flotDashSales3Data = [{
                            data: [
                                ["Jan", 840],
                                ["Feb", 740],
                                ["Mar", 690],
                                ["Apr", 940],
                                ["May", 1180],
                                ["Jun", 820],
                                ["Jul", 570],
                                ["Aug", 780]
                            ],
                            color: "#734ba9"
                        }];

                    // See: assets/javascripts/dashboard/examples.dashboard.js for more settings.

                </script>
                <script type="text/javascript">
                    var sparklineBarDashData = [5, 6, 7, 2, 0, 4, 2, 4, 2, 0, 4, 2, 4, 2, 0, 4];
                </script>
                <script type="text/javascript">
                    var sparklineLineDashData = [15, 16, 17, 19, 10, 15, 13, 12, 12, 14, 16, 17];
                </script>

                <div class="row">
                    <div class="col-lg-6 col-md-12">
                        <section class="panel panel-transparent">
                            
                        </section>
                    </div>
                    <div class="col-lg-6 col-md-12">
                        <section class="panel">
                            <header class="panel-heading panel-heading-transparent">
                                <div class="panel-actions">
                                    <a href="#" class="fa fa-caret-down"></a>
                                    <a href="#" class="fa fa-times"></a>
                                </div>

                                <h2 class="panel-title">Booking One Month</h2>
                            </header>
                            <div class="panel-body">
                                <div class="table-responsive">
                                    <jsp:useBean id="pagedListHolder" scope="request"
                                                 type="org.springframework.beans.support.PagedListHolder" />
                                    <c:url value="/operation/showOperationPage" var="pagedLink">
                                        <c:param name="p" value="~" />
                                    </c:url>
                                    <table class="table table-striped mb-none">
                                        <thead>
                                            <tr>

                                                <th>Code</th>
                                                <th>Date</th>
                                                <th>Customer</th>
                                                <th>Amount</th>                                                

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="booking" items="${pagedListHolder.pageList}">
                                                <tr>
                                                    <td>${booking.codeBooking}</td>
                                                    <td>${booking.dateBooking}</td>
                                                    <td>${booking.customer.customerFirstName}</td>
                                                    <td>${booking.total}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                    <tg:paging pagedListHolder="${pagedListHolder}"
                                   pagedLink="${pagedLink}" />
                                </div>
                            </div>
                        </section>
                    </div>
                </div>
                <!-- end: page -->
            </section>
            <jsp:include page="operationFooter.jsp" />
    </body>
</html>
