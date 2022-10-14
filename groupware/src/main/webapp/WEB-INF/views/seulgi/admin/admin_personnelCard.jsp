<%--
  Created by IntelliJ IDEA.
  User: oseulki
  Date: 2022/09/26
  Time: 12:03 PM
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
    <link href="/resources/css/admin/admin_personnelCard.css" rel="stylesheet"/>
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
            <div class="contents">
                <div class="search">
                    <span class="office_map_btn"><a href="">조직도 조회</a></span>
                    <span>사원이름</span>
                    <input type="text" value="" id="search_name">
                    <span>부서</span>
                    <select name="department" value="" id="search_department">
                        <option value="">전체</option>
                        <option value="CEO">CEO</option>
                        <option value="전략기획">전략기획</option>
                        <option value="경영지원">경영지원</option>
                        <option value="인사">인사</option>
                        <option value="영업">영업</option>
                        <option value="마켓팅">마켓팅</option>
                        <option value="IT">IT</option>
                    </select>
                    <span>사원번호</span>
                    <input type="text" value="" id="search_num">
                    <span>입사일</span>
                    <input type="date" value="" id="search_joindate">
                    <span>휴대폰번호</span>
                    <input type="text" value="" id="search_phone">
                    <span>메일주소</span>
                    <input type="email" value="" id="search_mail">
                    <i class="xi-search"></i>
                </div>
                <div class="tap">
                    <div class="tap_result">검색결과목록</div>
                    <div class="tap_details">상세내용</div>
                </div>
                <div class="result">
                    <div class="list">
                        <table>
                            <tr>
                                <td>이름</td>
                                <td>성별</td>
                                <td>부서</td>
                                <td>사원번호</td>
                                <td>입사일</td>
                                <td>휴대폰번호</td>
                                <td>메일주소</td>
                            </tr>
                        </table>
                        <table class="result_table">

                        </table>
                    </div>
                    <div class="details">
                        <div class="details_left">
                            <div class="details_name box">
                                <div>이름</div>
                                <input type="text" id="detail_name" name="emp_name">
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
                                <input type="text" id="detail_birth" name="emp_birth">
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
                                <input type="text" id="detail_position" name="position_grade">
                            </div>
                            <div class="details_dept box">
                                <div>유선번호</div>
                                <input type="text" id="detail_deskTel" name="emp_desk_num">
                            </div>
                            <div class="details_phone box">
                                <div>휴대폰번호</div>
                                <input type="text" id="detail_phonenum" name="emp_phonenum">
                            </div>
                            <div class="details_email box">
                                <div>메일주소</div>
                                <input type="text" id="detail_email" name="emp_email">
                            </div>
                            <div class="details_address box">
                                <div>주소</div>
                                <div class="address_body">
                                    <button class="zip_btn">주소검색</button>
                                    <input type="text" id="detail_address_one" name="emp_address" class="address_one"
                                           placeholder="주소">
                                    <input type="text" id="detail_address_two" name="emp_address2" class="address_two"
                                           placeholder="상세주소">
                                </div>
                            </div>
                        </div>
                        <div class="details_right">
                            <div class="details_empcode box">
                                <div>사원번호</div>
                                <input type="text" id="detail_num" name="emp_num" readonly>
                            </div>
                            <div class="details_auth box">
                                <div>권한</div>
                                <input type="text" id="detail_auth" name="auth_code" readonly>
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
                                <input type="text" id="detail_joindate" name="join_date">
                            </div>
                            <div class="details_leavedate box">
                                <div>퇴사일</div>
                                <input type="text" id="detail_leavedate" value="" name="leave_date">
                            </div>
                            <div class="details_initPW box">
                                <div>비밀번호</div>
                                <input type="hidden" id="details_initPW" name="emp_pw">
                                <input type="hidden" id="details_initCheck" value=1 name="initCheck">
                                <button id="detail_initPW_btn" name="emp_pw">초기화</button>
                                <p style="color: red; font-size: 5px;">&nbsp;&nbsp;* 하단의 수정버튼 클릭 시 반영됩니다.</p>
                            </div>
                        </div>

                        <div class="details_btn">
                            <button class="btn_modify">수정</button>
                            <button class="btn_delete">삭제</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
<%--<script src="../resources/js/admin/admin_personnelCard.js"></script>--%>
<script src="<c:url value="/resources/js/admin/admin_personnelCard.js"/>"></script>
<script src="<c:url value='/resources/js/officemap.js'/>"></script>
</body>
</html>
