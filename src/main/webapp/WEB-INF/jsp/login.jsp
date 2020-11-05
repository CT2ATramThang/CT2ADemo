<%-- 
    Document   : sellerLogin
    Created on : Sep 19, 2020, 7:20:44 PM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="manifest" href="site.webmanifest">
        <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico">

        <!-- CSS here -->
        <link rel="stylesheet" href="${pageContext.request.contextPath}/login/assets/css/bootstrap.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/login/assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/login/assets/css/slicknav.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/login/assets/css/flaticon.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/login/assets/css/progressbar_barfiller.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/login/assets/css/gijgo.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/login/assets/css/animate.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/login/assets/css/animated-headline.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/login/assets/css/magnific-popup.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/login/assets/css/fontawesome-all.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/login/assets/css/themify-icons.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/login/assets/css/slick.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/login/assets/css/nice-select.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/login/assets/css/style.css">
    </head>
    <body>



        <main class="login-body" data-vide-bg="${pageContext.request.contextPath}/login/assets/img/login-bg.mp4">
            <!-- Login Admin -->
            <form class="form-default" action="j_spring_security_check" method="post">

                <div class="login-form">
                    <!-- logo-login -->
                    <div class="logo-login">
                        <a href="${pageContext.request.contextPath}/homePage"><img src="${pageContext.request.contextPath}/login/assets/img/logo/loder.png" alt=""></a>
                    </div>
                    <h2>Login Here</h2>
                    <div class="form-input">
                        <label for="name">Email</label>
                        <input  type="text" name="username" placeholder="Email">
                    </div>
                    <div class="form-input">
                        <label for="name">Password</label>
                        <input type="password" name="password" placeholder="Password">
                    </div>
                    <div class="form-input pt-30">
                        <input type="submit" name="submit" value="login">
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </div>
            </form>
            <c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION}">
                <p style="color:red;">Error:
                    <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/></p>
                </c:if> 
            <!-- /end login form -->
        </main>

        <script src="${pageContext.request.contextPath}/login/assets/js/vendor/modernizr-3.5.0.min.js"></script>
        <!-- Jquery, Popper, Bootstrap -->
        <script src="${pageContext.request.contextPath}/login/assets/js/vendor/jquery-1.12.4.min.js"></script>
        <script src="${pageContext.request.contextPath}/login/assets/js/popper.min.js"></script>
        <script src="${pageContext.request.contextPath}/login/assets/js/bootstrap.min.js"></script>
        <!-- Jquery Mobile Menu -->
        <script src="${pageContext.request.contextPath}/login/assets/js/jquery.slicknav.min.js"></script>

        <!-- Video bg -->
        <script src="${pageContext.request.contextPath}/login/assets/js/jquery.vide.js"></script>

        <!-- Jquery Slick , Owl-Carousel Plugins -->
        <script src="${pageContext.request.contextPath}/login/assets/js/owl.carousel.min.js"></script>
        <script src="${pageContext.request.contextPath}/login/assets/js/slick.min.js"></script>
        <!-- One Page, Animated-HeadLin -->
        <script src="${pageContext.request.contextPath}/login/assets/js/wow.min.js"></script>
        <script src="${pageContext.request.contextPath}/login/assets/js/animated.headline.js"></script>
        <script src="${pageContext.request.contextPath}/login/assets/js/jquery.magnific-popup.js"></script>

        <!-- Date Picker -->
        <script src="${pageContext.request.contextPath}/login/assets/js/gijgo.min.js"></script>
        <!-- Nice-select, sticky -->
        <script src="${pageContext.request.contextPath}/login/assets/js/jquery.nice-select.min.js"></script>
        <script src="${pageContext.request.contextPath}/login/assets/js/jquery.sticky.js"></script>
        <!-- Progress -->
        <script src="${pageContext.request.contextPath}/login/assets/js/jquery.barfiller.js"></script>

        <!-- counter , waypoint,Hover Direction -->
        <script src="${pageContext.request.contextPath}/login/assets/js/jquery.counterup.min.js"></script>
        <script src="${pageContext.request.contextPath}/login/assets/js/waypoints.min.js"></script>
        <script src="${pageContext.request.contextPath}/login/assets/js/jquery.countdown.min.js"></script>
        <script src="${pageContext.request.contextPath}/login/assets/js/hover-direction-snake.min.js"></script>

        <!-- contact js -->
        <script src="${pageContext.request.contextPath}/login/assets/js/contact.js"></script>
        <script src="${pageContext.request.contextPath}/login/assets/js/jquery.form.js"></script>
        <script src="${pageContext.request.contextPath}/login/assets/js/jquery.validate.min.js"></script>
        <script src="${pageContext.request.contextPath}/login/assets/js/mail-script.js"></script>
        <script src="${pageContext.request.contextPath}/login/assets/js/jquery.ajaxchimp.min.js"></script>

        <!-- Jquery Plugins, main Jquery -->	
        <script src="${pageContext.request.contextPath}/login/assets/js/plugins.js"></script>
        <script src="${pageContext.request.contextPath}/login/assets/js/main.js"></script>
    </body>
</html>
