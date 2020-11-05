<%-- 
    Document   : listFlight
    Created on : Sep 26, 2020, 3:07:11 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Flight</title>
    </head>
    <body>
        <jsp:include page="operationHeader.jsp" />
        <div class="inner-wrapper">
            <jsp:include page="operationSidebar.jsp" />
            <section role="main" class="content-body">
                <header class="page-header">
                    <h2>List Flight</h2>

                    <div class="right-wrapper pull-right">
                        <ol class="breadcrumbs">
                            <li>
                                <a href="index.html">
                                    <i class="fa fa-home"></i>
                                </a>
                            </li>
                            <li><span>List</span></li>
                            <li><span>Flight</span></li>
                        </ol>

                        <a class="sidebar-right-toggle" data-open="sidebar-right"><i class="fa fa-chevron-left"></i></a>
                    </div>
                </header>

                <!-- start: page -->
                <section class="panel">
                    <header class="panel-heading">
                        <div class="panel-actions">
                            <a href="#" class="fa fa-caret-down"></a>
                            <a href="#" class="fa fa-times"></a>
                        </div>

                        <h2 class="panel-title">Flight</h2>
                    </header>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="mb-md">
                                    <a href="${pageContext.request.contextPath}/setupFlight"><button id="addToTable" class="btn btn-primary">Add <i class="fa fa-plus"></i></button></a>
                                </div>
                            </div>
                        </div>
                        <form action="${pageContext.request.contextPath}/searchFlight" method="get"> <%-- tất cả các jsp về controller đều pahir có đường link ${pageContext.request.contextPath}--%>
                            <div class="input-group" >
                                <input name ="searchFlight" type="date" value="${searchFlight}" class="form-control" placeholder="Search" />
                                <span class="input-group-btn">
                                    <button class="btn btn-primary" type="submit">Search</button>
                                </span>
                            </div> 
                        </form>
                        <jsp:useBean id="pagedListHolder" scope="request"
                                     type="org.springframework.beans.support.PagedListHolder" />
                        <c:url value="/listFlight" var="pagedLink">
                            <c:param name="p" value="~" />
                        </c:url>
                        <tg:paging pagedListHolder="${pagedListHolder}"
                                   pagedLink="${pagedLink}" />
                        
                        <table class="table table-bordered table-striped mb-none" id="datatable-default">
                            <thead>
                                <tr>
                                    <th>Flight ID</th>
                                    <th>Flight Date</th>
                                    <th>Flight Time From</th>
                                    <th>Flight Time To</th>
                                    <th>Flight Route</th>
                                    <th>Aircraft</th>
                                    <th>Promotion</th>
                                    <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>       
                                <c:forEach var="flight" items="${pagedListHolder.pageList}">
                                    <tr class="gradeX">
                                        <td>${flight.flightId}</td>
                                        <td>${flight.flightDate}</td>
                                        <td>${flight.flightTimeFrom}</td>
                                        <td>${flight.flightTimeTo}</td>
                                        <td>${flight.flightRoute.airPortStationFrom.airportName} -> ${flight.flightRoute.airPortStationTo.airportName}</td>
                                        <td>${flight.aircraft.airNumber}</td>
                                        <td>${flight.promotion.promotionName}</td>
                                        <td class="actions">
                                            <a href="#" class="hidden on-editing save-row"><i class="fa fa-save"></i></a>
                                            <a href="#" class="hidden on-editing cancel-row"><i class="fa fa-times"></i></a>
                                            <a href="${pageContext.request.contextPath}/editFlight/${flight.flightId}" class="on-default edit-row"><i class="fa fa-pencil"></i></a>
                                            <a href="${pageContext.request.contextPath}/deleteFlight/${flight.flightId}" class="on-default remove-row"><i class="fa fa-trash-o"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <tg:paging pagedListHolder="${pagedListHolder}"
                                   pagedLink="${pagedLink}" />
                    </div>
                </section>
                <!-- end: page -->
            </section>
        </div>
        <jsp:include page="operationFooter.jsp" />
    </body>
</html>
