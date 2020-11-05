<%-- 
    Document   : updateImagePopularDestination
    Created on : Oct 15, 2020, 1:25:20 PM
    Author     : Admin
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Image Popular Destination</title>
    </head>
    <body>
        <jsp:include page="operationHeader.jsp" />
        <div class="inner-wrapper">
            <jsp:include page="operationSidebar.jsp" />
            <section role="main" class="content-body">
                <header class="page-header">
                    <h2>Update Image Popular Destination</h2>

                    <div class="right-wrapper pull-right">
                        <ol class="breadcrumbs">
                            <li>
                                <a href="index.html">
                                    <i class="fa fa-home"></i>
                                </a>
                            </li>
                            <li><span>Image</span></li>
                            <li><span>Popular Destination</span></li>
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

                                <h2 class="panel-title">Update Image Popular Destination</h2>
                            </header>
                            <div class="panel-body">

                                <mvc:form modelAttribute="imagePopularDestination" action="${pageContext.request.contextPath}/updateImagePopularDestination" class="form-horizontal form-bordered" method="post">
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for="inputDefault">Popular Destination ID</label>
                                        <div class="col-md-6">

                                            <mvc:input  path="popularDestinationId" readonly="true" class="form-control" id="inputDefault" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for="inputDefault">Tour Name</label>
                                        <div class="col-md-6">

                                            <mvc:input  path="tourName" readonly="true" class="form-control" id="inputDefault" />
                                        </div>
                                    </div>
                                            <mvc:input  path="place" type="hidden" readonly="true" class="form-control" id="inputDefault" />
                                            <mvc:input  path="price" type="hidden" readonly="true" class="form-control" id="inputDefault" />
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for="inputDefault">Image Popular Destination</label>
                                        <div class="col-md-6">

                                            <mvc:input path="imgPopularDestination" type="file" required="true" class="fileupload-preview" id="inputDefault" />
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-3 control-label"></label>
                                        <div class="col-md-6 col-xs-11">                                    
                                            <input type="submit" name="save" class="btn btn-sm btn-primary" data-plugin-colorpicker data-color-format="hex" data-color="rgb(255, 255, 255)" value="Save" />
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
