<%-- 
    Document   : listAirCraft
    Created on : Sep 24, 2020, 9:45:19 PM
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
        <title>List Report</title>
    </head>
    <body>
        <jsp:include page="operationHeader.jsp" />
        <div class="inner-wrapper">
            <jsp:include page="operationSidebar.jsp" />
            <section role="main" class="content-body">
                <header class="page-header">
                    <h2>List Report</h2>

                    <div class="right-wrapper pull-right">
                        <ol class="breadcrumbs">
                            <li>
                                <a href="index.html">
                                    <i class="fa fa-home"></i>
                                </a>
                            </li>
                            <li><span>Report</span></li>
                            <li><span>Booking</span></li>
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

                        <h2 class="panel-title">Report</h2>
                    </header>
                    <div class="panel-body">
                        <div class="row">
                            <mvc:form  class="colorlib-form"  action= "${pageContext.request.contextPath}/reportByBookDate" method="get" >
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label for="date">From Day:</label>
                                        <div class="form-field" >

                                            <input name ="startDay" type="date" class="form-control">
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-group">
                                        <label for="date">TO DAY:</label>
                                        <div class="form-field">

                                            <input name ="endDay" type="date"  class="form-control" >
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <input type="submit" name="submit" id="submit" value="search" >
                                </div>
                            </mvc:form>
                        </div>
                        <jsp:useBean id="pagedListHolder" scope="request"
                                     type="org.springframework.beans.support.PagedListHolder" />
                        <c:url value="/report" var="pagedLink">
                            <c:param name="p" value="~" />
                        </c:url>

                        <tg:paging pagedListHolder="${pagedListHolder}"
                                   pagedLink="${pagedLink}" />
                        <table class="table table-bordered table-striped mb-none" id="datatable-editable">
                            <thead>
                                <tr>
                                    <th>Booking ID</th>
                                    <th>Code Booking</th>
                                    <th>Date Booking</th>
                                    <th>Customer Booking</th>
                                    <th>Amount</th>

                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="booking" items="${pagedListHolder.pageList}">
                                    <tr class="gradeX">
                                        <td>${booking.bookingId}</td>
                                        <td>${booking.codeBooking}</td>
                                        <td>${booking.dateBooking}</td>
                                        <td>${booking.customer.customerFirstName}</td>
                                        <td>${booking.total}</td>


                                    </tr>
                                </c:forEach>
                                <tr>
                                    <td colspan="4"> Total: <span>$ ${sum}</span></td>
                                    <td><spring:url value="/report1/?type=xls" var="xlsURL"/>
                                        <a href="${xlsURL}">Download Excel</a></td>
                                </tr>
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
