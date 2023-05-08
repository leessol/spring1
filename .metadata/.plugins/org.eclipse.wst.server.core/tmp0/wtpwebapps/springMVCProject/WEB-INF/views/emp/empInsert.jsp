<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="errorPage.jsp"%>
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원등록</title>
<%@ include file ="../common/commonfiles.jsp" %>


<style>
table{
	border: 1px solid #585858;
	border-collapse: collapse;
}

td {
	padding: 20px;
	border: 1px solid #585858;
}
</style>
</head>
<body>

<%@ include file="../common/header.jsp" %>
<h1>직원정보 입력</h1>




<form method="post" action="<%=request.getContextPath()%>/emp/empinsert.do">
<table>
  <tr  class="form-floating">
    <td><label for="employee_id">직원번호</label></td>
    <td><input class="form-control"  type="number" 
    name="employee_id" id="employee_id" 
    required="required"
    placeholder="직원번호는sequence처리함"
    autofocus="autofocus"
    value="999"
   disabled="disabled"
   
   
   
    
    ></td>
  </tr>
  <tr>
    <td>firstName</td>
    <td><input type="text" name="first_name"></td>
  </tr>
  <tr>
    <td>LastName</td>
    <td><input type="text" name="last_name" required="required"></td>
  </tr>
  <tr>
    <td>이메일</td>
    <td><input type="email" name="email" required="required"></td>
  </tr>
  <tr>
    <td>phone</td>
    <td><input type="tel" name="phone_number" pattern="010-[0-9]{4}-[0-9]{4}"></td>
  </tr>
  <tr>
    <td>salary</td>
    <td><input type="number" name="salary" ></td>
  </tr>
  <tr>
    <td>부서</td>
    <td>
    <select name="department_id">
    	<c:forEach items="${deptList}" var="dept">
    		<!-- 디비에 들어가는 것은 id값이 들어가야 하니깐 value에는 id로 한다.  -->
    		<option value="${dept.department_id}">${dept.department_name}</option>
    	</c:forEach>
    </select>
    </td>
  </tr>
  <tr>
    <td>메니져</td>
    <td>
    <select name="manager_id">
    	<c:forEach items="${managerList}" var="manager">
    		<!-- 디비에 들어가는 것은 id값이 들어가야 하니깐 value에는 id로 한다.  -->
    		<option value="${manager.employee_id}">${manager.first_name}---${manager.last_name}</option>
    	</c:forEach>
    </select>
    </td>
  </tr>
  <tr>
    <td>커미션</td>
    <td><input type="text" name="commission_pct" ></td>
  </tr>
  <tr>
    <td>입사일</td>
    <td><input type="date" name="hire_date" required="required"></td>
  </tr>
  <tr>
    <td>직급</td>
    <td>
    <select name="job_id">
    	<c:forEach items="${jobList}" var="job">
    		<!-- 디비에 들어가는 것은 id값이 들어가야 하니깐 value에는 id로 한다.  -->
    		<option value="${job.job_id}">${job.job_title}</option>
    	</c:forEach>
    </select>	
    </td>
  </tr>
  <tr>
    <td colspan="2">
       <input type="submit" value="직원등록">
    </td>
  </tr>
</table>
</form>
</body>
</html>