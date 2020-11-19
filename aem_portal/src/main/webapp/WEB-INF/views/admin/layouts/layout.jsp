<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Aptech Education Management</title>
	<link rel="icon" href="/admin/favicon.ico" type="image/x-icon">

	<link rel="stylesheet" href="/admin/bower_components/bootstrap/dist/css/bootstrap.min.css">
	<!-- Font Awesome -->
	<link rel="stylesheet" href="/admin/bower_components/font-awesome/css/font-awesome.min.css">
	<!-- Ionicons -->
	<link rel="stylesheet" href="/admin/bower_components/Ionicons/css/ionicons.min.css">
	<!-- Theme style -->
	<link rel="stylesheet" href="/admin/dist/css/AdminLTE.min.css">
	<!-- Material Design -->
	<link rel="stylesheet" href="/admin/dist/css/bootstrap-material-design.min.css">
	<link rel="stylesheet" href="/admin/dist/css/mycustom.css">
	<link rel="stylesheet" href="/admin/dist/css/ripples.min.css">
	<link rel="stylesheet" href="/admin/dist/css/fontawesome.min.css">
	<link rel="stylesheet" href="/admin/dist/css/MaterialAdminLTE.min.css">
	<!-- AdminLTE Skins. Choose a skin from the css/skins
       folder instead of downloading all of them to reduce the load. -->
	<link rel="stylesheet" href="/admin/dist/css/skins/all-md-skins.min.css">
	<!-- jvectormap -->
	<link rel="stylesheet" href="/admin/bower_components/jvectormap/jquery-jvectormap.css">
	<!-- Date Picker -->
	<link rel="stylesheet" href="/admin/bower_components/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css">
	<!-- Daterange picker -->
	<link rel="stylesheet" href="/admin/bower_components/bootstrap-daterangepicker/daterangepicker.css">
	<!-- bootstrap wysihtml5 - text editor -->
	<link rel="stylesheet" href="/admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
	<!-- Bootstrap Color Picker -->
	<link rel="stylesheet" href="/admin/bower_components/bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css">
	<!-- Bootstrap time Picker -->
	<link rel="stylesheet" href="/admin/plugins/timepicker/bootstrap-timepicker.min.css">
	<!-- Select2 -->
	<link rel="stylesheet" href="/admin/bower_components/select2/dist/css/select2.min.css">
	<!-- DataTables -->
	<link rel="stylesheet" href="/admin/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
	<!--Alertify-->
	<link rel="stylesheet" href="/admin/dist/css/alertify/css/alertify.min.css">
	<link rel="stylesheet" href="/admin/dist/css/alertify/css/themes/default.min.css">
	<link rel="stylesheet" href="/admin/dist/css/alertify/css/themes/bootstrap.min.css">
	<link rel="stylesheet" href="/admin/dist/css/alertify/css/themes/default.min.css">

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

