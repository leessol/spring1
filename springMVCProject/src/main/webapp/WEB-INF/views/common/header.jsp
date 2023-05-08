<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath }"
	scope="application"></c:set>
<%
String company = "신한금융SW아카데미";
%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

<script>
	$(function() {
		$("#my1").click(
				function() {
					$("tbody").each(
							function(index, item) {
								//$(item).css("background-color", "red");
								$(item).find("tr:nth-child(2n+1)").css(
										"background-color", "green");
								//$(item).find("td").css("background-color", "green");
							});

				});

		$("#btnLogout").on("click", function() {
			$.ajax({
				url : "${path}/auth/logout.do",
				success : function() {
					alert("로그아웃되었습니다. ");
					location.href = "${path}/auth/loginCheck.do";
				},
				error : function(message) {
					alert(message);
				}
			});
		});

		//#container > table > tbody > tr:nth-child(1) > td:nth-child(2)
	});
</script>
<div style="border: 1px solid green">
	<div>로그인한 사용자: ${loginUser.manager_name==null?"guest":loginUser.manager_name}</div>
	<%-- <div>세션에서 로그인한 사용자 읽기(EL): ${sessionScope.loginUser}</div> --%>
	<div>
		<%-- 세션에서 로그인한 사용자 읽기(ScriptLet):
	<%=session.getAttribute("loginUser") %></div> --%>
		<c:if test="${loginUser!=null}">
			<button id="btnLogout">로그아웃</button>
			<img src = "${path}/uploads/${loginUser.pic }" />
		</c:if>
		<c:if test="${loginUser==null}">
			<button onclick="location.href='${path}/auth/loginCheck.do'">로그인</button>
		</c:if>

		<input type="button" value="로그아웃" id="btnLogout"> <img
			src="${pageContext.request.contextPath}/images/umbrella.jpg"
			width="200" height="150">
	</div>
</div>