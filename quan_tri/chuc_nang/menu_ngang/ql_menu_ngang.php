<?php
	if(!isset($login)){exit();}
?>
<div id="page-wrapper">
    <div class="row">
                 <!--  page header -->
                <div class="col-lg-12">
                    <h1 class="page-header">Quản lý menu ngang</h1>
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
                                            <th>Tên menu</th>
                                            <th>Nội dung</th>
                                            <th>Loại menu</th>
                                            <th colspan="2" align="center"><a href="?menu=them_menu_ngang">Thêm</a></th>
                                            
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <?php 
                                            include('../connect.php');
                                            $sl="select * from menu_ngang";
                                            $exec= mysqli_query($connect,$sl);
                                            while($row= mysqli_fetch_array($exec)){
                                        ?>
                                        <tr class="odd gradeX">
                                            <td><?php echo $row['title']; ?></td>
                                            <td><?php echo $row['content']; ?></td>
                                            <td><?php echo $row['loaimenu']; ?></td>
                                            <td class="center"><a href="?menu=sua_menu_ngang&id=<?php echo $row['id']; ?>">Sửa</a></td>
                                            <td class="center"><a onclick="return confirm('Bạn có mún xóa menu này không?');" href="?menu=xoa_menu_ngang&id=<?php echo $row['id']; ?>">Xóa</a></td>
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