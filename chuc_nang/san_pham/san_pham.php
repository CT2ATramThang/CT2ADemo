<div class="panel panel-primary" style="margin-top: 10px;">
      <div class="panel-heading" id="mesce">Mescedes</div>
      <div class="panel-body">
<div class="product">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" id="product">
	<?php
	include('connect.php');
	$sl= 'select * from san_pham where loaisp="mercedes_benz" limit 0,4';
	$exec= mysqli_query($connect, $sl);
	while($row= mysqli_fetch_array($exec)){
?>
	<div class="sp img-thumbnail col-xs-12 col-sm-6 col-md-6 col-lg-3">
		<div class="img img-thumbnail col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<a href="?menu=product_info&masp=<?php echo $row['masp']; ?>"><img src="images/<?php echo $row['img']; ?>" alt=""></a>
		</div>
		<div class="title">
			<a href="?menu=product_info&masp=<?php echo $row['masp']; ?>"><?php echo $row['tensp']; ?></a>
		</div>
		<div class="cost">
			<span><?php echo number_format($row['giasp'],0,",",".")."USD"; ?></span>
		</div>
		<div class="buy">
			<a class="btn btn-primary" id="mesce" href="?menu=product_info&masp=<?php echo $row['masp']; ?>">Chi tiết</a>
			<a class="btn btn-warning" href="?menu=addcart&masp=<?php echo $row['masp']; ?>&soluong=1"><b class="fa fa-cart-plus"></b></a>
		</div>
	</div>
<?php }
?>
	<div class="text-center">
		<a href="?menu=mercedes" class="text-center btn btn-default">Xem thêm</a>
	</div>
	</div>

</div>
</div>
</div>
<div class="panel panel-primary">
      <div class="panel-heading" id="mesce">BMW</div>
      <div class="panel-body">
<div class="product">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" id="product">
	<?php
	include('connect.php');
	$sl= 'select * from san_pham where loaisp="bmw" limit 0,4';
	$exec= mysqli_query($connect, $sl);
	while($row= mysqli_fetch_array($exec)){
?>
	<div class="sp img-thumbnail col-xs-12 col-sm-6 col-md-6 col-lg-3">
		<div class="img img-thumbnail col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<a href="?menu=product_info&masp=<?php echo $row['masp']; ?>"><img src="images/<?php echo $row['img']; ?>" alt=""></a>
		</div>
		<div class="title">
			<a href="?menu=product_info&masp=<?php echo $row['masp']; ?>"><?php echo $row['tensp']; ?></a>
		</div>
		<div class="cost">
			<span><?php echo number_format($row['giasp'],0,",",".")."USD"; ?></span>
		</div>
		<div class="buy">
			<a class="btn btn-primary" id="mesce" href="?menu=product_info&masp=<?php echo $row['masp']; ?>">Chi tiết</a>
			<a class="btn btn-warning" href="?menu=addcart&masp=<?php echo $row['masp']; ?>&soluong=1"><b class="fa fa-cart-plus"></b></a>
		</div>
	</div>
<?php }
?>
	<div class="text-center">
		<a href="?menu=bmw" class="text-center btn btn-default">Xem thêm</a>
	</div>
	</div>

</div>
</div>
</div>
<div class="panel panel-primary">
      <div class="panel-heading" id="mesce">Volkswagen</div>
      <div class="panel-body">
<div class="product">
	<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" id="product">
	<?php
	include('connect.php');
	$sl= 'select * from san_pham where loaisp="volkswagen" limit 0,4';
	$exec= mysqli_query($connect, $sl);
	while($row= mysqli_fetch_array($exec)){
?>
	<div class="sp img-thumbnail col-xs-12 col-sm-6 col-md-6 col-lg-3">
		<div class="img img-thumbnail col-xs-12 col-sm-12 col-md-12 col-lg-12">
			<a href="?menu=product_info&masp=<?php echo $row['masp']; ?>"><img src="images/<?php echo $row['img']; ?>" alt=""></a>
		</div>
		<div class="title">
			<a href="?menu=product_info&masp=<?php echo $row['masp']; ?>"><?php echo $row['tensp']; ?></a>
		</div>
		<div class="cost">
			<span><?php echo number_format($row['giasp'],0,",",".")."USD"; ?></span>
		</div>
		<div class="buy">
			<a class="btn btn-primary" id="mesce" href="?menu=product_info&masp=<?php echo $row['masp']; ?>">Chi tiết</a>
			<a class="btn btn-warning" href="?menu=addcart&masp=<?php echo $row['masp']; ?>&soluong=1"><b class="fa fa-cart-plus"></b></a>
		</div>
	</div>
<?php }
?>		
	<div class="text-center">
		<a href="?menu=volkswagen" class="text-center btn btn-default">Xem thêm</a>
	</div>
	</div>

</div>
</div>
</div>