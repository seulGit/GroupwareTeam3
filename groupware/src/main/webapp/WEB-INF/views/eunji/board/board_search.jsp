<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>JaeHee Group</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="../../resources/css/styles.css" rel="stylesheet" />
    <link rel="stylesheet" href="../../resources/css/board/board.css">
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>
<body>
<table class="board_table">
                        <tr class="table_bg">
                            <td>글번호</td>
                            <td class="board_title_size">제목</td>
                            <td>작성자</td>
                            <td>작성일</td>
                            <td>조회수</td>
                        </tr>
                 
                        <c:forEach var="board_normal" items="${search}">
                        <tr class="board_table_hover">
                            <td>${board_normal.board_num}</td>
                            <td class="table_title_center"><a href="/board_detail?board_num=${board_normal.board_num}">${board_normal.board_title}</a></td>
                            <td>${board_normal.emp_name}</td>
                             <fmt:parseDate value="${board_normal.board_write_date}" pattern="yyyy-MM-dd'T'HH:mm" var="board_normal_date" type="both" />
                            <td><fmt:formatDate value="${board_normal_date}" pattern="yyyy-MM-dd a HH:mm:ss" /></td>
                            <td>${board_normal.board_view_count}</td>
                        </tr> 
                        </c:forEach>
                        </table>
                      

</body>