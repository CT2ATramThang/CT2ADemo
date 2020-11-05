<%-- 
    Document   : listImageBanner
    Created on : Oct 12, 2020, 10:07:22 PM
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
        <title>List Image Banner</title>
    </head>
    <body>
        <jsp:include page="operationHeader.jsp" />
        <div class="inner-wrapper">
            <jsp:include page="operationSidebar.jsp" />
            <section role="main" class="content-body">
                <header class="page-header">
                    <h2>List Image Banner</h2>

                    <div class="right-wrapper pull-right">
                        <ol class="breadcrumbs">
                            <li>
                                <a href="index.html">
                                    <i class="fa fa-home"></i>
                                </a>
                            </li>
                            <li><span>Image</span></li>
                            <li><span>Banner</span></li>
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

                        <h2 class="panel-title">Banner</h2>
                    </header>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="mb-md">
                                    <a href="${pageContext.request.contextPath}/addImageBanner"><button id="addToTable" class="btn btn-primary">Add <i class="fa fa-plus"></i></button></a>
                                </div>
                            </div>
                        </div>
                        <jsp:useBean id="pagedListHolder" scope="request"
                                     type="org.springframework.beans.support.PagedListHolder" />
                        <c:url value="/listImageBanner" var="pagedLink">
                            <c:param name="p" value="~" />
                        </c:url>
                        <tg:paging pagedListHolder="${pagedListHolder}"
                                   pagedLink="${pagedLink}" />

                        <table class="table table-bordered table-striped mb-none" id="datatable-default">
                            <thead>
                                <tr>
                                    <th>Image Banner ID</th>
                                    <th>Image Name</th>                                   
                                    <th>&nbsp;</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="banner" items="${pagedListHolder.pageList}">
                                    <tr class="gradeX">
                                        <td>${banner.imgId}</td>
                                        <td><img src="${pageContext.request.contextPath}/template/images/banner/${banner.imgName}" style="width: 400px; height: 200px;"></td>
                                        <td class="actions">

                                            <a href="${pageContext.request.contextPath}/editImageBanner/${banner.imgId}" class="on-default edit-row"><i class="fa fa-pencil"></i></a>
                                                <%--<a href="${pageContext.request.contextPath}/deleteImageBanner/${banner.imgId}" class="on-default remove-row"><i class="fa fa-trash-o"></i></a>--%>
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
