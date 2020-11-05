<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Bán Hàng</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="font-awesome/css/font-awesome.css">
	<link rel="stylesheet" href="bootstrap/css/bootstrap.css">
	<script src="jquery/jquery.js"></script>
	<script src="bootstrap/js/bootstrap.js"></script>
	<script src="js/ajax.js"></script>
	<script src="js/responsive.js"></script>
	<script src="jquery/jRating.jquery.js"></script>
	<link rel="stylesheet" href="jquery/jRating.jquery.css" type="text/css">
	<link rel="stylesheet" href="css/style.css">
	<link rel="stylesheet" href="css/responsive.css">
        
</head>
<body>

    <div class="container-fluid" style="padding-left: 0px; padding-right: 0px; background-image: url('images/3.jpg');"> 
		<div class="header col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<?php include('header.php'); ?>		
		</div>
		<div class="menu container col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<?php include('navbar.php'); ?>
		</div>
		<div class="slide col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<?php include('slide.php'); ?>
		</div>
		
		<div class="content col-xs-12 col-sm-12 col-md-12 col-lg-12">
			
			<div class="content col-xs-12 col-sm-12 col-md-10 col-lg-10">
				<?php include('content.php'); ?>
			</div>
			<div class="right col-xs-12 col-sm-12 col-md-2 col-lg-2">
				<?php include('right.php'); ?>
			</div>
		</div>
		<div class="footer col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<?php include('footer.php'); ?>		
		</div>
	</div>
</body>
</html>