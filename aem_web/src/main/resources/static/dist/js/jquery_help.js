window.formatDate = "DD/MM/YYYY";
window.formatDateTime = "DD/MM/YYYY HH:mm";
window.formatTime = "HH:mm";

window.formatDateServer = "YYYY/MM/DD";
window.formatDateTimeServer = "YYYY/MM/DD HH:mm";
window.formatTimeServer = "YYYY/MM/DD HH:mm";

window.formatInputTypeDate = "YYYY-MM-DD";
window.formatInputTypeDateTime = "YYYY-MM-DDTHH:mm:ss.SSS";
$(function() {
    //setting input;
    getElementDefault("[onlynumberleter]").InputAlowNumberLeter();
    getElementDefault("[onlynumber]").InputAlowNumber();
    getElementDefault("[isInputAllowVarchar]").InputAllowVarchar();
    getElementDefault("[ismoney]").InputAlowNumberMoney();

    //Initialize Select2 Elements
    $(".select2").select2();
    //Init Datatable
    $("#table").DataTable({
        ordering: false,
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
    InitDateRangePicker();

    //Date picker
    $(".datepicker").datepicker({
        format: "dd/mm/yyyy",
        autoclose: true,
    });

    //Colorpicker
    $(".my-colorpicker1").colorpicker();
    //color picker with addon
    $(".my-colorpicker2").colorpicker();

    //Timepicker
    $("[istime]").inputmask("h:s", { placeholder: "hh/mm" });
    //setting ajax and download
    $.RequestAjax = function(url, data, methodExcute) {
        $.ajax({
            url: url,
            type: "post",
            datatype: "json",
            contentType: "application/json",
            data: data,
            async: false,
            cache: false,
            success: function(data) {
                if (methodExcute && typeof methodExcute == "function")
                    methodExcute(data);
            },
        });
    };
    $.RequestAjaxAsync = function(url, data, methodExcute) {
        $.ajax({
            url: url,
            type: "post",
            datatype: "json",
            contentType: "application/json",
            data: data,
            async: true,
            cache: false,
            success: function(data) {
                if (methodExcute && typeof methodExcute == "function")
                    methodExcute(data);
            },
        });
    };
    $.RequestAjaxFormData = function(url, data, methodExcute) {
        $.ajax({
            url: url,
            type: "post",
            contentType: false,
            processData: false,
            data: data,
            async: false,
            cache: false,
            success: function(data) {
                if (methodExcute && typeof methodExcute == "function")
                    methodExcute(data);
            },
        });
    };
    $.Download = function(url, nameFile, methodaftercall) {
        var xhr = new XMLHttpRequest();
        xhr.open("GET", url);
        xhr.setRequestHeader("Content-type", "application/json");
        xhr.responseType = "blob";
        xhr.onload = function(e) {
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
    InputAllowVarchar: function() {
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

        $(this).each(function() {
            $(this).keyup(function(e) {
                var value = $(this).val();
                var charChuyenDoi = convertKyTu(value);
                $(this).val(charChuyenDoi);
            });
        });
    },
    InputAlowNumberLeter: function() {
        return this.each(function() {
            $(this).keypress(function(e) {
                var keyCode = e.which;
                if (keyCode == 45 || keyCode == 95 || keyCode == 92 || keyCode == 46) {
                    //
                } else if (!(
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
    InputAlowNumber: function() {
        return this.each(function() {
            $(this).keydown(function(e) {
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
    InputAlowNumberMoney: function() {
        $(this).InputAlowNumber();
        $(this).keyup(function(e) {
            var value = $(this).val();
            value = MoneyToNumber(value);
            $(this).val(NumberToMoney(value));
        });
    },
    AddOrUpdateForm: function(
        url,
        methodSuccess,
        validatorExtension,
        methodSetData
    ) {
        if ($(this).is("form")) {
            var allow = true;
            if (validatorExtension != null && validatorExtension != undefined) {
                allow = validatorExtension(this);
            }
            if (allow) {
                var entity = new Object();
                $(this)
                    .find("[ismodel]")
                    .each(function() {
                        if (
                            $(this).is(
                                "input[type='text'],input[type='number'],input[type='email'],textarea,select,input[type='hidden'],input[type='password']"
                            )
                        )
                            entity[$(this).attr("id")] = $(this).val();
                        if ($(this).is("input[type='checkbox']"))
                            entity[$(this).attr("id")] = this.checked;
                        if ($(this).is("[ismoney]"))
                            entity[$(this).attr("id")] = entity[$(this).attr("id")].replace(/,/gi,"");
                        if ($(this).is("[isdate]") && $(this).val() != "") {
                            entity[$(this).attr("id")] = moment(
                                $(this).val(),
                                $(this).attr("formatdate")
                            ).format("YYYY/MM/DD");
                        }
                        if ($(this).is("[isdatetime]") && $(this).val() != "") {
                            entity[$(this).attr("id")] = moment(
                                $(this).val(),
                                $(this).attr("formatdate")
                            ).format("YYYY/MM/DD HH:mm");
                        }
                        if ($(this).is("input[type='radio']") && this.checked) {
                            entity[$(this).attr("name")] = this.value;
                        }
                    });
                var data = JSON.stringify({
                    entity: entity,
                    isUpdate: $(this).find("[isidmodel]").val() != 0,
                });
                if (methodSetData != null && methodSetData != undefined)
                    data = methodSetData(entity, $(this).find("[isidmodel]").val() != 0);
                $.RequestAjax(url, data, methodSuccess);
            } else {
                console.log(
                    "Đối tượng insert or update không hợp lệ. Đối tưởng phải là form"
                );
            }
        }
    },
    AddOrUpdateFormData: function(
        url,
        methodSuccess,
        validatorExtension,
        methodSetData
    ) {
        if ($(this).is("form")) {
            var allow = true;
            if (validatorExtension != null && validatorExtension != undefined) {
                allow = validatorExtension(this);
            }
            if (allow) {
                var entity = new Object();
                $(this)
                    .find("[ismodel]")
                    .each(function() {
                        if (
                            $(this).is(
                                "input[type='text'],input[type='number'],input[type='email'],textarea,select,input[type='hidden'],input[type='password']"
                            )
                        )
                            entity[$(this).attr("id")] = $(this).val();
                        if ($(this).is("input[type='checkbox']"))
                            entity[$(this).attr("id")] = this.checked;
                        if ($(this).is("[ismoney]"))
                            entity[$(this).attr("id")] = entity[$(this).attr("id")].replace(
                                /,/gi,
                                ""
                            );
                        if ($(this).is("[isdate]") && $(this).val() != "") {
                            entity[$(this).attr("id")] = moment(
                                entity[$(this).attr("id")],
                                $(this).attr("formatdate")
                            ).format("YYYY/MM/DD");
                        }
                        if ($(this).is("input[type='radio']") && this.checked) {
                            entity[$(this).attr("name")] = this.value;
                        }
                    });
                var formData = new FormData();
                formData.append("entity", JSON.stringify(entity));
                formData.append("isUpdate", $(this).find("[isidmodel]").val() != "0");

                if (methodSetData != null && methodSetData != undefined)
                    formData = methodSetData(
                        entity,
                        $(this).find("[isidmodel]").val() != "0"
                    );

                $.RequestAjaxFormData(url, formData, methodSuccess);
            } else {
                console.log(
                    "Đối tượng insert or update không hợp lệ. Đối tưởng phải là form"
                );
            }
        }
    },
});
var getElementDefault = function(seletor) {
    var lsElements = $(seletor).filter(function() {
        return !$(this).is("[daCaiDat]");
    });

    if (lsElements.length > 0) {
        lsElements.attr("daCaiDat", true);
    }

    return lsElements;
};

function resetSoThuTuRecordTable(selectThuTu) {
    selectThuTu = selectThuTu ?? $(".tblChiTiet .stt");
    if (selectThuTu.length > 0) {
        selectThuTu.each(function(i) {
            $(this).text(i + 1);
        });
    }
}
InitDateRangePicker = function(
    selectorInput,
    selectorTuNgay,
    selectorDenNgay
) {
    selectorInput = selectorInput ?? $("#daterange");
    selectorTuNgay = selectorTuNgay ?? $("#tuNgay");
    selectorDenNgay = selectorDenNgay ?? $("#denNgay");
    selectorInput.daterangepicker({
            ranges: {
                "Hôm nay": [moment(), moment()],
                "Ngày hôm qua": [
                    moment().subtract(1, "days"),
                    moment().subtract(1, "days"),
                ],
                "7 ngày trước": [moment().subtract(6, "days"), moment()],
                "30 ngày trước": [moment().subtract(29, "days"), moment()],
                "Tháng này": [moment().startOf("month"), moment().endOf("month")],
                "Tháng trước": [
                    moment().subtract(1, "month").startOf("month"),
                    moment().subtract(1, "month").endOf("month"),
                ],
            },
            startDate: moment().subtract(29, "days"),
            endDate: moment(),
            locale: {
                format: "DD/MM/YYYY",
            },
        },
        function(start, end) {
            $("#daterange span").html(
                start.format("DD/MM/YYYY") + " - " + end.format("DD/MM/YYYY")
            );
            selectorTuNgay.val(start.format("DD/MM/YYYY"));
            selectorDenNgay.val(end.format("DD/MM/YYYY"));
        }
    );
};

function ScrollLoadData(selectorTable, urlData, data, methodAfterLoad) {
    // Biến lưu trữ trang hiện tại
    var page = 1;
    // Biến lưu trữ rạng thái phân trang
    var stopped = false;
    // Khi kéo scroll thì xử lý
    var positionlast = 0;
    $(window).scroll(function() {
        // Element append nội dung
        $element = selectorTable ?? $("#tableSV tbody");
        var newposition = $(window).scrollTop();
        if (newposition - positionlast > 500) {
            // Nếu hết dữ liệu thì ngưng
            if (stopped == true) {
                return false;
            }
            // Tăng số trang lên 1
            page++;
            data = data ?? [];
            data[page] = page;
            data[ajaxLoad] = "ajaxLoad";
            // Gửi Ajax
            $.ajax({
                type: "get",
                dataType: "text",
                url: urlData,
                data: data,
                success: function(result) {
                    console.log("res:" + result);
                    if (result == null || result == "") {
                        stopped = true;
                        return false;
                    }
                    $element.append(result);
                    if (methodAfterLoad && typeof methodAfterLoad == "function") {
                        methodAfterLoad(result);
                    }
                    positionlast = newposition;
                },
            });
            return false;
        }
    });
}

function NumberToMoney(num) {
    return num.toString().replace(/(\d)(?=(\d{3})+(?!\d))/g, "$1,");
}

function MoneyToNumber(money) {
    return money.replace(/,/gi, "");
}
//setting alertity
function ThongBao_ThanhCong(msg) {
    alertify.success(msg);
}

function ThongBao_Loi(msg) {
    alertify.error(msg);
}

function Delete(id, urlDel, methodComplete) {
    alertify.confirm(
        "Xóa dữ liệu",
        "Bạn muốn xóa dòng dữ liệu này?",
        function() {
            setTimeout(function() {
                $.ajax({
                    type: "POST",
                    url: urlDel,
                    data: { maId: id },
                    processData: false,
                    contentType: false,
                    success: function(res) {
                        if (res) {
                            ThongBao_ThanhCong("Xóa thành công");
                            if (methodComplete && typeof methodComplete == "function") {
                                methodComplete(res);
                                return;
                            } else {
                                ThongBao_Loi("Xóa thất bại");
                            }
                        }
                    },
                });
            }, 200);
        },
        null
    ); //display form yes/no using onclick="" in the a tag
}

function s_Save(url, form, method, exitCheckbox, setFormMethod) {
    //set 
    if (!form)
        form = $("#form");
    if (!url)
        url = _urlEdit;

    var lsCheckBox;
    exitCheckbox = exitCheckbox ? exitCheckbox : false;

    form.validate().destroy();

    $.validator.unobtrusive.parse(form);
    form.validate();

    if (form.valid()) {
        form.find("[disabled]").removeAttr("disabled");
        form.find("[readonly]").removeAttr("readonly");

        form.find("[onlynumber]").each(function() {
            $(this).inputmask("remove");
            this.value = this.value.replace(/,/gi, '');
        })

        form.find("[isdate]").each(function() {
            if ($(this).is("[type='date']")) {
                changeTypeDateToText(this, 0);
                return;
            }

            var value = this.value;
            if (value && value != "")
                this.value = moment(this.value, "DD/MM/YYYY").format("YYYY/MM/DD");
        })

        form.find("[istime]").each(function() {

            var value = this.value;
            if (value && value != "")
                this.value = moment(this.value, "HH:mm").format("YYYY/MM/DD HH:mm");
        })

        form.find("[isdatetime]").each(function() {
            if ($(this).is("[type='datetime-local']")) {
                changeTypeDateToText(this, 1);
                return;
            }

            var value = this.value;
            if (value && value != "")
                this.value = moment(this.value, "DD/MM/YYYY HH:mm").format("YYYY/MM/DD HH:mm");
        })

        if (exitCheckbox) {
            lsCheckBox = form.find("[type='checkbox']");
            lsCheckBox.each(function() {
                var value = this.checked ? "true" : "false";
                $(this).attr("value", value);
            })
        }

        var formdata = new FormData(form[0]);

        //set form
        if (typeof _setFormMethod === "function") {
            formdata = _setFormMethod(formdata);
            _setFormMethod = null
        }

        $.ajax({
            type: "POST",
            url: url,
            data: formdata,
            processData: false,
            contentType: false,
            success: function(data) {
                if (method)
                    method(data);
                else {

                    if (data.result) {
                        ThongBao_ThanhCong("Lưu thành công");
                        setTimeout(function() {
                            $("#loadPageAll").load(data.url + "&ajaxLoad=Menu", function() {
                                window.history.pushState("object or string", "Title", data.url.replace("&ajaxLoad=Menu", ""));
                            });
                        }, 1000)
                    } else {
                        Thong_BaoLoi("Lưu thất bại");
                        ThongBao_Loi(data.message);
                    }
                }
            },
        });
    }

}

function changeTypeTextToDate(input, opitonType, isLoadFirst) {
    if ($(input).is("input[type='text']")) {
        var value = $(input).val();
        //0 type là date
        //1 type là datetime-local
        //mặc định là time
        switch (opitonType) {
            case 0:
                $(input).attr("type", "date");

                if (value && value != "") {
                    if (!isLoadFirst)
                        value = moment(value, window.formatDateServer).format(window.formatDate)

                    $(input).val(value);
                }
                break;
            case 1:
                $(input).attr("type", "datetime-local");

                if (value && value != "") {
                    if (!isLoadFirst)
                        value = moment(value, window.formatDateTimeServer).format(window.formatDateTime)

                    $(input).val(value);
                }
                break;
            default:
                $(input).attr("type", "time");

                if (value && value != "") {
                    if (!isLoadFirst)
                        value = moment(value, window.formatDateTimeServer).format(window.formatTime)

                    $(input).val(value);
                }
                break;
        }
    }
}

function changeTypeDateToText(input, opitonType) {
    //0 type là date
    //1 type là datetime-local
    //mặc định là time
    switch (opitonType) {
        case 0:
            if ($(input).is("[type='date']")) {
                var value = $(input).val();

                $(input).attr("type", "text");

                if (value && value != "")
                    $(input).val(moment(value, window.formatDate).format(window.formatDateServer));
            }
            break;
        case 1:
            if ($(input).is("[type='datetime-local']")) {
                var value = $(input).val();

                $(input).attr("type", "text");

                if (value && value != "")
                    $(input).val(moment(value, window.formatDateTime).format(window.formatDateTimeServer));
            }
            break;
        default:
            if ($(input).is("[type='time']")) {
                var value = $(input).val();

                $(input).attr("type", "text");

                if (value && value != "")
                    $(input).val(moment(value, window.formatTime).format(window.formatDateTimeServer));
            }
            break;
    }
}
//init redirect
function Redirect(conTroller, action, paramter) {
    var url = "/" + conTroller + "/" + action + "?ajaxLoad=Menu";
    if (paramter) url += paramter;
    $("#loadPageAll").load(url, function() {
        window.history.pushState(
            "object or string",
            "Title",
            url.replace("ajaxLoad=Menu", "")
        );
    });
}

function Redirect_Detail(conTroller, maId) {
    var action = "Detail";
    var url =
        "/" + conTroller + "/" + action + "?&ajaxLoad=Menu" + "&maId=" + maId;
    $("#loadPageAll").load(url, function() {
        window.history.pushState(
            "object or string",
            "Title",
            url.replace("&ajaxLoad=Menu", "")
        );
    });
}

function Redirect_Edit(conTroller, maId) {
    var url = "/" + conTroller + "/Edit?" + "&ajaxLoad=Menu" + "&maId=" + maId;
    $("#loadPageAll").load(url, function() {
        window.history.pushState(
            "object or string",
            "Title",
            url.replace("&ajaxLoad=Menu", "")
        );
    });
}

function Redirect_Create(conTroller) {
    var url = "/" + conTroller + "/Create?ajaxLoad=Menu";
    $("#loadPageAll").load(url, function() {
        window.history.pushState(
            "object or string",
            "Title",
            url.replace("?ajaxLoad=Menu", "")
        );
    });
}
//so sánh giá trị 2 input ngày
function soSanh2Ngay(valueTuNgay, valueDenNgay, methodSuccess, methodError) {
    var momentBatDau = moment(valueTuNgay, window.formatDateTime);
    var momentKetThuc = moment(valueDenNgay, window.formatDateTime);
    if (!momentKetThuc.isAfter(momentBatDau)) {
        ThongBao_Loi("Ngày kết thúc phải lớn hơn ngày bắt đầu.");
        methodError();
    } else {
        methodSuccess();
    }
}
//chuyển tiền số thành tiền chữ
var ChuSo = new Array(
    " không",
    " một",
    " hai",
    " ba",
    " bốn",
    " năm",
    " sáu",
    " bảy",
    " tám",
    " chín"
);
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