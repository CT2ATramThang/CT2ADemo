<%-- 
    Document   : setupFlight
    Created on : Sep 19, 2020, 10:28:36 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Setup Flight</title>
        
    </head>
    <body>
        <jsp:include page="adminHeader.jsp" />
        <div class="inner-wrapper">
            <jsp:include page="adminSidebar.jsp" />
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
                                                    <h4 class="title">Users</h4>
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
                                                    <h4 class="title">User Role</h4>
                                                    <div class="info">
                                                        <strong class="amount">${count1}</strong>
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
 
                <!-- end: page -->
            </section>
            <jsp:include page="adminFooter.jsp" />
    </body>
</html>
