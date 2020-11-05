<script type="text/javascript">

    $(document).ready(function () {
        document.title = 'Đăng nhập';
    });

</script>


<div class="panel panel-primary" style="border-color: #a94442">
    <div class="panel-heading" style="background-color: #a94442">Đăng nhập</div>
    <div class="panel-body" style="background-color: rgba(0, 0, 0, .075);">
    <p class="alert alert-warning"><strong>Lưu ý: </strong>Các thông tin có dấu <span style="color: red;">(*)</span> đều là bắt buộc.</p>
    <form action="?menu=exec_dang_ky" method="post" role="form" data-toggle="validator">
	<table class="table">
		<tr>
			<td><label for="user">Tên đăng nhập: </label></td>
			<td><input  class="form-control" type="text" name="username" id="user" placeholder="Nhập tên đăng nhập.." required ></td>
		</tr>
		<tr>
			<td><label for="pass">Mật khẩu:</label></td>
			<td><input  class="form-control" type="password" name="password" id="pass" placeholder="Nhập mật khẩu.." required ></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" name="submit" class="btn btn-primary" value="Đăng nhập"></td>
		</tr>
	</table>
</form>
</div>
</div>
