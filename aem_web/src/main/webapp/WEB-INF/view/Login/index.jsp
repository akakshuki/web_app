<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Aptech | Sign in</title>
<!-- Tell the browser to be responsive to screen width -->
<link rel="icon" href="favicon.ico" type="image/x-icon">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet"
	href="lib/bootstrap/dist/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="lib/font-awesome/css/font-awesome.min.css">
<!-- Ionicons -->
<%-- <link rel="stylesheet"
	href="lib/Ionicons/css/ionicons.min.css"> --%>
<!-- Theme style -->
<link rel="stylesheet" href="dist/css/AdminLTE.min.css">
<!-- Material Design -->
<link rel="stylesheet"
	href="dist/css/bootstrap-material-design.min.css">
<link rel="stylesheet" href="dist/css/ripples.min.css">
<link rel="stylesheet" href="dist/css/MaterialAdminLTE.min.css">
<link rel="stylesheet" href="dist/css/app/login.css">
<!-- iCheck -->
<!-- <link rel="stylesheet" href="../../plugins/iCheck/square/blue.css"> -->

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

<!-- Google Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>

<body class="hold-transition login-page" id="wrap-login">
	<div class="row">
		<div class="col-lg-6" id="bg-logo">
			<img src="dist/img/main_login.jpg" alt="">
		</div>
		<div class="col-lg-6">
			<div id="wrap-form">
				<div class="login-logo">
					Aptech Education <i class="fa fa-home"></i><br> <span>Sign
						In</span>
				</div>
				<div class="login-box-body">
					<form action="index.html" method="post">
						<div class="form-group has-feedback">
							<input type="text" class="form-control form-login"
								placeholder="Email" required> <span
								class="glyphicon glyphicon-envelope form-control-feedback form-login"></span>
						</div>
						<div class="form-group has-feedback">
							<input type="password" class="form-control form-login"
								placeholder="Password" required> <span
								class="glyphicon glyphicon-lock form-control-feedback form-login"></span>
						</div>
						<div class="form-group">
							<select class="form-control form-login" style="width: 100%;"
								id="type" name="type" required>
								<option value="">Đăng nhập quyền?</option>
								<option value="1">Sinh Viên</option>
								<option value="2">Giảng Viên</option>
								<option value="3">Nhân Viên</option>
							</select>
						</div>
						<div class="form-group">
							<button type="submit"
								class="btn btn-primary btn-raised btn-block btn-flat">Sign
								In</button>
						</div>
					</form>
				</div>
			</div>

		</div>
	</div>
	<!-- /.login-box -->

	<!-- jQuery 3 -->
	<script src="lib/jquery/dist/jquery.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script
		src="lib/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- Material Design -->
	<script src="dist/js/material.min.js"></script>
	<script src="dist/js/ripples.min.js"></script>
	<script>
		// $.material.init();
	</script>
	<!-- iCheck -->
	<!-- <script src="../../plugins/iCheck/icheck.min.js"></script> 
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' /* optional */
    });
  });
  </script>-->
</body>

</html>