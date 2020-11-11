<%@ page contentType="text/html;charset=UTF-8" language="java"
	isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>main</title>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<div class="main">
		<h1>THis is layout page</h1>
		<tiles:insertAttribute name="body" />
	</div>
	<tiles:insertAttribute name="footer" />
	
	
	
	<tiles:insertAttribute name="javascriptPage" />
</body>
</html>