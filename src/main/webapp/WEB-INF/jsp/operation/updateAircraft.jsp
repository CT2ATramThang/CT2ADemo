<%-- 
    Document   : updateAircraft
    Created on : Sep 26, 2020, 8:07:25 PM
    Author     : Admin
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Aircraft</title>
    </head>
    <body>
        <jsp:include page="operationHeader.jsp" />
        <div class="inner-wrapper">
            <jsp:include page="operationSidebar.jsp" />
            <section role="main" class="content-body">
                <header class="page-header">
                    <h2>Edit Aircraft</h2>

                    <div class="right-wrapper pull-right">
                        <ol class="breadcrumbs">
                            <li>
                                <a href="index.html">
                                    <i class="fa fa-home"></i>
                                </a>
                            </li>
                            <li><span>Edit</span></li>
                            <li><span>Aircraft</span></li>
                        </ol>

                        <a class="sidebar-right-toggle" data-open="sidebar-right"><i class="fa fa-chevron-left"></i></a>
                    </div>
                </header>

                <!-- start: page -->
                <div class="row">
                    <div class="col-lg-12">
                        <section class="panel">
                            <header class="panel-heading">
                                <div class="panel-actions">
                                    <a href="#" class="fa fa-caret-down"></a>
                                    <a href="#" class="fa fa-times"></a>
                                </div>

                                <h2 class="panel-title">Edit Aircraft</h2>
                            </header>
                            <div class="panel-body">

                                <mvc:form modelAttribute="aircraft" action="${pageContext.request.contextPath}/updateAircraft" class="form-horizontal form-bordered" method="post">
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for="inputDefault">Aircraft ID</label>
                                        <div class="col-md-6">

                                            <mvc:input path="aircraftId" readonly="true"  class="form-control" id="inputDefault" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for="inputDefault">Air Number</label>
                                        <div class="col-md-6">

                                            <mvc:input path="airNumber" required="true" class="form-control" id="inputDefault" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for="inputDisabled">Number Of Commercial Seats</label>
                                        <div class="col-md-6">
                                            <mvc:input path="numberOfCommercialSeats" required="true" class="form-control" id="inputDefault" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for="inputReadOnly">Number Of VIP</label>
                                        <div class="col-md-6">
                                            <mvc:input path="numberOfVIP" required="true" class="form-control" id="inputDefault" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label"></label>
                                        <div class="col-md-6 col-xs-11">                                    
                                            <input type="submit" class="btn btn-sm btn-primary" data-plugin-colorpicker data-color-format="hex" data-color="rgb(255, 255, 255)" value="Save" />
                                        </div>
                                    </div>
                                </mvc:form>
                            </div>
                        </section>
                    </div>
                </div>

                <!-- end: page -->
            </section>
        </div>
        <jsp:include page="operationFooter.jsp" />
    </body>
</html>
