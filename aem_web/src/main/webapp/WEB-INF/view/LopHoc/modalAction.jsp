<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!--modal default-->
      <div class="modal fade" id="modal-lopHoc">
        <div class="modal-dialog">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span></button>
              <h4 class="modal-title">Thêm lớp</h4>
            </div>
            <div class="modal-body">
              <div class="row">
                <div class="col-lg-12">
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label for="">Mã lớp</label>
                        <input class="form-control" type="text" id="id_class" name="id_class" ismodel isidmodel isInputAllowVarchar>
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label for="">Tên lớp</label>
                        <input class="form-control" type="text" id="name_class" name="name_class" ismodel>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label for="">Tổng slot/lớp</label>
                        <input class="form-control" type="text" id="slot_total" name="slot_total" onlynumber ismodel>
                      </div>
                    </div>
                    <div class="col-lg-6">
                      <div class="form-group">
                        <label for="">Slot đã đăng ký</label>
                        <input class="form-control" type="text" id="slot_regis" name="slot_regis" onlynumber value="0" ismodel>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-default pull-left" data-dismiss="modal">Close</button>
              <button type="button" class="btn btn-primary">Save changes</button>
            </div>
          </div>
          <!-- /.modal-content -->
        </div>
        <!-- /.modal-dialog -->
      </div>
      <!--modal default-->