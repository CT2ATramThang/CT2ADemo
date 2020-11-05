<?php
	if(!isset($login)){exit();}
?>

<div id="page-wrapper">
    <div class="row">
                 <!--  page header -->
                <div class="col-lg-12">
                    <h1 class="page-header">Quản lý menu ngang - Thêm</h1>
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
                                <form action="?menu=exec_them_menu_ngang" method="post">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <tr>
                                            <td class="right"><label for="title">Tên menu: </label></td>
                                            <td><input type="text" id="title" name="title"></td>
                                    </tr>
                                    <tr>
                                            <td class="right"><label for="content">Nội dung: </label></td>
                                            <td><input type="text" id="content" name="content"></td>
                                    </tr>
                                    <tr>
                                            <td class="right"><label for="loaimenu">Loại menu: </label></td>
                                            <td><select name="loaimenu" id="loaimenu">
                                                            <option value="none">None</option>
                                                            <option value="san_pham">Sản Phẩm</option>
                                                            <option value="volkswagen">Volkswagen</option>
                                                            <option value="ford_motor">Ford Motor</option>
                                                            <option value="bmw">BMW</option>
                                                            <option value="mercedes_benz">Mercedes – Benz</option>
                                                            <option value="audi">Audi</option>
                                                            <option value="lexus">Lexus</option>
                                                            <option value="lamborghini">Lamborghini</option>
                                                    </select>
                                            </td>
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