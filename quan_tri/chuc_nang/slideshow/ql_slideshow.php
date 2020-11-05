<?php
	if(!isset($login)){exit();}
?>

<div id="page-wrapper">
    <div class="row">
                 <!--  page header -->
                <div class="col-lg-12">
                    <h1 class="page-header">Slideshow</h1>
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
                                            <th>Tên file</th>
                                            <th>Hình ảnh</th>
                                            <th>Ghi chú</th>
                                            <th colspan="2" align="center"><a href="?menu=them_anh_slide">Thêm</a></th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <?php
                                                include('../connect.php');
                                                $sl= "select * from slideshow";
                                                $exec = mysqli_query($connect,$sl);
                                                while($row= mysqli_fetch_array($exec)){
                                        ?>
                                        <tr class="odd gradeX">
                                            <td><?php echo $row['name']; ?></td>
                                            <td><img src="../images/slideshow/<?php echo $row['name']; ?>" width="360px" height="150px" alt=""></td>
                                            <td><?php echo $row['note']; ?></td>
                                            <td><a href="?menu=sua_anh_slide&id=<?php echo $row['id']; ?>">Sửa</a></td>
                                            <td><a onclick="return confirm('Bạn có mún xóa ảnh này?');" href="?menu=xoa_anh_slide&id=<?php echo $row['id']; ?>">Xóa</a></td>
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