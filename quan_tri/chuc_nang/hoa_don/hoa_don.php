<?php
	if(!isset($login)){exit();}
?>

<div id="page-wrapper">
    <div class="row">
                 <!--  page header -->
                <div class="col-lg-12">
                    <h1 class="page-header">Hóa đơn</h1>
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
                                            <th>Mã hóa đơn</th>
                                            <th>Tên khách hàng</th>
                                            <th>Ngày mua</th>
                                            <th>Xử lý</th>
                                            <th>Xóa</th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <?php 
                                                include('../connect.php');
                                                $sl="select * from hoa_don";
                                                $exec= mysqli_query($connect, $sl);
                                                while($row=mysqli_fetch_array($exec)){ 
                                        ?>
                                        <tr class="odd gradeX">
                                            <td><?php echo $row['ma_hoadon']; ?></td>
                                            <td><a href="?menu=chi_tiet_hoa_don&ma_hoadon=<?php echo $row['ma_hoadon']; ?>"><?php echo $row['tenkh']; ?></a></td>
                                            <td><?php echo $row['ngay_mua']; ?></td>
                                            <td><?php echo $row['xu_ly']; ?></td>
                                            <td><a  style="text-decoration: none; padding: 5px 15px; background-color: #1D388F; color: #fffafa;" onclick="return confirm('Bạn có mún xóa hóa đơn?');" href="?menu=xoa&ma_hoadon=<?php echo $row['ma_hoadon']; ?>">Xóa</a></td>
                                        </tr>
                                        <?php } ?>
                                        
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
</div>
</div>