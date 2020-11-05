<?php
	include('connect.php');
	if(isset($_POST['submit'])){
	$tenkh= $_POST['tenkh'];
	$cmnd= $_POST['cmnd'];
	$email= $_POST['email'];
	$sdt= $_POST['sdt'];
	$diachi= $_POST['diachi'];
if(isset($_SESSION['username'])){
	$sp_mua=$_POST['sp_mua'];
	$list_id= $_POST['list_id'];
}
else{
	$xaphuong = $_POST['xaphuong'];
	$sqll= "select ward.type as wardtype, ward.name as wardname , district.type as districttype, district.name districtname, province.type  as provincetype, province.name as provincename from province join district on province.provinceid=district.provinceid join ward on ward.districtid=district.districtid where ward.wardid='".$xaphuong."'";
	$exc= mysqli_query($connect,$sqll);
	$row1= mysqli_fetch_array($exc); 
	$diachi= $diachi.", ".$row1['wardtype']." ".$row1['wardname'].", ".$row1['districttype']." ".$row1['districtname'].", ".$row1['provincetype']." ".$row1['provincename'];
	foreach($_SESSION['giohang'] as $masp=> $sp){
		$id_array[]= $masp;
		}
	$list_id= implode(',',$id_array);
	$sl= 'select * from san_pham where masp in ('.$list_id.')';
	$exec= mysqli_query($connect, $sl);
	$sp_mua="";
	while($row= mysqli_fetch_array($exec)){
		$soluong= $_SESSION['giohang'][$row['masp']];
		$gia_sp=$row['giasp'];
		$sp_mua= $sp_mua.$row['masp'].",".$soluong.",".$gia_sp."|";		
	}
}
	$sql1= "insert into hoa_don(cmnd,tenkh,email,sdt,dia_chi,sp_mua,xu_ly) values('".$cmnd."','".$tenkh."','".$email."','".$sdt."','".$diachi."','".$sp_mua."','Chưa')";
	$exec1= mysqli_query($connect,$sql1);
		if($exec1){
	$sql= "update san_pham set mua_nhieu=mua_nhieu + 1 where masp in (".$list_id.")";
	$ex= mysqli_query($connect, $sql);
			unset($_SESSION['giohang']);
		echo '<p class="alert alert-success">Mua hàng thành công.. Vui lòng kiểm tra mail của bạn và luôn giữ liên lạc khi nhân viên giao hàng liên hệ..</p>';
		echo '<p class="alert alert-success">Bấm <a href="?menu=san_pham">vào đây</a> để quay lại mua hàng tiếp</p>';
	}
	else{
		echo "<script> alert('Mua hàng không thành công'); location.href='?menu=san_pham'; </script>";
	}
}
else{
	echo "<script> location.href='index.php'; </script>";
}
?>