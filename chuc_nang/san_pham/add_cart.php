<?php
	$masp = $_GET['masp'];
	$soluong= $_GET['soluong'];
	$sp= 0;
	if(isset($_SESSION['giohang'][$masp])){
		$sp= $_SESSION['giohang'][$masp] + $soluong;
	}
	else{
		$sp= $soluong;
	}
	$_SESSION['giohang'][$masp]=$sp;
	echo "<script> alert('Thêm vào giỏ hàng thành công'); location.href='?menu=san_pham'; </script>"
?>