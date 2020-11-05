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
                                <a href="${pageContext.request.contextPath}/admin/showAdminPage">
                                    <i class="fa fa-home" aria-hidden="true"></i>
                                    <span>Dashboard</span>
                                </a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/listUsers">
                                    
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                    <span>Users</span>
                                </a>
                            </li>
                            
                            <li>
                                <a href="${pageContext.request.contextPath}/listUserRoles">
                                    
                                    <i class="fa fa-envelope" aria-hidden="true"></i>
                                    <span>User Role</span>
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
