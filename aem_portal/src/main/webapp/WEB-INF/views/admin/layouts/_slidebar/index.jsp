<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false" %>
	<aside class="main-sidebar">
		<!-- sidebar: style can be found in sidebar.less -->
		<section class="sidebar">
			<!-- Sidebar user panel -->
			<div class="user-panel">
				<div class="pull-left info">
					<div class="clock">
						<div id="Date" style="margin-left: -10px;"></div>
						<ul>
							<li id="hours"></li>
							<li id="point">:</li>
							<li id="min"></li>
							<li id="point">:</li>
							<li id="sec"></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- sidebar menu: : style can be found in sidebar.less -->
			<ul class="sidebar-menu" data-widget="tree">
				<li class="treeview"><a href="#"> <i class="fa fa-clone"></i>
						<span>Quản lý hồ sơ</span> <span class="pull-right-container">
							<i class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
					<ul class="treeview-menu">
						<li><a href="index.html"><i class="fa fa-users"></i> Sinh
								viên</a></li>
						<li><a href="index.html"><i class="fa fa-user-secret"></i>
								Giảng viên (FC)</a></li>
						<li><a href="index.html"><i class="fa fa-user"></i> Nhân
								viên</a></li>
					</ul></li>
				<li class="treeview"><a href="#"> <i class="fa fa-bars"></i>
						<span>Quản lý chương trình học</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
					<ul class="treeview-menu">
						<li><a href="index.html"><i class="fa fa-cubes"></i> Khóa
								học</a></li>
						<li><a href="index.html"><i class="fa fa-tasks"></i> Học
								kỳ</a></li>
						<li><a onclick="Redirect('LopHoc','Index')"><i class="fa fa-th-large"></i>
								Lớp học</a></li>
						<li><a href="index.html"><i class="fa fa-clone"></i> Môn
								học</a></li>
					</ul></li>
				<li class="treeview"><a href="#"> <i
							class="fa fa-file-text-o"></i> <span>Đơn từ</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
					<ul class="treeview-menu">
						<li><a href="index.html"><i class="fa fa-desktop"></i>
								Đăng kí thi lại môn</a></li>
						<li><a href="index.html"><i class="fa fa-columns"></i>
								Đăng kí học lại môn</a></li>
						<li><a href="index.html"><i class="fa fa-paper-plane"></i>
								Đăng kí miễn nghĩa vụ</a></li>
						<li><a href="index.html"><i class="fa fa-television"></i>
								Đăng kí chuyển lớp</a></li>
					</ul></li>
				<li><a href=""> <i class="fa fa-money"></i> <span>Phiếu
							thu</span>
					</a></li>
				<li class="treeview"><a href="#"> <i
							class="fa fa-calendar-o"></i> <span>Quản lý lịch học</span> <span
							class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
					<ul class="treeview-menu">
						<li><a href=""><i class="fa fa-calendar-plus-o"></i> Lịch
								học</a></li>
						<li><a href=""><i class="fa fa-calendar-check-o"></i> Điểm
								danh</a></li>
					</ul></li>
				<li class="treeview"><a href="#"> <i class="fa fa-folder"></i>
						<span>Báo cáo</span> <span class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
					<ul class="treeview-menu">
						<li><a href="index.html"><i class="fa fa-user-times"></i>
								Prohibition of Student Exam</a></li>
						<li><a href="index.html"><i class="fa fa-sliders"></i>
								Academic Progress</a></li>
						<li><a href="index.html"><i class="fa fa-mortar-board"></i>
								Graduted Student</a></li>
					</ul></li>


				<li class="treeview"><a href="#"> <i class="fa fa-cog"></i>
						<span>Cấu hình</span> <span class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
					<ul class="treeview-menu">
						<li><a href=""><i class="fa fa-exchange"></i> SKU</a></li>
						<li><a href=""><i class="fa fa-database"></i> Danh mục
								tình trạng</a></li>
						<li><a href=""><i class="fa fa-hdd-o"></i> Loại môn học</a></li>
						<li><a href=""><i class="fa fa-server"></i> Phiên dạy</a></li>
						<li><a href=""><i class="fa fa-tags"></i> Tag</a></li>
						<li><a href=""><i class="fa fa-calendar-times-o"></i> Ngày
								nghỉ</a></li>
					</ul></li>
				<li class="treeview"><a href="#"> <i class="fa fa-windows"></i>
						<span>Hệ thống</span> <span class="pull-right-container"> <i
								class="fa fa-angle-left pull-right"></i>
						</span>
					</a>
					<ul class="treeview-menu">
						<li><a href=""><i class="fa fa-user-plus"></i> Quyền</a></li>
						<li><a href=""><i class="fa fa-sliders"></i> Menu</a></li>
						<li><a href=""><i class="fa fa-group"></i> Nhóm quyền</a></li>
						<!-- <li><a href=""><i class="fa fa-check-square"></i> Phân quyền</a></li> -->
						<li><a href=""><i class="fa fa-refresh"></i> Reset mật
								khẩu</a></li>
					</ul></li>
			</ul>
		</section>
		<!-- /.sidebar -->
	</aside>