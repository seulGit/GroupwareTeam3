<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link rel="stylesheet" href="../../resources/css/board/board_detail.css">
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>

</head>


<!-- 상단/왼쪽 메뉴 include -->
<%@ include file="/WEB-INF/views/intro.jsp" %>

        <div id="layoutSidenav_content">
            <div class="content_box">
                <i class="fa-solid fa-chalkboard-user"></i>게시글보기
            </div>
             
             <form action="/board_modify" method="post"> 
            <div id="board_write_container">               
                <div class="board_write_insert_info">
                    <table class="board_write_table">
                        <tr>
                            <td class="board_td1">카테고리</td>
                            <td class="board_td2"><select name="board_category_num" id="board_select">
                                <option value="500">공지사항</option>
                                <option value="600" selected>일반게시판</option>
                                <option value="700">자료실</option>
                            </select></td>
                        </tr>
                        <tr>
                            <td class="board_td1">글번호</td>
                            <td class="board_td2">${detailMap.board_num}</td>
                        </tr>
                        <tr>
                            <td class="board_td1">제목<span><input type="checkbox" id="important">중요!</span></td>
                            <td class="board_td2"><input type="text" name="board_title" value="${detailMap.board_title}" class="board_title"></td>
                        </tr>
                        <tr>
                            <td class="board_td1">작성자</td>
                            <td class="board_td2">${detailMap.dept_name} ${detailMap.emp_name}</td>
                        </tr>
                        <tr>
                            <td class="board_td1">작성일</td>
                             <fmt:parseDate value="${detailMap.board_write_date}" pattern="yyyy-MM-dd'T'HH:mm" var="board_normal_date" type="both" />
                            <td class="board_td2"><fmt:formatDate value="${board_normal_date}" pattern="yyyy-MM-dd a HH:mm:ss" /></td>
                        </tr>
                        <tr>
                        	<td class="board_td1">첨부파일</td>
                        	<td class="board_td2"><input type="file" name="board_file_route" value="${detailMap.board_file_route}"></td>
                        </tr>
                    </table>
                    
                    <!-- ckeditor -->
                 <div class="board_editor_box">
                    <textarea id="ckeditor" name="board_contents">${detailMap.board_contents}</textarea>
                </div>
                
                <!-- 버튼 -->
                <div class="board_bottom_btn">
                    <input type="submit" class="board_btn board_submit_btn" value="수정 완료">
                    <input type="button" class="board_btn board_cancel_btn" value="취소">
                    <input type="hidden" name="board_num" value="${detailMap.board_num}">
                </div>
                
                </div>
               
                <!-- 댓글 -->
<!--                 <div id="board_form_commentinfo">
                    <div id="board_comment_count">
                        <h2><i class="fa-solid fa-comments"></i>댓글
                            [<span id="comment_count" >0</span>]</h2>
                            <input id="board_comment_input" placeholder="댓글을 입력해 주세요.">
                    <button id="board_comment_submit">등록</button>
                    </div>
                    
                    <div id=board_comments_con>
            
                    </div>
                </div> -->  
                         
            </div>
             </form>
        </div>
    </div>


    <script src = "resources/api/ckeditor4_full/ckeditor.js"></script>
    <script src="../../resources/js/board/board_modify.js"></script>
    <script src="<c:url value='resources/js/officemap.js'/>"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
     
    
</body>

</html>