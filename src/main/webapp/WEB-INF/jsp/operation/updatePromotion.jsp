<%-- 
    Document   : updatePromotion
    Created on : Sep 27, 2020, 11:51:31 AM
    Author     : Admin
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Promotion</title>
    </head>
    <body>
        <jsp:include page="operationHeader.jsp" />
        <div class="inner-wrapper">
            <jsp:include page="operationSidebar.jsp" />
            <section role="main" class="content-body">
                <header class="page-header">
                    <h2>Edit Promotion</h2>

                    <div class="right-wrapper pull-right">
                        <ol class="breadcrumbs">
                            <li>
                                <a href="index.html">
                                    <i class="fa fa-home"></i>
                                </a>
                            </li>
                            <li><span>Edit</span></li>
                            <li><span>Promotion</span></li>
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

                                <h2 class="panel-title">Edit Promotion</h2>
                            </header>
                            <div class="panel-body">

                                <mvc:form modelAttribute="promotion" action="${pageContext.request.contextPath}/updatePromotion" class="form-horizontal form-bordered form-bordered" method="post">
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for="inputDisabled">Promotion ID</label>
                                        <div class="col-md-6">
                                            <mvc:input path="promotionId" readonly="true" class="form-control" id="inputDefault" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for="inputDefault">Promotion Name</label>
                                        <div class="col-md-6">

                                            <mvc:input path="promotionName" required="true" class="form-control" id="inputDefault" />
                                        </div>
                                    </div>
                                    
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for="textareaDefault">Description</label>
                                        <div class="col-md-6">
                                            
                                            <mvc:input path="description" required="true" class="form-control" rows="3" />
                                            <p>
                                                <code>max-length</code> set to 140.
                                            </p>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for="inputDisabled">Value Of Promotion</label>
                                        <div class="col-md-6">
                                            <mvc:input path="valueOfPromotion" required="true" class="form-control" id="inputDefault" />
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
