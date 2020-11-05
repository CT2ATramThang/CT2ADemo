<?php
	if(!isset($login)){exit();}
?>

<div id="page-wrapper">
    <div class="row">
                 <!--  page header -->
                <div class="col-lg-12">
                    <h1 class="page-header">Quản lý menu dọc - Thêm</h1>
                </div>
                 <!-- end  page header -->
            </div>
<div class="row">
                <div class="col-lg-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             Advanced Tables
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <form action="?menu=exec_them_menu_doc" method="post">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <tr>
                                            <td class="right"><label for="title">Tên menu: </label></td>
                                            <td><input type="text" id="title" name="title"></td>
                                    </tr>
                                    <tr>
                                            <td class="right"><label for="sub_1">Sub_Menu 1:</label></td>
                                            <td><input type="text" id="sub_1" name="sub_1"></td>
                                    </tr>
                                    <tr>
                                            <td class="right"><label for="sub_1_kink">Sub_Menu 1 (link):</label></td>
                                            <td><input type="text" id="sub_1_link" name="sub_1_link"></td>
                                    </tr>
                                    <tr>
                                            <td class="right"><label for="sub_2">Sub_Menu 1:</label></td>
                                            <td><input type="text" id="sub_2" name="sub_2"></td>
                                    </tr>
                                    <tr>
                                            <td class="right"><label for="sub_2_kink">Sub_Menu 2 (link):</label></td>
                                            <td><input type="text" id="sub_2_link" name="sub_2_link"></td>
                                    </tr>
                                    <tr>
                                            <td class="right"><input type="submit" name="submit" value="Thêm"></td>
                                            <td><input type="submit" name="cancel" value="Hủy"></td>
                                    </tr>
                                </table>
                                </form>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
</div>
</div>