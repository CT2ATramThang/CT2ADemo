<?php
	if(!isset($login)){exit();}
?>
<?php 
	include('../connect.php');
	$id= $_GET['id'];
	$sl='select * from menu_ngang where id='.$id;
	$exec= mysqli_query($connect,$sl);
	$row= mysqli_fetch_array($exec);	
?>

<div id="page-wrapper">
    <div class="row">
                 <!--  page header -->
                <div class="col-lg-12">
                    <h1 class="page-header">Quản lý menu ngang - Sửa</h1>
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
                                <form action="?menu=exec_sua_menu_ngang" method="post">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <tr>
                                            <td class="right"><label for="title">Tên menu: </label></td>
                                            <td><input type="hidden" name="id" value="<?php echo $row['id']; ?>"><input type="text" id="title" name="title" value="<?php echo $row['title']; ?>"></td>
                                    </tr>
                                    <tr>
                                            <td class="right"><label for="content">Nội dung: </label></td>
                                            <td><input type="text" id="content" name="content" value="<?php echo $row['content']; ?>"></td>
                                    </tr>
                                    <tr>
                                            <td class="right"><label for="loaimenu">Loại menu: </label></td>
                                            <td><select name="loaimenu" id="loaimenu">
                                                            <option value="none" <?php if($row['loaimenu']== 'none') echo "selected"; ?> >None</option>
                                                            <option value="san_pham" <?php if($row['loaimenu']== 'san_pham') echo "selected"; ?> >Sản Phẩm</option>
                                                            <option value="volkswagen" <?php if($row['loaimenu']== 'volkswagen') echo "selected"; ?> >Volkswagen</option>
                                                            <option value="ford_motor" <?php if($row['loaimenu']== 'ford_motor') echo "selected"; ?> >Ford Motor</option>
                                                            <option value="bmw" <?php if($row['loaimenu']== 'bmw') echo "selected"; ?> >BMW</option>
                                                            <option value="mercedes_benz" <?php if($row['loaimenu']== 'mercedes_benz') echo "selected"; ?> >Mercedes – Benz</option>
                                                            <option value="audi" <?php if($row['loaimenu']== 'audi') echo "selected"; ?> >Audi</option>
                                                            <option value="lexus" <?php if($row['loaimenu']== 'lexus') echo "selected"; ?> >Lexus</option>
                                                            <option value="lamborghini" <?php if($row['loaimenu']== 'lamborghini') echo "selected"; ?> >Lamborghini</option>
                                                    </select>
                                            </td>
                                            
                                    </tr>
                                    <tr>
                                            <td class="right"><input type="submit" name="submit" value="Sửa"></td>
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