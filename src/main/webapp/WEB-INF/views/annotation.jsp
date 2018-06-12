<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring4 MVC -HelloWorld</title>
</head>
<body>
	<!-- 具体请求是   http://localhost:8080/mymvc/requestParam?name=hepei&age=25 -->
	<h1>@RequestParam的例子</h1>
    <h2>${name}</h2>
    <h2>${age}</h2>
    
    <!-- 具体请求是 由ajax.jsp中的发出的 -->
	<h1>@RequestBody的例子</h1>
    <h2>${name}</h2>
    <h2>${password}</h2>
</body>
</html>