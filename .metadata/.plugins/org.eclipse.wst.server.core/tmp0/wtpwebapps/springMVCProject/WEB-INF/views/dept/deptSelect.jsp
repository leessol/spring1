
<%@page import="com.shinhan.vo.EmpVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="../common/commonfiles.jsp"%>
<style>
#container {
	
}

table {
	border: 1px solid #585858;
	margin: 0 auto;
}

h1 {
	font-size: 20;
	text-align: center;
}

th, td {
	padding: 20px;
	text-align: center;
}

th {
	color: white;
}

td {
	background-color: #F2F2F2;
}

tr th {
	background-color: #848484;
}
</style>

<script>
	
</script>
</head>
<body>
	<div id="container">
		<h1>부서목록</h1>
		<div class="text-center">
			<button onclick="location.href='/dept/deptInsert.do'" type="button"
				class="btn btn-success">부서 등록</button>
		</div>
		<table>
			<thead>
				<tr>
					<th>순서</th>
					<th>부서번호</th>
					<th>부서명</th>
					<th>매니져_id</th>
					<th>location_id</th>
					<th><button>삭제</button></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${deptAll}" var="dept" varStatus="status">

					<tr>
						<td
							style="background-color:${status.first||status.last?'orange':'pink'};">${status.count}</td>
						<%-- <td><a href="${path}/dept/deptDetail.do?deptid=${emp.employee_id}">${dept.department_id}</a></td> --%>
						<td><a href="${path}/dept/deptDetail.do?deptid=${dept.department_id}">${dept.department_id}</a></td>
						<%-- <td><a style="color:${fn:length(emp.first_name)>3?'red':'blue'};" href="${path}/emp/empDetail.do?empid=${dept.department_id}">${dept.department_id}</a></td> --%>
						<td>${dept.department_name}</td>
						<td>${dept.manager_id}</td>
						<%-- <td>${emp.email}${fn:substring(emp.email,0,3)}**
							${fn:indexOf(emp.email,"@")}**
							${fn:indexOf(emp.email,"@")>=0?fn:substring(emp.email,0,3):emp.email}
						</td> --%>
						<td>${dept.location_id}</td>
						<td><button class="btnDel" data-del="${dept.department_id}">삭제</button></td>
					</tr>
				</c:forEach>




			</tbody>
		</table>
	</div>
</body>
</html>