<script type="text/javascript">

    $(document).ready(function() {
        document.title = 'Thành viên';
    });

</script>
<?php 
	include('connect.php');
	$sl= "select * from thanh_vien where username='".$_SESSION['username']."'";
	$exec= mysqli_query($connect, $sl);
	$row = mysqli_fetch_array($exec); 
?>

<div id="page-wrapper">
    
<div class="row">
                <div class="col-lg-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                             Thông tin thành viên
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <tr>
                                            <td><label>Họ và tên: </label></td>
                                            <td><?php echo $row['hoten']; ?></td>
                                    </tr>
                                    <tr>
                                            <td><label>Ngày sinh: </label></td>
                                            <td>
                                                    <?php 
                                                            $ngaysinh= $row['ngaysinh']; 
                                                            $array= explode("-",$ngaysinh);
                                                            $nam= $array[0];
                                                            $thang= $array[1];
                                                            $ngay= $array[2];
                                                            $ngaysinh= $ngay."-".$thang."-".$nam;
                                                            echo $ngaysinh;
                                                    ?>
                                            </td>
                                    </tr>
                                    <tr>
                                            <td><label>Giới tính: </label></td>
                                            <td><?php echo $row['gioitinh']; ?></td>
                                    </tr>
                                    <tr>
                                            <td><label>Giới tính: </label></td>
                                            <td><?php echo $row['gioitinh']; ?></td>
                                    </tr>
                                    <tr>
                                            <td><label>Số CMND: </label></td>
                                            <td><?php echo $row['cmnd']; ?></td>
                                    </tr>
                                    <tr>
                                            <td><label>Địa chỉ: </label></td>
                                            <td>
                                                    <?php 
                                                            echo $row['diachi'];
                                                    ?>				
                                            </td>
                                    </tr>
                                    <tr>
                                            <td><label>Email: </label></td>
                                            <td><?php echo $row['email']; ?></td>
                                    </tr>
                                    <tr>
                                            <td><label>Số điện thoại: </label></td>
                                            <td><?php echo $row['sdt']; ?></td>
                                    </tr>
                                    <tr align="center">
                                            <td colspan="1"><a class="btn btn-primary" href="?menu=sua_tt_thanh_vien">Chỉnh sửa</a></td>
                                            <td colspan="2"><a class="btn btn-primary" href="?menu=change_password">Change Password</a></td>
                                    </tr>
                                </table>
                                
                                
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
</div>
</div>