<%-- 
    Document   : thanks
    Created on : Oct 14, 2020, 10:56:51 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            .code{
                width: 400px;
                height: 40px;
                background-color: black;
                font-size: 150%;
            }
        </style>
    </head>
    <body>
        <jsp:include page="paymentHeader.jsp" />
            <section id="colorlib-subscribe" style="background-image: url(${pageContext.request.contextPath}/template/images/checkBooking.jpg);" data-stellar-background-ratio="0.5">
            <div class="container">
               <div class="row">
                <div class="col">
                    <div class="section_title_container text-center">
                        <div class="section_title" style="color: white; text-align: center"><h1>
                        Thank you so much for using DIAMOND AIRLINE service.</h1></div>
                        <div class="section_text">In vitae nisi aliquam, scelerisque leo a, volutpat sem. Vivamus rutrum dui fermentum eros hendrerit, id lobortis leo volutpat. Maecenas sollicitudin est in libero pretium interdum.</div>
                        <div style="color: white;">Mã số booking của bạn là : </div>
                        <div><button class="code">${codeBooking}</button></div>
                        <div>Bạn có muốn <a href="${pageContext.request.contextPath}/homepage">TIẾP TỤC ?</a></div>
                    </div>
                </div>
            </div> 
            </div>
            </section>
        <jsp:include page="paymentFooter.jsp" />
    </body>
</html>
