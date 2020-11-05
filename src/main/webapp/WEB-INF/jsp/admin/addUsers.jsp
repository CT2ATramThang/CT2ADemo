<%-- 
    Document   : addUsers
    Created on : Oct 29, 2020, 9:38:57 AM
    Author     : Admin
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Users</title>
    </head>
    <body>
        <jsp:include page="adminHeader.jsp" />
        <div class="inner-wrapper">
            <jsp:include page="adminSidebar.jsp" />
            <section role="main" class="content-body">
                <header class="page-header">
                    <h2>Add Users</h2>

                    <div class="right-wrapper pull-right">
                        <ol class="breadcrumbs">
                            <li>
                                <a href="index.html">
                                    <i class="fa fa-home"></i>
                                </a>
                            </li>
                            <li><span>Add</span></li>
                            <li><span>Users</span></li>
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

                                <h2 class="panel-title">Add Users</h2>
                            </header>
                            <div class="panel-body">

                                <mvc:form modelAttribute="users" action="${pageContext.request.contextPath}/addUsers" class="form-horizontal form-bordered" method="post">
                                      
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for="inputDefault">User Name</label>
                                        <div class="col-md-6">
                                            <mvc:input path="userName" required="true" class="form-control" id="inputDefault" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for="inputDisabled">Password</label>
                                        <div class="col-md-6">
                                            <mvc:input path="password" type="password" required="true" class="form-control" id="inputDefault" />
                                        </div>
                                    
                                    </div>
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for="inputDisabled">Enabled</label>
                                        <div class="col-md-6">
                                            <mvc:input path="enabled"  required="true" class="form-control" id="inputDefault" />
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
        <jsp:include page="adminFooter.jsp" />
    </body>
</html>
