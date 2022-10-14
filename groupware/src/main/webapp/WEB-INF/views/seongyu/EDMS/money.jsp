<%--
  Created by IntelliJ IDEA.
  User: vongo
  Date: 2022-09-26
  Time: 오후 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>JaeHee Group</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet"/>
    <!-- <link href="<c:url value="/resources/css/EDMS/EDMS_new.css"/>" rel="stylesheet" /> -->
    <!-- <link rel="stylesheet" href="<c:url value="/resources/css/EDMS/EDMS_new.css"/>"> -->
    <link rel="stylesheet" href="../../../../resources/css/EDMS/EDMS_new.css">
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>
<div class="docu_input_box">
    <p>상세입력</p>
    <div class="docu_input_icon">
        <i class="xi-file-download" title="EXCEL파일 다운로드"></i>
        <i class="xi-print" title="프린트"></i>
    </div>

    <div class="table_box_thr">
        <table class="input_table">
            <tr class="input_table_size">
                <td colspan="4">비용품의서</td>
                <td colspan="2">
                    <div class="Approval_container">
                        <div class="approval_1_container">
                            <div>
                                중간결재자
                            </div>
                            <div class="approval_1_check">
                                
                            </div>
                            <div class="approval_1_name">

                            </div>
                            <div class="approval_1_check_date">

                            </div>
                        </div>
                        <div class="approval_2_container">
                            <div>
                                최종결재자
                            </div>
                            <div class="approval_2_check">

                            </div>
                            <div class="approval_2_name">

                            </div>
                            <div class="approval_2_check_date">
                                
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>기안부서</td>
                <td>${sessionScope.dept_name}</td>
                <td>기안일</td>
                <td class="drafting_date"></td>
                <td>부서번호</td>
                <td>${sessionScope.dept_code}</td>
            </tr>
            <tr>
                <td>용도</td>
                <td><input type="text" name="expense_purpose"
                           placeholder="필수 입력 사항입니다." maxlength="8"></td>
                <td>총비용</td>
                <td><input type="text" name="expense_total_expense" id="EDMS_money_table_size"
                           placeholder="필수 입력 사항입니다." maxlength="20">원</td>
                <td>비용처리방법</td>
                <td><input type="text" name="expense_payment" placeholder="필수 입력 사항입니다." maxlength="8"></td>
            </tr>
            <tr>
                <td>제목</td>
                <td colspan="4">
                    <input type="text" name="expense_docu_title" class="EDMS_title" maxlength="39"
                           placeholder="제목을 입력해주세요">
                </td>
                <td class="EDMS_new_impor_position">
                    <div>
                        긴급
                        <input type="checkbox" name="EDMS_docu_urgent" id="EDMS_new_impor">
                        <label for="EDMS_new_impor" class="EDMS_new_impor_switch">
                            <span class="EDMS_new_impor_btn"></span>
                        </label>
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <div class="EDMS_new_api">
        <textarea name="expense_docu_contents" id="editor"></textarea>
    </div>
    <%--  파일 첨부  --%>
    <div class="EDMS_docu_file_container">
        <div class="file_upload_container">
            <input type="text" class="upload_name" value="파일을 업로드하세요"
                   placeholder="파일을 업로드하세요" disabled>
            <label for="upload_file">파일 선택</label>
            <input name="file" type="file" id="upload_file">
        </div>
    </div>
    <div class="EDMS_result_write">
        <div>최종결재자 의견</div>
        <input type="text" id="EDMS_result">
    </div>
    <div class="EDMS_btn">
        <input type="submit" value="상신" class="EDMS_input_btn EDMS_approval">
        <input type="button" value="취소" class="EDMS_input_btn EDMS_cancel">
    </div>
</div>
<script src="<c:url value="/resources/api/ckeditor5-35.1.0-cfi81gg98uxz/build/ckeditor.js"/>"></script>