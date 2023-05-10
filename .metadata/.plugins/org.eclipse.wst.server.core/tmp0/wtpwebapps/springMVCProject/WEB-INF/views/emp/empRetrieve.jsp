<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

			<c:set var="totalSalary" value="0"></c:set>
			<c:forEach items="${empAll}" var="emp" varStatus="status">
				<c:set var="totalSalary" value="${totalSalary+emp.salary}"></c:set>
				<tr>
					<td
						style="background-color:${status.first||status.last?'orange':'pink'};">${status.count}</td>
					<td><a
						href="${path}/emp/empDetail.do?empid=${emp.employee_id}">${emp.employee_id}</a></td>
					<td><a
						style="color:${fn:length(emp.first_name)>3?'red':'blue'};"
						href="${path}/emp/empDetail.do?empid=${emp.employee_id}">${emp.first_name}</a></td>
					<td>${emp.last_name}</td>
					<td>${emp.email}${fn:substring(emp.email,0,3)}**
						${fn:indexOf(emp.email,"@")}**
						${fn:indexOf(emp.email,"@")>=0?fn:substring(emp.email,0,3):emp.email}

					</td>
					<td>${totalSalary}</td>
					<td><fmt:formatNumber value="${emp.salary}"
							groupingUsed="true"></fmt:formatNumber></td>
					<td><fmt:formatDate value="${emp.hire_date}"
							pattern="yyyy/MM/dd" /></td>

					<td>${emp.phone_number}</td>
					<td>${emp.job_id}</td>
					<td>${emp.manager_id}</td>
					<td>${emp.commission_pct}</td>
					<td><fmt:formatNumber type="percent"
							value="${emp.commission_pct}"></fmt:formatNumber></td>
					<td>${emp.department_id}</td>
					<td><button class="btnDel" data-del="${emp.employee_id}">삭제</button></td>
				</tr>

			</c:forEach>


