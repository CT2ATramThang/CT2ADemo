<?php
	if(!isset($login)){exit();}
	include('../connect.php');
	$sl1= "select * from quan_tri where name='".$_SESSION['username']."'";
	$exec1= mysqli_query($connect, $sl1);
	$row1= mysqli_fetch_array($exec1);
	if($row1['quyen_truy_cap']==1){
?>

<div id="page-wrapper">
    <div class="row">
                 <!--  page header -->
                <div class="col-lg-12">
                    <h1 class="page-header">Quản lý Admin - Thêm</h1>
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
                                <form action="?menu=exec_them_tt_admin" method="post">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <tr>
                                            <td class="right"><label for="name">Username: </label></td>
                                            <td><input type="text" name="name" id="name" required ></td>
                                    </tr>
                                    <tr>
                                            <td class="right"><label for="pass">Password: </label></td>
                                            <td><input type="password" name="pass" id="pass" required ></td>
                                    </tr>
                                    <tr>
                                            <td class="right"><label for="re_pass">Password: </label></td>
                                            <td><input type="password" name="re_pass" id="re_pass" required></td>
                                    </tr>
                                    <tr>
                                            <td class="right"><input type="submit" name="submit" value="Thêm"></td>
                                            </form>
                    <form action="?menu=exec_them_tt_admin" method="post">
                                            <td><input type="submit" name="cancel" value="Hủy"></td>
                                    </tr>
                                </table>
                                </form>
                                <?php }
                                        else{
                                                echo "<script> alert('Bạn không có quyền truy cập vào trang này.'); location.href='?menu=?menu=trang_chu'; </script>";
                                        }
                                ?>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
</div>
</div>