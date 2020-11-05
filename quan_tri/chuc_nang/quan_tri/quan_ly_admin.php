<?php
	if(!isset($login)){exit();}
	include('../connect.php');
	$sl1= "select * from quan_tri where name='".$_SESSION['user']."'";
	$exec1= mysqli_query($connect, $sl1);
	$row1= mysqli_fetch_array($exec1);
	if($row1['quyen_truy_cap']==1){
?>

<div id="page-wrapper">
    <div class="row">
                 <!--  page header -->
                <div class="col-lg-12">
                    <h1 class="page-header">Quản lý Admin</h1>
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
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                        <tr>
                                            <th>Username</th>
                                            <th>Password</th>
                                            <th colspan="2" align="center"><a href="?menu=them_tt_admin">Thêm</a></th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <?php
                                                $sl= "select * from quan_tri";
                                                $exec= mysqli_query($connect, $sl);
                                                while($row= mysqli_fetch_array($exec)){
                                        ?>
                                        <tr class="odd gradeX">
                                            <td><?php echo $row['name']; ?></td>
                                            <td><?php echo $row['pass']; ?></td>
                                            <td><a href="?menu=sua_tt_admin&id=<?php echo $row['id']; ?>">Sửa</a></td>
                                            <td><a onclick="return confirm('Bạn chắc chắn mún xóa không?');" href="?menu=xoa_tt_admin&id=<?php echo $row['id']; ?>">Xóa</a></td>
                                        </tr>
                                        <?php } ?>
                                        
                                    </tbody>
                                </table>
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