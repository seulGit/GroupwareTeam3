<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />

<link rel="stylesheet" href="<c:url value='/resources/css/styles.css'/>" />
<link rel="stylesheet"
	href="<c:url value='/resources/css/address/address_all.css'/>" />
<link rel="stylesheet"
	href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css" />
<script src="../resources/js/jquery-3.6.0.min.js"></script>
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js"
	crossorigin="anonymous"></script>
<meta charset="EUC-KR">

</head>

<!-- ÃÊ¼º Æû -->
<c:forEach var="row" items="${data}">
	<tr class="address_all_list_foreach">
		<td><i class="xi-user-o"></i>
		<a href="/address_all_info?emp_num=${row.emp_num}">${row.emp_name}</a></td>
		<td>${row.position_grade}</td>
		<td>${row.emp_phonenum}</td>
		<td>${row.emp_email}</td>
		<td>${row.dept_name}</td>
		<td>${row.emp_desk_num}</td>
		<td>${row.emp_address}</td>

	</tr>
</c:forEach>

