<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>JaeHee Group</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="../../resources/css/styles.css" rel="stylesheet" />
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
    <link rel="stylesheet" href="../../resources/css/board/board_detail.css">
     <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>

<!-- 상단/왼쪽 메뉴 include -->
<%@ include file="/WEB-INF/views/intro.jsp" %>

        <div id="layoutSidenav_content">
            <div class="content_box">
                <i class="fa-solid fa-chalkboard-user"></i>게시글보기
            </div>
            <div id="board_write_container">                
                <div class="board_write_insert_info">
                      
                     <div class="board_bottom_btn">
                	 <!-- 게시글 작성자 외에 다른 사람이 수정/삭제하지 못함 -->
                	 <c:if test="${emp_num eq detailMap.emp_num}">
                	 <form action="/board_modify" method="get">
                    		<input type="submit" class="board_btn board_submit_btn" value="수정">
                    			<input type="hidden" name="board_num" value="${detailMap.board_num}">
                    			<input type="hidden" name="emp_num" value="${detailMap.emp_num}">
                    		</form>
                    		
                    		<form action="/board_delete" method="post">
                    			<input type="button" class="board_btn delete_btn" value="삭제">
                    			<input type="hidden" name="board_num" value="${detailMap.board_num}">
                    			<input type="hidden" name="emp_num" value="${detailMap.emp_num}">
                    		</form>
                    </c:if>
                    </div>
                
                    <table class="board_write_table board_write_top">
                        <tr>
                            <td class="board_td1">카테고리</td>
                            <td class="board_td2">${detailMap.board_category_subject}</td>
                        </tr>
                        <tr>
                            <td class="board_td1">글번호</td>
                            <td class="board_td2">${detailMap.board_num}
                            	<input type="hidden" name="board_num" value="${detailMap.board_num}"></td>
                        </tr>
                        <tr>
                            <td class="board_td1">제목<span><input type="checkbox" id="important">중요!</span></td>
                            <td class="board_td2">${detailMap.board_title}</td>
                        </tr>
                        <tr>
                            <td class="board_td1">작성자</td>
                            <td class="board_td2">${detailMap.dept_name} ${detailMap.emp_name}</td>
                        </tr>
                        <tr>
                            <td class="board_td1">작성일</td>
                            <td class="board_td2">${detailMap.board_write_date}</td>
                        </tr>
                        <tr>
                        	<td class="board_td1">첨부파일</td>
                        	<td class="board_te2">${detailMap.board_file_name}</td>
                        </tr>
                    </table>
                    
                    <!-- ckeditor -->
                 <div class="board_write_editor">
                    ${detailMap.board_contents}
                </div>
          
                <!-- 버튼 -->
                	 <div class="board_bottom_btn">
                    	<input type="button" class="board_btn board_list_btn" value="목록보기">                
                	</div>
                    
                </div>
                <!-- 댓글 -->
                <div id="board_form_commentinfo">
                <form action="/board_comment" method="post">
                    <div id="board_comment_count">
                        <h2><i class="fa-solid fa-comments"></i>댓글</h2>
                            <textarea name="comment_contents" id="board_comment_input" placeholder="댓글을 입력해 주세요."></textarea>
                    	<button type="submit" id="board_comment_submit">등록</button>
                    	<input type="hidden" name="emp_num" value="${emp_num}">
                    	<input type="hidden" name="board_num" value="${detailMap.board_num}"> 
                    </div>
                     </form>
                    
                	<!-- 댓글 생성 -->
                	<c:forEach var="board_comment" items="${board_comment}">
                    <div id="board_comments_con">
            			<div class="board_comment_box">
            				<div class="board_comment_name">${board_comment.dept_name} ${board_comment.emp_name}</div>
            				<div class="board_comment_date">${board_comment.comment_date}</div>
            				<div class="board_contents">${board_comment.comment_contents}</div>
            				
            				<c:if test="${emp_num eq board_comment.emp_num}"> 
            					<div class="board_comment_btn_box">
            						<form action="/comment_delete" method="post">
            							<i class="xi-close-min comment_delete_btn" title="삭제"></i>
            							<input type="hidden" name="comment_num" value="${board_comment.comment_num}">
            							<input type="hidden" name="board_num" value="${detailMap.board_num}">
            						</form>
            						
            						<form action="/comment_modify" method="post">
            							<i class="xi-border-color comment_modify_btn" title="수정"></i>
            							<input type="hidden" name="comment_num" value="${board_comment.comment_num}">
            							<input type="hidden" name="board_num" value="${detailMap.board_num}">
            						</form>
            					</div>
            				</c:if>
            				 
            			</div>
                    </div>
                    </c:forEach>
                    
                </div>  
                         
            </div>
        </div>
    </div>

    <script src = "resources/api/ckeditor4_full/ckeditor.js"></script>
    <script src="../../resources/js/board/board_detail.js"></script>
    <script src="<c:url value='resources/js/officemap.js'/>"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
     
    
</body>

</html>