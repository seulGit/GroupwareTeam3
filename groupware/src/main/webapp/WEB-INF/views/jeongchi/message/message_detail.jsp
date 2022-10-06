<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% String ctxPath = request.getContextPath();%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>JaeHee Group</title>
<link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"	rel="stylesheet" />
<link href="../resources/css/styles.css?ver=1" rel="stylesheet" />
<link href="../resources/css/message/message_write.css?ver=1" rel="stylesheet" />
<script src="../resources/js/jquery-3.6.0.min.js?ver=1"></script>
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
<script type="text/javascript" charset="utf-8"
	src="../resources/api/smarteditor/libs/smarteditor/js/service/HuskyEZCreator.js"></script>

</head> 

<script>


</script>

<%@ include file="/WEB-INF/views/intro.jsp"%>
<div id="layoutSidenav_content">
	<div class="content_box">쪽지보기</div>
	<div id="message_write_container">
		<div class="top_btn">
			<div class="write_div_btn"><a href="/message/write">답장 보내기</a></div>
		</div>
		<div class="message_write_insert_info">
			<table>
				<tr>
					<td class="message_td1">제목 </td>
					<td class="message_td2">${data.message_title}</td>
				</tr>
				<tr>
					<td class="message_td1">보낸사람</td>
					<td class="message_td2">${data.message_sender}</td>
				</tr>
				<tr>
					<td class="message_td1">받는사람</td>
					<td class="message_td2">${data.message_receiver}</td>
				</tr>
				<tr>
					<td class="message_td1">작성일</td>
					<td class="message_td2">${data.message_datetime}</td>
				</tr>
			</table>
		</div>
		<div class="message_write_textarea">
			<div id="message_contents">${data.message_contents}</div>
		</div>
	</div>
</div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
<!--     <script src="../resources/js/message_jquery.js"></script> -->
<script src="../resources/js/message/message_write.js?ver=1"></script>
<script src="<c:url value='resources/js/officemap.js'/>"></script>
</body>

</html>