<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
${getCapcha}
<button onclick="getCapCha()">
    GetCapCha
</button>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
<script>
    function getCapCha() {
        var capchacode = document.getElementById("g-recaptcha-response").value;
        alert(capchacode);
        $.ajax({
            url: '/trickcode/getCapcha',
            //dataType: 'json',
            method: "POST",
            data: {
            	capchacode
            }, success: function (res) {
                console.log("success");
            }, error: function (err) {
                console.log(err.message);
            }


        });
    }
</script>