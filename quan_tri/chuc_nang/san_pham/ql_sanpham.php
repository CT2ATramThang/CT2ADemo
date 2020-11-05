<?php
	if(!isset($login)){exit();}
?>

<div id="page-wrapper">
    <div class="row">
                 <!--  page header -->
                <div class="col-lg-12">
                    <h1 class="page-header">Sản phẩm</h1>
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
                                            <th>Tên sản phẩm</th>
                                            <th>Giá sản phẩm</th>
                                            <th>Hình ảnh</th>
                                            <th>Loại sản phẩm</th>
                                            <th width="100px">Chi tiết</th>
                                            <th colspan="2" align="center"><a  style="text-decoration: none; padding: 5px 15px; background-color: #1D388F; color: #fffafa;"  href="?menu=them_sp">Thêm</a></th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <?php 
                                                include('../connect.php');
                                                $sl= "select * from san_pham";
                                                $exec= mysqli_query($connect, $sl);
                                                while($row= mysqli_fetch_array($exec)){
                                        ?>
                                        <tr class="odd gradeX">
                                            <td><?php echo $row['tensp']; ?></td>
                                            <td><?php echo number_format($row['giasp'],0,",",".")."đ"; ?></td>
                                            <td>
                                                    <img src="../images/<?php echo $row['img']; ?>"  width="60px" height="80px" alt="">
                                                    <img src="../images/<?php echo $row['img1']; ?>"  width="60px" height="80px" alt="">
                                                    <img src="../images/<?php echo $row['img2']; ?>"  width="60px" height="80px" alt="">
                                                    <img src="../images/<?php echo $row['img3']; ?>"  width="60px" height="80px" alt="">
                                                    <img src="../images/<?php echo $row['img4']; ?>"  width="60px" height="80px" alt="">
                                            </td>
                                            <td><?php echo $row['loaisp']; ?></td>
                                            <td><a style="text-decoration: none; padding: 5px 15px; background-color: #1D388F; color: #fffafa;"  href="?menu=chi_tiet&masp=<?php echo $row['masp']; ?>">Chi tiết</a></td>
                                            <td><a  style="text-decoration: none; padding: 5px 15px; background-color: #1D388F; color: #fffafa;"  href="?menu=sua_sp&masp=<?php echo $row['masp']; ?>">Sửa</a></td>
                                            <td><a  style="text-decoration: none; padding: 5px 15px; background-color: #1D388F; color: #fffafa;" onclick="return confirm('Bạn có mún xóa không?');" href="?menu=xoa_sp&masp=<?php echo $row['masp']; ?>">Xóa</a></td>
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