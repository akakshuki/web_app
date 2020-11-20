window.formatDate = "DD/MM/YYYY";
window.formatDateTime = "DD/MM/YYYY HH:mm";
window.formatTime = "HH:mm";

window.formatDateServer = "YYYY/MM/DD";
window.formatDateTimeServer = "YYYY/MM/DD HH:mm";
window.formatTimeServer = "YYYY/MM/DD HH:mm";

window.formatInputTypeDate = "YYYY-MM-DD";
window.formatInputTypeDateTime = "YYYY-MM-DDTHH:mm:ss.SSS";
$(function () {
  //setting input
  getElementDefault("[onlynumberleter]").InputAlowNumberLeter();
  getElementDefault("[onlynumber]").InputAlowNumber();
  getElementDefault("[isInputAllowVarchar]").InputAllowVarchar();
  //Initialize Select2 Elements
  $(".select2").select2();
  //Init Datatable
  $("#table").DataTable({
    "ordering": false
  });
  //Datemask dd/mm/yyyy
  $("#datemask").inputmask("dd/mm/yyyy", { placeholder: "dd/mm/yyyy" });
  //Datemask2 mm/dd/yyyy
  $("#datemask2").inputmask("mm/dd/yyyy", { placeholder: "mm/dd/yyyy" });
  //Money Euro
  $("[data-mask]").inputmask();

  //Date range picker
  $("#reservation").daterangepicker();
  //Date range picker with time picker
  $("#reservationtime").daterangepicker({
    timePicker: true,
    timePickerIncrement: 30,
    format: "MM/DD/YYYY h:mm A",
  });
  //Date range as a button
  $("#daterange-btn").daterangepicker(
    {
      ranges: {
        Today: [moment(), moment()],
        Yesterday: [moment().subtract(1, "days"), moment().subtract(1, "days")],
        "Last 7 Days": [moment().subtract(6, "days"), moment()],
        "Last 30 Days": [moment().subtract(29, "days"), moment()],
        "This Month": [moment().startOf("month"), moment().endOf("month")],
        "Last Month": [
          moment().subtract(1, "month").startOf("month"),
          moment().subtract(1, "month").endOf("month"),
        ],
      },
      startDate: moment().subtract(29, "days"),
      endDate: moment(),
    },
    function (start, end) {
      $("#daterange-btn span").html(
        start.format("MMMM D, YYYY") + " - " + end.format("MMMM D, YYYY")
      );
    }
  );

  //Date picker
  $(".datepicker").datepicker({
    format: 'dd/mm/yyyy',
    autoclose: true,
    
  });

  //iCheck for checkbox and radio inputs
  $('input[type="checkbox"].minimal, input[type="radio"].minimal').iCheck({
    checkboxClass: "icheckbox_minimal-blue",
    radioClass: "iradio_minimal-blue",
  });
  //Red color scheme for iCheck
  $(
    'input[type="checkbox"].minimal-red, input[type="radio"].minimal-red'
  ).iCheck({
    checkboxClass: "icheckbox_minimal-red",
    radioClass: "iradio_minimal-red",
  });
  //Flat red color scheme for iCheck
  $('input[type="checkbox"].flat-red, input[type="radio"].flat-red').iCheck({
    checkboxClass: "icheckbox_flat-green",
    radioClass: "iradio_flat-green",
  });

  //Colorpicker
  $(".my-colorpicker1").colorpicker();
  //color picker with addon
  $(".my-colorpicker2").colorpicker();

  //Timepicker
  $(".timepicker").timepicker({
    showInputs: false,
  });
  //setting ajax and download
  $.RequestAjax = function (url, data, methodExcute) {
    $.ajax({
      url: url,
      type: "post",
      datatype: "json",
      contentType: "application/json",
      data: data,
      async: false,
      cache: false,
      success: function (data) {
        if (methodExcute) methodExcute(data);
      },
    });
  };
  $.RequestAjaxAsync = function (url, data, methodExcute) {
    $.ajax({
      url: url,
      type: "post",
      datatype: "json",
      contentType: "application/json",
      data: data,
      async: true,
      cache: false,
      success: function (data) {
        if (methodExcute) methodExcute(data);
      },
    });
  };
  $.RequestAjaxFormData = function (url, data, methodExcute) {
    $.ajax({
      url: url,
      type: "post",
      contentType: false,
      processData: false,
      data: data,
      async: false,
      cache: false,
      success: function (data) {
        if (methodExcute) methodExcute(data);
      },
    });
  };
  $.Download = function (url, nameFile, methodaftercall) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", url);
    xhr.setRequestHeader("Content-type", "application/json");
    xhr.responseType = "blob";
    xhr.onload = function (e) {
      if (methodaftercall) methodaftercall();
      if (this.status === 200) {
        var file = window.URL.createObjectURL(this.response);
        var a = document.createElement("a");
        a.href = file;
        a.download = nameFile;
        a.click();
      }
    };
    xhr.send();
  };
});
$.fn.extend({
  InputAllowVarchar: function () {
    function convertKyTu(str) {
      str = str.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g, "a");
      str = str.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g, "e");
      str = str.replace(/ì|í|ị|ỉ|ĩ/g, "i");
      str = str.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g, "o");
      str = str.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g, "u");
      str = str.replace(/ỳ|ý|ỵ|ỷ|ỹ/g, "y");
      str = str.replace(/đ/g, "d");
      str = str.replace(/À|Á|Ạ|Ả|Ã|Â|Ầ|Ấ|Ậ|Ẩ|Ẫ|Ă|Ằ|Ắ|Ặ|Ẳ|Ẵ/g, "A");
      str = str.replace(/È|É|Ẹ|Ẻ|Ẽ|Ê|Ề|Ế|Ệ|Ể|Ễ/g, "E");
      str = str.replace(/Ì|Í|Ị|Ỉ|Ĩ/g, "I");
      str = str.replace(/Ò|Ó|Ọ|Ỏ|Õ|Ô|Ồ|Ố|Ộ|Ổ|Ỗ|Ơ|Ờ|Ớ|Ợ|Ở|Ỡ/g, "O");
      str = str.replace(/Ù|Ú|Ụ|Ủ|Ũ|Ư|Ừ|Ứ|Ự|Ử|Ữ/g, "U");
      str = str.replace(/Ỳ|Ý|Ỵ|Ỷ|Ỹ/g, "Y");
      str = str.replace(/Đ/g, "D");
      str = str.replace(/ /g, "");

      return str;
    }
    $(this).InputAlowNumberLeter();

    $(this).each(function () {
      $(this).keyup(function (e) {
        var value = $(this).val();
        var charChuyenDoi = convertKyTu(value);
        $(this).val(charChuyenDoi);
      });
    });
  },
  InputAlowNumberLeter: function () {
    return this.each(function () {
      $(this).keypress(function (e) {
        var keyCode = e.which;
        if (keyCode == 45 || keyCode == 95 || keyCode == 92 || keyCode==46) {
          //
        } else if (
          !(
            (keyCode >= 47 && keyCode <= 57) ||
            (keyCode >= 65 && keyCode <= 90) ||
            (keyCode >= 97 && keyCode <= 122)
          ) &&
          keyCode != 8
        ) {
          e.preventDefault();
        }
      });
    });
  },
  InputAlowNumber: function () {
    return this.each(function () {
      $(this).keydown(function (e) {
        var key = e.charCode || e.keyCode || 0;
        // cho phép backspace, tab, delete, enter, arrows, numbers và keypad numbers ONLY
        // home, end, period, and numpad decimal
        return (
          key == 8 ||
          key == 9 ||
          key == 13 ||
          key == 46 ||
          key == 110 ||
          key == 190 ||
          (key >= 35 && key <= 40) ||
          (key >= 48 && key <= 57) ||
          (key >= 96 && key <= 105)
        );
      });
    });
  },
});
var getElementDefault = function (seletor) {
  var lsElements = $(seletor).filter(function () {
    return !$(this).is("[daCaiDat]");
  });

  if (lsElements.length > 0) {
    lsElements.attr("daCaiDat", true);
  }

  return lsElements;
};
function resetSoThuTuRecordTable(selectThuTu) {
  selectThuTu=selectThuTu??$(".tblChiTiet .thuTu");
  if (selectThuTu.length > 0) {
    selectThuTu.each(function (i) {
      $(this).val(i + 1);
    });
  }
}
//setting alertity
function ThongBao_ThanhCong(msg){
  alertify.success(msg); 
}
function ThongBao_Loi(msg){
  alertify.error(msg); 
}
function Delete(id,title,content,methodAfterDone) {
  alertify.confirm(title, content, function () {
      // window.location.href=;
      methodAfterDone(id)
  }, null); //display form yes/no using onclick="" in the a tag
};

