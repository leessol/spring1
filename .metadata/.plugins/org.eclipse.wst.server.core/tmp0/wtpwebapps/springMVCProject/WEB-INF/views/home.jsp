<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<form action="first/paramTest">
	id = <input type="text" name="userid" value="hello">
	password = <input type="text" name="userpass" value="1234">
	email = <input type="text" name="email" value="test@">
	<input type="submit" value="서버로 전송">
</form>

<p>이름은 ${myname }</p>
<p>나이은 ${myage }</p>
<p>Car는 ${mycar }</p>
<p>Car는 ${mycar.model }</p>
<p>Car는 ${mycar.price }</p>
<P>  The time on the server is ${serverTime}. </P>

<p><a href="/first/sample1">test1</a></p>
<p><a href="/first/sample2">test2</a></p>
<p><a href="/first">test3</a></p>
<p><a href="/first/a.do">test4</a></p>
<p><a href="/first/paramTest?userid=hello&userpass=1234">test5</a></p>
</body>
</html>
