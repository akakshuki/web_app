<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>
	  Quản lý lớp
	</h1>
	<div class="wrap-btn-header">
	  <button type="button" class="btn bg-maroon" data-toggle="modal" data-target="#modal-default"><i
		  class="fa fa-plus"></i> Thêm</button>
	</div>
  </section>

  <!-- Main content -->
  <section class="content">
	<!-- Main row -->
	<div class="row">

	  <!--table-->
	  <div class="col-lg-12">
		<div class="filter-table">

		</div>
		<table id="table" class="table table-bordered table-striped">
		  <thead>
			<tr>
			  <th width="45" class="text-center">STT</th>
			  <th>Tên lớp</th>
			  <th>Slot/lớp</th>
			  <th>Thao tác</th>
			</tr>
		  </thead>
		  <tbody class="tblChiTiet">
			<tr>
			  <td class="text-center">1</td>
			  <td>
				<span class="label label-primary">MALop</span> <br>
				<span>Tên aaa</span>
			  </td>
			  <td>
				<span>Tổng: 23</span><br>
				<span>Đã đăng kí: 10</span>
			  </td>
			  <td>
				<button type="button" class="btn-edit"><i class="fa fa-pencil"></i></button>
				<button type="button" class="btn-del"><i class="fa fa-trash-o"></i></button>
			  </td>
			</tr>
		  </tbody>
		  <tfoot>
			<tr>
			  <th class="text-center">STT</th>
			  <th>Tên lớp</th>
			  <th>Slot/lớp</th>
			  <th>Thao tác</th>
			</tr>
		  </tfoot>
		</table>
	  </div>
	  <!--table-->
	  <div>

	  </div>
	</div>

  </section>
  <!-- /.content -->