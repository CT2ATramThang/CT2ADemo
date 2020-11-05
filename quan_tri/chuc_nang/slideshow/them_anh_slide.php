<?php
	if(!isset($login)){exit();}
?>
<form action="?menu=exec_them_anh_slide" method="post" enctype="multipart/form-data">
	<table>
		<tr>
			<td><label for="image">Hình ảnh: </label></td>
			<td><input type="file" name="image" id="image"></td>
		</tr>
		<tr>
			<td><label for="note">Ghi chú</label></td>
			<td>
				<select name="note" id="note">
					<option value="">None</option>
					<option value="active">Active</option>	
				</select>
			</td>
		</tr>
		<tr>
			<td><input type="submit" name="submit" value="Thêm"></td>
			<td><input type="submit" name="cancel" value="Hủy"></td>
		</tr>
	</table>
</form>
<div id="page-wrapper">
    <div class="row">
                 <!--  page header -->
                <div class="col-lg-12">
                    <h1 class="page-header">Slideshow - Thêm</h1>
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
                                <form action="?menu=exec_them_anh_slide" method="post" enctype="multipart/form-data">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <tr>
                                            <td><label for="image">Hình ảnh: </label></td>
                                            <td><input type="file" name="image" id="image"></td>
                                    </tr>
                                    <tr>
                                            <td><label for="note">Ghi chú</label></td>
                                            <td>
                                                    <select name="note" id="note">
                                                            <option value="">None</option>
                                                            <option value="active">Active</option>	
                                                    </select>
                                            </td>
                                    </tr>
                                    <tr>
                                            <td><input type="submit" name="submit" value="Thêm"></td>
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