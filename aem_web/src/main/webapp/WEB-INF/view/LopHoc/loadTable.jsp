<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
</table>
