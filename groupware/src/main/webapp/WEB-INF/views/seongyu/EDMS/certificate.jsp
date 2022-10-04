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
                <td>증명서신청</td>
                <td colspan="5">
                    <div class="Approval_container">
                        <div></div>
                        <div></div>
                    </div>
                </td>
            </tr>
            <tr>
                <td>기안부서</td>
                <td>마케팅</td>
                <td>기안일</td>
                <td class="drafting_date"></td>
                <td>부서번호</td>
                <td>자동설정</td>
            </tr>
            <tr>
                <td>증명서종류</td>
                <td><input type="text"></td>
                <td>용도</td>
                <td><input type="text"></td>
                <td>제출처</td>
                <td><input type="text"></td>
            </tr>
            <tr>
                <td>제목</td>
                <td colspan="4">
                    <input type="text" class="EDMS_title" maxlength="39" placeholder="제목을 입력해주세요">
                </td>
                <td class="EDMS_new_impor_position">
                    <div>
                        긴급
                        <input type="checkbox" name="EDMS_new_impor" id="EDMS_new_impor">
                        <label for="EDMS_new_impor" class="EDMS_new_impor_switch">
                            <span class="EDMS_new_impor_btn"></span>
                        </label>
                    </div>
                </td>
            </tr>
        </table>
    </div>
    <div class="EDMS_new_api">
        <textarea name="text" id="editor"></textarea>
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
<script src="<c:url value="/resources/api/ckeditor5-35.1.0-aymulr9ct11c/build/ckeditor.js"/>"></script>