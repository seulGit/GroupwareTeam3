<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
<link rel="stylesheet" href="<c:url value='/resources/css/styles.css'/>" />
<link rel="stylesheet" href="<c:url value='/resources/css/address/address_all_info.css'/>" />
<link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css" />
<script src="<c:url value='/resources/js/jquery-3.6.0.min.js'/>"></script>
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>JaeHee Group</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/intro.jsp"%>
	<div id="layoutSidenav_content">
            <div class="address_all_info_title">
            연락처 정보
            </div>
			<form name="" method="POST" action="">
			 <c:forEach var="row" items="${addressInfo}">
            <table class="all_info_table">
           		<tr>
                    <td>이름</td>
                    <td>${row.emp_name}</td>
                </tr>
                <tr>
                    <td>부서</td>
                    <td>${row.dept_name}</td>
                </tr>
                <tr>
                    <td>직위</td>
                    <td>${row.position_grade}</td>
                </tr>
                <tr>
                    <td>이메일</td>
                    <td>${row.emp_email}</td>
                </tr>
                <tr>
                    <td>휴대폰</td>
                    <td>${row.emp_phonenum}</td>
                </tr>
                <tr>
                    <td>회사전화</td>
                    <td>${row.emp_desk_num}</td>
                </tr>
                <tr>
                    <td>주소</td>
                    <td>${row.emp_address}</td>
                </tr>
               
            </table>
             </c:forEach>
            </form>
            <a href="/address_all" class="goList">목록으로 이동</a>

        </div>
        
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
		
	<script src="<c:url value='resources/js/address/address_all_info.js'/>"></script>
	<!-- <script src="../resources/js/scripts.js"></script> -->
</body>
</html>    