<body class="hold-transition skin-blue sidebar-mini">

	<div class="wrapper">
		<!-- Header -->
		<tiles:insertAttribute name="header" />
		<!-- slide bar -->
		<tiles:insertAttribute name="slidebar" />
		<div class="content-wrapper" id="loadPageAll">
			<tiles:insertAttribute name="body" />
		</div>
		<!--Btn scroll top-->
		<button onclick="topFunction()" id="myBtn" title="Go to top">&#x2B06;</button>
		<!--Btn scroll top-->
		<tiles:insertAttribute name="footer" />
	</div>
	<!-- ./wrapper -->
	<!-- jQuery 3 -->
	<script src="/admin/bower_components/jquery/dist/jquery.min.js"></script>
	<!-- jQuery UI 1.11.4 -->
	<script src="/admin/bower_components/jquery-ui/jquery-ui.min.js"></script>
	<!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
	<script>
		$.widget.bridge('uibutton', $.ui.button);
	</script>
	<!-- Bootstrap 3.3.7 -->
	<script src="/admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- Material Design -->
	<script src="/admin/dist/js/material.min.js"></script>
	<script src="/admin/dist/js/ripples.min.js"></script>
	<script src="/admin/dist/js/fontawesome.min.js"></script>
	<script>
		$.material.init();
	</script>
	<!--lodash-->
	<script src="/admin/plugins/lodash.min.js"></script>
	<!-- Sparkline -->
	<script src="/admin/bower_components/jquery-sparkline/dist/jquery.sparkline.min.js"></script>
	<!-- jvectormap -->
	<script src="/admin/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
	<script src="/admin/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<!-- jQuery Knob Chart -->
	<script src="/admin/bower_components/jquery-knob/dist/jquery.knob.min.js"></script>
	<!-- Select2 -->
	<script src="/admin/bower_components/select2/dist/js/select2.full.min.js"></script>
	<!-- InputMask -->
	<script src="/admin/plugins/input-mask/jquery.inputmask.js"></script>
	<script src="/admin/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
	<script src="/admin/plugins/input-mask/jquery.inputmask.extensions.js"></script>
	<!-- bootstrap color picker -->
	<script src="/admin/bower_components/bootstrap-colorpicker/dist/js/bootstrap-colorpicker.min.js"></script>
	<!-- bootstrap time picker -->
	<script src="/admin/plugins/timepicker/bootstrap-timepicker.min.js"></script>
	<!-- daterangepicker -->
	<script src="/admin/bower_components/moment/min/moment.min.js"></script>
	<script src="/admin/bower_components/bootstrap-daterangepicker/daterangepicker.js"></script>
	<!-- datepicker -->
	<script src="/admin/bower_components/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
	<!-- DataTables -->
	<script src="/admin/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
	<script src="/admin/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
	<!-- Bootstrap WYSIHTML5 -->
	<script src="/admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<!-- Slimscroll -->
	<script src="/admin/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<!-- FastClick -->
	<script src="/admin/bower_components/fastclick/lib/fastclick.js"></script>
	<!-- AdminLTE App -->
	<script src="/admin/dist/js/adminlte.min.js"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="/admin/dist/js/demo.js"></script>
	<script src="/admin/plugins/jquery_help.js"></script>
	<script src="/admin/plugins/alertify.min.js"></script>
	<!-- <script src="/admin/plugins/alertify.js"></script> -->
	<!--clock-->
	<script type="text/javascript">
		//event scroll top
		var mybutton = document.getElementById("myBtn");
		// When the user scrolls down 20px from the top of the document, show the button
		window.onscroll = function () {
			scrollFunction()
		};

		function scrollFunction() {
			if (document.body.scrollTop > 40
				|| document.documentElement.scrollTop > 40) {
				mybutton.style.display = "block";
			} else {
				mybutton.style.display = "none";
			}
		}

		// When the user clicks on the button, scroll to the top of the document
		function topFunction() {
			document.body.scrollTop = 0;
			document.documentElement.scrollTop = 0;
		}
		$(document).ready(
			function () {
				// Making 2 variable month and day
				var monthNames = ["Tháng 1", "Tháng 2", "Tháng 3",
					"Tháng 4", "Tháng 5", "Tháng 6", "Tháng 7",
					"Tháng 8", "Tháng 9", "Tháng 10", "Tháng 11",
					"Tháng 12"];
				var dayNames = ["CN", "T2", "T3", "T4", "T5", "T6", "T7"]

				// make single object
				var newDate = new Date();
				// make current time
				newDate.setDate(newDate.getDate());
				// setting date and time
				$('#Date').html(
					dayNames[newDate.getDay()] + ", "
					+ newDate.getDate() + ' '
					+ monthNames[newDate.getMonth()] + ' '
					+ newDate.getFullYear());
				$("#dateBirth").text(
					'(' + monthNames[newDate.getMonth()] + ')');
				setInterval(function () {
					// Create a newDate() object and extract the seconds of the current time on the visitor's
					var seconds = new Date().getSeconds();
					// Add a leading zero to seconds value
					$("#sec").html((seconds < 10 ? "0" : "") + seconds);
				}, 1000);

				setInterval(function () {
					// Create a newDate() object and extract the minutes of the current time on the visitor's
					var minutes = new Date().getMinutes();
					// Add a leading zero to the minutes value
					$("#min").html((minutes < 10 ? "0" : "") + minutes);
				}, 1000);

				setInterval(function () {
					// Create a newDate() object and extract the hours of the current time on the visitor's
					var hours = new Date().getHours();
					// Add a leading zero to the hours value
					$("#hours").html((hours < 10 ? "0" : "") + hours);
				}, 1000);
			});
		function imgError(image) {
			image.onerror = "";
			image.src = ""; //image default if path image not found
			return true;
		}
	</script>
	<tiles:insertAttribute name="javascriptPage" />
</body>

</html>