//chuyển tiền số thành tiền chữ
var ChuSo = new Array(" không"," một"," hai"," ba"," bốn"," năm"," sáu"," bảy"," tám"," chín");
var Tien = new Array("", " nghìn", " triệu", " tỷ", " nghìn tỷ", " triệu tỷ");
function DocSo3ChuSo(baso) {
  var tram;
  var chuc;
  var donvi;
  var KetQua = "";
  tram = parseInt(baso / 100);
  chuc = parseInt((baso % 100) / 10);
  donvi = baso % 10;
  if (tram == 0 && chuc == 0 && donvi == 0) return "";
  if (tram != 0) {
    KetQua += ChuSo[tram] + " trăm";
    if (chuc == 0 && donvi != 0) KetQua += " linh";
  }
  if (chuc != 0 && chuc != 1) {
    KetQua += ChuSo[chuc] + " mươi";
    if (chuc == 0 && donvi != 0) KetQua = KetQua + " linh";
  }
  if (chuc == 1) KetQua += " mười";
  switch (donvi) {
    case 1:
      if (chuc != 0 && chuc != 1) {
        KetQua += " mốt";
      } else {
        KetQua += ChuSo[donvi];
      }
      break;
    case 5:
      if (chuc == 0) {
        KetQua += ChuSo[donvi];
      } else {
        KetQua += " lăm";
      }
      break;
    default:
      if (donvi != 0) {
        KetQua += ChuSo[donvi];
      }
      break;
  }
  return KetQua;
}
function DocTienBangChu(SoTien) {
  var lan = 0;
  var i = 0;
  var so = 0;
  var KetQua = "";
  var tmp = "";
  var ViTri = new Array();
  if (SoTien < 0) return "Số tiền âm";
  if (SoTien == 0) return "Không đồng";
  if (SoTien > 0) {
    so = SoTien;
  } else {
    so = -SoTien;
  }
  if (SoTien > 8999999999999999) {
    //SoTien = 0;
    return "Số quá lớn!";
  }
  ViTri[5] = Math.floor(so / 1000000000000000);
  if (isNaN(ViTri[5])) ViTri[5] = "0";
  so = so - parseFloat(ViTri[5].toString()) * 1000000000000000;
  ViTri[4] = Math.floor(so / 1000000000000);
  if (isNaN(ViTri[4])) ViTri[4] = "0";
  so = so - parseFloat(ViTri[4].toString()) * 1000000000000;
  ViTri[3] = Math.floor(so / 1000000000);
  if (isNaN(ViTri[3])) ViTri[3] = "0";
  so = so - parseFloat(ViTri[3].toString()) * 1000000000;
  ViTri[2] = parseInt(so / 1000000);
  if (isNaN(ViTri[2])) ViTri[2] = "0";
  ViTri[1] = parseInt((so % 1000000) / 1000);
  if (isNaN(ViTri[1])) ViTri[1] = "0";
  ViTri[0] = parseInt(so % 1000);
  if (isNaN(ViTri[0])) ViTri[0] = "0";
  if (ViTri[5] > 0) {
    lan = 5;
  } else if (ViTri[4] > 0) {
    lan = 4;
  } else if (ViTri[3] > 0) {
    lan = 3;
  } else if (ViTri[2] > 0) {
    lan = 2;
  } else if (ViTri[1] > 0) {
    lan = 1;
  } else {
    lan = 0;
  }
  for (i = lan; i >= 0; i--) {
    tmp = DocSo3ChuSo(ViTri[i]);
    KetQua += tmp;
    if (ViTri[i] > 0) KetQua += Tien[i];
    if (i > 0 && tmp.length > 0) KetQua += ","; //&& (!string.IsNullOrEmpty(tmp))
  }
  if (KetQua.substring(KetQua.length - 1) == ",") {
    KetQua = KetQua.substring(0, KetQua.length - 1);
  }
  KetQua = KetQua.substring(1, 2).toUpperCase() + KetQua.substring(2);
  return KetQua + " đồng"; //.substring(0, 1);//.toUpperCase();// + KetQua.substring(1);
}
