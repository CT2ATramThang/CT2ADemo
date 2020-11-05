
<?php
	include('connect.php');
	$sl= "select * from thanh_vien where username='".$_SESSION['username']."'";
	$exec= mysqli_query($connect, $sl);
	$row= mysqli_fetch_array($exec);
?>


<table class="table">
	<tr>
		<td><p style="padding-left: 2px;font-weight: bold;">KH: <a href="?menu=thanh_vien" style=""><?php echo $row['hoten']; ?></a></p></td>
	</tr>
	
	<tr>
		<td><p style="text-align: center;"><a href="?menu=logout">Đăng xuất</a></p></td>
	</tr>
</table>
</div>
