<%-- 
    Document   : setupFooter
    Created on : Sep 20, 2020, 7:36:58 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Setup Manager</title>
        <meta name="author" content="JSOFT.net">
    </head>
    <body>
        <aside id="sidebar-right" class="sidebar-right">
            <div class="nano">
                <div class="nano-content">
                    <a href="#" class="mobile-close visible-xs">
                        Collapse <i class="fa fa-chevron-right"></i>
                    </a>

                    <div class="sidebar-right-wrapper">

                        <div class="sidebar-widget widget-calendar">
                            <h6>Upcoming Tasks</h6>
                            <div data-plugin-datepicker data-plugin-skin="dark" ></div>

                            <ul>
                                <li>
                                    <time datetime="2014-04-19T00:00+00:00">04/19/2014</time>
                                    <span>Company Meeting</span>
                                </li>
                            </ul>
                        </div>

                        <div class="sidebar-widget widget-friends">
                            <h6>Friends</h6>
                            <ul>
                                <li class="status-online">
                                    <figure class="profile-picture">
                                        <img src="assets/images/!sample-user.jpg" alt="Joseph Doe" class="img-circle">
                                    </figure>
                                    <div class="profile-info">
                                        <span class="name">Joseph Doe Junior</span>
                                        <span class="title">Hey, how are you?</span>
                                    </div>
                                </li>
                                <li class="status-online">
                                    <figure class="profile-picture">
                                        <img src="assets/images/!sample-user.jpg" alt="Joseph Doe" class="img-circle">
                                    </figure>
                                    <div class="profile-info">
                                        <span class="name">Joseph Doe Junior</span>
                                        <span class="title">Hey, how are you?</span>
                                    </div>
                                </li>
                                <li class="status-offline">
                                    <figure class="profile-picture">
                                        <img src="assets/images/!sample-user.jpg" alt="Joseph Doe" class="img-circle">
                                    </figure>
                                    <div class="profile-info">
                                        <span class="name">Joseph Doe Junior</span>
                                        <span class="title">Hey, how are you?</span>
                                    </div>
                                </li>
                                <li class="status-offline">
                                    <figure class="profile-picture">
                                        <img src="assets/images/!sample-user.jpg" alt="Joseph Doe" class="img-circle">
                                    </figure>
                                    <div class="profile-info">
                                        <span class="name">Joseph Doe Junior</span>
                                        <span class="title">Hey, how are you?</span>
                                    </div>
                                </li>
                            </ul>
                        </div>

                    </div>
                </div>
            </div>
        </aside>
    </section>

    <!-- Vendor -->
    <script src="${pageContext.request.contextPath}/assets/vendor/jquery/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/jquery-browser-mobile/jquery.browser.mobile.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/nanoscroller/nanoscroller.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/magnific-popup/magnific-popup.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/jquery-placeholder/jquery.placeholder.js"></script>

    <!-- Specific Page Vendor -->
    <script src="${pageContext.request.contextPath}/assets/vendor/jquery-ui/js/jquery-ui-1.10.4.custom.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/jquery-ui-touch-punch/jquery.ui.touch-punch.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/jquery-appear/jquery.appear.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/bootstrap-multiselect/bootstrap-multiselect.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/jquery-easypiechart/jquery.easypiechart.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/flot/jquery.flot.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/flot-tooltip/jquery.flot.tooltip.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/flot/jquery.flot.pie.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/flot/jquery.flot.categories.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/flot/jquery.flot.resize.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/jquery-sparkline/jquery.sparkline.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/raphael/raphael.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/morris/morris.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/gauge/gauge.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/snap-svg/snap.svg.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/liquid-meter/liquid.meter.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/jqvmap/jquery.vmap.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/jqvmap/data/jquery.vmap.sampledata.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/jqvmap/maps/jquery.vmap.world.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/jqvmap/maps/continents/jquery.vmap.africa.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/jqvmap/maps/continents/jquery.vmap.asia.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/jqvmap/maps/continents/jquery.vmap.australia.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/jqvmap/maps/continents/jquery.vmap.europe.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/jqvmap/maps/continents/jquery.vmap.north-america.js"></script>
    <script src="${pageContext.request.contextPath}/assets/vendor/jqvmap/maps/continents/jquery.vmap.south-america.js"></script>

    <!-- Theme Base, Components and Settings -->
    <script src="${pageContext.request.contextPath}/assets/javascripts/theme.js"></script>

    <!-- Theme Custom -->
    <script src="${pageContext.request.contextPath}/assets/javascripts/theme.custom.js"></script>

    <!-- Theme Initialization Files -->
    <script src="${pageContext.request.contextPath}/assets/javascripts/theme.init.js"></script>


    <!-- Examples -->
    <script src="${pageContext.request.contextPath}/assets/javascripts/dashboard/examples.dashboard.js"></script>
</body>
</html>
