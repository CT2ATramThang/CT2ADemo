<%-- 
    Document   : promotion
    Created on : Oct 11, 2020, 11:16:46 PM
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
        <title>Promotion</title>
    </head>
    <body>
        <jsp:include page="${pageContext.request.contextPath}/../WEB-INF/jsp/header.jsp" />
        <aside id="colorlib-hero">
            <div class="flexslider">
                <ul class="slides">
                    <li style="background-image: url(${pageContext.request.contextPath}/template/images/cover-img-2.jpg);">
                        <div class="overlay"></div>
                        <div class="container-fluid">
                            <div class="row">
                                <div class="col-md-6 col-md-offset-3 col-sm-12 col-xs-12 slider-text">
                                    <div class="slider-text-inner text-center">

                                        <h1>Promotion</h1>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </aside>

        <div id="colorlib-blog">
            <div class="container">
                <div class="row">
                    <div class="col-md-8">
                        <jsp:useBean id="pagedListHolder" scope="request"
                                     type="org.springframework.beans.support.PagedListHolder" />
                        <c:url value="/promotion" var="pagedLink">
                            <c:param name="p" value="~" />
                        </c:url>


                        <div class="wrap-division">
                            <c:forEach var="promotion" items="${pagedListHolder.pageList}">
                                <article class="animate-box">
                                    <div class="blog-img" style="background-image: url(${pageContext.request.contextPath}/template/images/promotion/${promotion.imagePromotion});"></div>
                                    <div class="desc">

                                        <h2><a href="${pageContext.request.contextPath}/promotion">${promotion.promotionName}</a></h2>
                                        <p>${promotion.description}</p>
                                    </div>
                                </article>
                            </c:forEach>

                            <div class="row">
                                <div class="col-md-12">
                                    <ul class="pagination">
                                        <li><tg:paging pagedListHolder="${pagedListHolder}"
                                                   pagedLink="${pagedLink}" /></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-4">
                        <div class="sidebar-wrap">
                            <div class="side animate-box">
                                <h3 class="sidebar-heading">Recent Post</h3>
                                <c:forEach var="promotion" items="${pagedListHolder.pageList}">
                                    <div class="blog-entry-side">
                                        <a href="${pageContext.request.contextPath}/promotion" class="blog-post">
                                            <span class="img" style="background-image: url(${pageContext.request.contextPath}/template/images/promotion/${promotion.imagePromotion});"></span>
                                            <div class="desc">
                                                <span class="date"></span>
                                                <h3>${promotion.promotionName}</h3>
                                                <span class="cat"></span>
                                            </div>
                                        </a>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="side animate-box">
                                <div class="sidebar-heading">Categories</div>
                                <ul class="category">                                    
                                    <li><a href="#"><i class="icon-check"></i> Flight<span>(2)</span></a></li>
                                    <li><a href="#"><i class="icon-check"></i> Hotel<span>(5)</span></a></li>
                                    <li><a href="#"><i class="icon-check"></i> Tour<span>(2)</span></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <jsp:include page="${pageContext.request.contextPath}/../WEB-INF/jsp/footer.jsp" />
    </body>
</html>
