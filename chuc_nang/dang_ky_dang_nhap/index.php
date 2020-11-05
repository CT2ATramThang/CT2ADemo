<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Captcha</title>
	<link rel="stylesheet" href="">
        <style>
            body {font-family: Arial, Helvetica, sans-serif;}

            /* Full-width input fields */
            input[type=text], input[type=password] {
              width: 100%;
              padding: 12px 20px;
              margin: 8px 0;
              display: inline-block;
              border: 1px solid #ccc;
              box-sizing: border-box;
            }

            /* Set a style for all buttons */
            button {
              background-color: #4CAF50;
              color: white;
              padding: 14px 20px;
              margin: 8px 0;
              border: none;
              cursor: pointer;
              width: 100%;
            }

            button:hover {
              opacity: 0.8;
            }

            /* Extra styles for the cancel button */
            .cancelbtn {
              width: auto;
              padding: 10px 18px;
              background-color: #f44336;
            }

            /* Center the image and position the close button */
            .imgcontainer {
              text-align: center;
              margin: 24px 0 12px 0;
              position: relative;
            }

            img.avatar {
              width: 40%;
              border-radius: 50%;
            }

            .container {
              padding: 16px;
            }

            span.psw {
              float: right;
              padding-top: 16px;
            }

            /* The Modal (background) */
            .modal {
              display: none; /* Hidden by default */
              position: fixed; /* Stay in place */
              z-index: 1; /* Sit on top */
              left: 0;
              top: 0;
              width: 100%; /* Full width */
              height: 100%; /* Full height */
              overflow: auto; /* Enable scroll if needed */
              background-color: rgb(0,0,0); /* Fallback color */
              background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
              padding-top: 60px;
            }

            /* Modal Content/Box */
            .modal-content {
              background-color: #fefefe;
              margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
              border: 1px solid #888;
              width: 80%; /* Could be more or less, depending on screen size */
            }

            /* The Close Button (x) */
            .close {
              position: absolute;
              right: 25px;
              top: 0;
              color: #000;
              font-size: 35px;
              font-weight: bold;
            }

            .close:hover,
            .close:focus {
              color: red;
              cursor: pointer;
            }

            /* Add Zoom Animation */
            .animate {
              -webkit-animation: animatezoom 0.6s;
              animation: animatezoom 0.6s
            }

            @-webkit-keyframes animatezoom {
              from {-webkit-transform: scale(0)} 
              to {-webkit-transform: scale(1)}
            }

            @keyframes animatezoom {
              from {transform: scale(0)} 
              to {transform: scale(1)}
            }

            /* Change styles for span and cancel button on extra small screens */
            @media screen and (max-width: 300px) {
              span.psw {
                 display: block;
                 float: none;
              }
              .cancelbtn {
                 width: 100%;
              }
            }
        </style>
</head>
<body>
	<?php
		session_start();
		if(isset($_POST['submit'])){
			$value= $_POST['value'];
			if($value== $_SESSION['captcha']){
				$message="Correct Captcha";
			}
			else{
				$message="Incorrect Captcha";
			}
		}
	?>
	<h1>Tạo Captcha</h1>
	<form action="" method="post">
		<table>
			<tr>
				<td><img src="captcha.php" alt=""></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="text" name="value" placeholder="Nhập captcha.."></td>
				<td><?php if(isset($message)){
					echo $message;
					} ?></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Submit"></td>
				<td></td>
			</tr>
		</table>
	</form>
</body>
</html>