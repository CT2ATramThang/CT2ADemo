<%-- 
    Document   : listTicket
    Created on : Oct 26, 2020, 10:23:51 PM
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
        <title>List Ticket</title>
    </head>
    <body>
        <jsp:include page="operationHeader.jsp" />
        <div class="inner-wrapper">
            <jsp:include page="operationSidebar.jsp" />
            <section role="main" class="content-body">
                <header class="page-header">
                    <h2>List Ticket</h2>

                    <div class="right-wrapper pull-right">
                        <ol class="breadcrumbs">
                            <li>
                                <a href="index.html">
                                    <i class="fa fa-home"></i>
                                </a>
                            </li>
                            <li><span>List</span></li>
                            <li><span>Ticket</span></li>
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

                        <h2 class="panel-title">Ticket</h2>
                    </header>
                    <div class="panel-body">


                        <jsp:useBean id="pagedListHolder" scope="request"
                                     type="org.springframework.beans.support.PagedListHolder" />
                        <c:url value="/viewTicket" var="pagedLink">
                            <c:param name="p" value="~" />
                        </c:url>

                        <tg:paging pagedListHolder="${pagedListHolder}"
                                   pagedLink="${pagedLink}" />
                        <table class="table table-bordered table-striped mb-none" id="datatable-default">

                            <thead>
                                <tr>

                                    <th>Ticket ID</th>
                                    <th>Ticket Name</th>
                                    <th>Price</th>
                                    <th>Name Of The Flier</th>
                                    <th>Child Day Of Birth</th>
                                    <th>CMND</th>
                                    <th>ticket Issue Date</th>
                                    <th>Ticket Type</th>

                                    <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="ticket" items="${pagedListHolder.pageList}">
                                    <tr class="gradeX">
                                        <td>${ticket.ticketId}</td>
                                        <td>${ticket.ticketName}</td>
                                        <td>${ticket.price}</td>
                                        <td>${ticket.nameOfTheFlyer}</td>
                                        <td>${ticket.childDateOfBirth}</td>
                                        <td>${ticket.cmnd}</td>
                                        <td>${ticket.ticketIssueDate}</td>
                                        <td>${ticket.ticketType.type}</td>
                                        <td class="actions">
                                            <a href="${pageContext.request.contextPath}/deleteTicket/${ticket.ticketId}" class="on-default remove-row"><i class="fa fa-trash-o"></i></a>
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
