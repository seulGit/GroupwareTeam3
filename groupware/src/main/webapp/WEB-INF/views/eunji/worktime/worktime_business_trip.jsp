<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../resources/css/worktime/worktime_new.css">

</head>
<table class="input_table">
                        <tr class="input_table_size">
                            <td>외출신청서</td>
                            <td colspan="6"></td>
                        </tr>
                        <tr>
                            <td>기안부서</td>
                            <td class="table_size">${WorktimeNameMap.dept_name}</td>
                            <td>기안일</td>
                            <td class="table_size worktime_new_date"></td>
                            <td class="docu_num_width">문서번호</td>
                            <td class="table_size">자동설정</td>
                        </tr>

                  		<tr>
                     		<td>휴가 기간</td>
                            <td colspan="2" class="date_width"><input type="date" id="worktime_vacation_date"></td>
                    		<td>행선지</td>
                            <td colspan="2"><input type="text" id="worktime_docu_place"></td>
                  		</tr>   
                        <tr>
                           <td>제목</td>
                           <td colspan="6"><input type="text" id="worktime_docu_title"></td>
                        </tr>

                        <tr>
                            <td>사유</td>
                            <td colspan="6"><input type="text"  id="worktime_docu_reason"></td>
                        </tr>
                        <tr>
                        	<td>첨부 파일</td>
                        	<td colspan="6"><input type="file" id="file_text_align"></td>
                        </tr>
                    </table>
 <script src="../../resources/js/worktime/worktime_new.js"></script>

</html>