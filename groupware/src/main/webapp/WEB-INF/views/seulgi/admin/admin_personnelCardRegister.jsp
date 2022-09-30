<%--
  Created by IntelliJ IDEA.
  User: oseulki
  Date: 2022/09/26
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content=""/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>JaeHee Group</title>
    <%--    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet"/>--%>
    <link href="/resources/css/styles.css" rel="stylesheet"/>
    <link href="/resources/css/admin/admin_personnelCardRegister.css" rel="stylesheet"/>
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

</head>
<%@ include file="/WEB-INF/views/intro.jsp" %>

<div id="layoutSidenav_content">
    <div class="content_box">
        <i class="fa-solid fa-id-card"></i>인사기록카드
    </div>


    <!-- 기본정보_본문 -->
    <div class="admin_personnel_container">
        <div class="admin_personnel_sidebar">
            <div><a href="../admin/admin_personnelCard">조회</a></div>
            <div><a href="../admin/admin_personnelCardRegister">등록</a></div>
        </div>
        <div class="admin_personnel_body">
            <div class="details">
                <div class="details_left">
                    <div class="box">
                        <p>* 모든 항목이 필수입력사항입니다. </p>
                    </div>
                    <div class="details_name box">
                        <div>이름</div>
                        <input type="text" id="detail_name" name="emp_name" required>
                    </div>
                    <div class="details_gender box">
                        <div>성별</div>
                        <select name="emp_gender" class="detail_gender">
                            <option value="male" id="detail_gender_m">남</option>
                            <option value="female" id="detail_gender_f">여</option>
                        </select>
                    </div>
                    <div class="details_birth box">
                        <div>생년월일</div>
                        <input type="text" id="detail_birth" name="emp_birth" placeholder="yyyy-mm-dd" required>
                    </div>
                    <div class="details_dept box">
                        <div>부서</div>
                        <select name="dept_code" class="dept_name_select">
                            <option value="001" id="detail_department_sp">전략기획팀</option>
                            <option value="002" id="detail_department_bs">경영지원팀</option>
                            <option value="003" id="detail_department_hr">인사팀</option>
                            <option value="004" id="detail_department_sl">영업팀</option>
                            <option value="005" id="detail_department_mk">마켓팅팀</option>
                            <option value="006" id="detail_department_it">IT팀</option>
                            <option value="000" id="detail_department_CEO">CEO</option>
                        </select>
                    </div>
                    <div class="details_position box">
                        <div>직급</div>
                        <input type="text" id="detail_position" name="position_grade" placeholder="인턴/사원/대리/과장/차장/부장 등"
                               required>
                    </div>
                    <div class="details_dept box">
                        <div>유선번호</div>
                        <input type="text" id="detail_deskTel" name="emp_desk_num" placeholder="00-000-0000 형식으로 입력"
                               required>
                    </div>
                    <div class="details_phone box">
                        <div>휴대폰번호</div>
                        <input type="text" id="detail_phonenum" name="emp_phonenum" placeholder="000-0000-0000 형식으로 입력"
                               required>
                    </div>
                    <div class="details_email box">
                        <div>메일주소</div>
                        <input type="text" id="detail_email" name="emp_email" placeholder="jaehee@jaehee.com 형식으로 입력"
                               required>
                    </div>
                    <div class="details_address box">
                        <div>주소</div>
                        <div class="address_body">
                            <button class="zip_btn">주소검색</button>
                            <input type="text" id="detail_address_one" name="emp_address" class="address_one"
                                   placeholder="주소" required>
                            <input type="text" id="detail_address_two" name="emp_address2" class="address_two"
                                   placeholder="상세주소">
                        </div>
                    </div>
                </div>
                <div class="details_right">
                    <div class="box">
                        <p></p>
                    </div>
                    <div class="details_empcode box">
                        <div>사원번호</div>
                        <input type="text" id="detail_num" name="emp_num" placeholder="수정이 어려우니 신중하게 입력하세요." required>
                    </div>
                    <div class="details_auth box">
                        <div>권한</div>
                        <input type="text" id="detail_auth" name="auth_code" placeholder="normal/admin" required>
                    </div>
                    <div class="details_active box">
                        <div>활성화여부</div>
                        <select name="emp_active" class="details_active" id="details_active">
                            <option value="1" id="details_active_true">활성</option>
                            <option value="0" id="details_active_false">비활성</option>
                        </select>
                    </div>
                    <div class="details_regdate box">
                        <div>입사일</div>
                        <input type="text" id="detail_joindate" name="join_date" placeholder="yyyy-mm-dd" required>
                    </div>
                    <div class="box">
                        <p style="color: red; font-size: 5px;">* 초기 비밀번호 : Aa1!</p>
                    </div>
                    <div class="details_leavedate box">
                        <div></div><!--퇴사일-->
                        <input type="hidden" id="detail_leavedate" name="leave_date">
                    </div>
                    <div class="details_initPW box">
                        <div></div> <!--비밀번호-->
                        <input type="hidden" id="details_initPW" name="emp_pw" value="Aa1!">
                    </div>
                </div>
                <div class="details_btn">
                    <button class="btn_register">등록</button>
                    <button class="btn_cancel">취소</button>
                </div>
            </div>
        </div>
    </div>
</div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<script src="<c:url value="/resources/js/admin/admin_personnelCardRegister.js"/>"></script>
</body>
</html>
