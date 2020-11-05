<?php
if (!isset($login)) {
    exit();
}
?>
<!--  page-wrapper -->
<div id="page-wrapper">

    <div class="row">
        <!-- Page Header -->
        <div class="col-lg-12">
            <h1 class="page-header">Trang chủ</h1>
        </div>
        <!--End Page Header -->
    </div>

    <div class="row">
        <!-- Welcome -->
        <div class="col-lg-12">
            <div class="alert alert-info">
                <i class="fa fa-folder-open"></i><b>&nbsp;Hello ! </b>Welcome Back <b>Miusumi </b>
                <i class="fa  fa-pencil"></i><b>&nbsp;2,000 </b>Support Tickets Pending to Answere. nbsp;
            </div>
        </div>
        <!--end  Welcome -->
    </div>


    <div class="row">
        <!--quick info section -->
        <div class="col-lg-3">
            <div class="alert alert-danger text-center">
                <i class="fa fa-calendar fa-3x"></i>&nbsp;<b>20 </b>Meetings Sheduled This Month

            </div>
        </div>
        <div class="col-lg-3">
            <div class="alert alert-success text-center">
                <i class="fa  fa-beer fa-3x"></i>&nbsp;<b>27 % </b>Profit Recorded in This Month  
            </div>
        </div>
        <div class="col-lg-3">
            <div class="alert alert-info text-center">
                <i class="fa fa-rss fa-3x"></i>&nbsp;<b>1,900</b> New Subscribers This Year

            </div>
        </div>
        <div class="col-lg-3">
            <div class="alert alert-warning text-center">
                <i class="fa  fa-pencil fa-3x"></i>&nbsp;<b>2,000 $ </b>Payment Dues For Rejected Items
            </div>
        </div>
        <!--end quick info section -->
    </div>

    <div class="row">
        <div class="col-lg-8">

            <!--Simple table example -->
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <i class="fa fa-bar-chart-o fa-fw"></i>Simple Table Example

                </div>

                <div class="panel-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover table-striped">
                                    <thead>
                                        <tr>
                                            <th>Thêm mới</th>
                                            <th>Quản lý</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td><p><a href="?menu=them_sp">Thêm sản phẩm</a></p></td>
                                            <td><p><a href="?menu=ql_sanpham">Quản lý sản phẩm</a></p></td>

                                        </tr>
                                        <tr>
                                            <td><p><a href="?menu=them_menu_ngang">Thêm menu ngang</a></p></td>
                                            <td><p><a href="?menu=ql_menu_ngang">Quản lý menu ngang</a></p></td>

                                        </tr>
                                        <tr>
                                            <td><p><a href="?menu=them_menu_doc">Thêm menu dọc</a></p></td>
                                            <td><p><a href="?menu=ql_menu_doc">Quản lý menu dọc</a></p></td>

                                        </tr>
                                        <tr>
                                            <td><p><a href="?menu=them_tt_admin">Thêm người quản trị</a></p></td>
                                            <td><p><a href="?menu=quan_ly_admin">Quản lý đăng nhập quản trị</a></p></td>

                                        </tr>
                                        <tr>
                                            <td><p><a href="?menu=them_anh_slide">Thêm ảnh vào slideshow</a></p></td>
                                            <td><p><a href="?menu=ql_slideshow">Quản lý ảnh slideshow</a></p></td>

                                        </tr>


                                    </tbody>
                                </table>
                            </div>

                        </div>

                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.panel-body -->
            </div>
            <!--End simple table example -->
            <!--Area chart example -->
            <div class="panel panel-primary">
                <div class="panel-heading">
                    <i class="fa fa-bar-chart-o fa-fw"></i>Area Chart Example

                </div>

                <div class="panel-body">
                    <div id="morris-area-chart"></div>
                </div>

            </div>
            <!--End area chart example -->
        </div>

        <div class="col-lg-4">
            <div class="panel panel-primary text-center no-boder">
                <div class="panel-body yellow">
                    <i class="fa fa-bar-chart-o fa-3x"></i>
                    <h3>20,741 </h3>
                </div>
                <div class="panel-footer">
                    <span class="panel-eyecandy-title">Daily User Visits
                    </span>
                </div>
            </div>
            <div class="panel panel-primary text-center no-boder">
                <div class="panel-body blue">
                    <i class="fa fa-pencil-square-o fa-3x"></i>
                    <h3>2,060 </h3>
                </div>
                <div class="panel-footer">
                    <span class="panel-eyecandy-title">Pending Orders Found
                    </span>
                </div>
            </div>
            <div class="panel panel-primary text-center no-boder">
                <div class="panel-body green">
                    <i class="fa fa fa-floppy-o fa-3x"></i>
                    <h3>20 GB</h3>
                </div>
                <div class="panel-footer">
                    <span class="panel-eyecandy-title">New Data Uploaded
                    </span>
                </div>
            </div>
            <div class="panel panel-primary text-center no-boder">
                <div class="panel-body red">
                    <i class="fa fa-thumbs-up fa-3x"></i>
                    <h3>2,700 </h3>
                </div>
                <div class="panel-footer">
                    <span class="panel-eyecandy-title">New User Registered
                    </span>
                </div>
            </div>

        </div>

    </div>

</div>
<!--End Chat Panel Example-->
</div>
</div>


</div>
<!-- end page-wrapper -->

</div>
<!-- end wrapper -->

<!-- Core Scripts - Include with every page -->
<script src="assets/plugins/jquery-1.10.2.js"></script>
<script src="assets/plugins/bootstrap/bootstrap.min.js"></script>
<script src="assets/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="assets/plugins/pace/pace.js"></script>
<script src="assets/scripts/siminta.js"></script>
<!-- Page-Level Plugin Scripts-->
<script src="assets/plugins/morris/raphael-2.1.0.min.js"></script>
<script src="assets/plugins/morris/morris.js"></script>
<script src="assets/scripts/dashboard-demo.js"></script>