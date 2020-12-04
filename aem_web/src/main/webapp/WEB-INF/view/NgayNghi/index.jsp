<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="../base/_headerMain.jspf" %>
<!-- Content Header (Page header) -->
<section class="content-header">
	<h1>
	  Quản lý ngày nghỉ
	</h1>
	<div class="wrap-btn-header">
	  <button type="button" class="btn bg-maroon" id="btnCreate"><i
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
		<div class="wrap-table">
			<%@ include file="loadTable.jsp" %>
		</div>		
	  </div>
	  <!--table-->
	  <div>

	  </div>
	</div>

  </section>
  <!-- /.content -->
  <%@ include file="modalAction.jsp" %>
  <%@ include file="../base/_footer.jspf" %>