<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>JaeHee Group</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="/src/main/webapp/resources/css/style.css" rel="stylesheet" />
    <link rel="stylesheet" href="/src/main/webapp/resources/css/EDMS/EDMS_Temporary_box.css">
    <link rel="stylesheet" href="//cdn.jsdelivr.net/npm/xeicon@2.3.3/xeicon.min.css">
    <link rel="stylesheet" href="../../../../resources/css/EDMS/EDMS_Temporary_box.css">
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
        <!-- Navbar Brand-->
        <a class="navbar-brand ps-3" href="../home.html">JaeHee</a>
        <!-- Sidebar Toggle-->
        <!-- <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!"><i
                class="fas fa-bars"></i></button> -->
        <!-- Navbar Search-->
        <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">
            <div class="input-group">
                <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..."
                    aria-describedby="btnNavbarSearch" />
                <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i
                        class="fas fa-search"></i></button>
            </div>
        </form>
        <!-- Navbar-->
        <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown"
                    aria-expanded="false"><i class="fas fa-user fa-fw"></i></a>
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                    <li><a class="dropdown-item" href="#!">Settings</a></li>
                    <li><a class="dropdown-item" href="#!">Activity Log</a></li>
                    <li>
                        <hr class="dropdown-divider" />
                    </li>
                    <li><a class="dropdown-item" href="#!">Logout</a></li>
                </ul>
            </li>
        </ul>
    </nav>
    <div id="layoutSidenav">
        <div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                <div class="sb-sidenav-menu">
                    <div class="nav">
                        <a class="nav-link" href="../home.html">
                            <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                            Home
                        </a>
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapse_message"
                            aria-expanded="false" aria-controls="collapse_message">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            쪽지
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collapse_message" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="../message/message_write.html">쪽지쓰기</a>
                                <a class="nav-link" href="../message/message_receive.html">받은쪽지함</a>
                                <a class="nav-link" href="../message/message_send.html">보낸쪽지함</a>
                                <a class="nav-link" href="../message/message_important.html">중요쪽지함</a>
                                <a class="nav-link" href="../message/message_temp.html">임시보관함</a>
                                <a class="nav-link" href="../message/message_reserved.html">예약쪽지함</a>
                                <a class="nav-link" href="../message/message_trash.html">휴지통</a>
                            </nav>
                        </div>
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseEDMS"
                            aria-expanded="false" aria-controls="collapseEDMS">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            전자결재
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collapseEDMS" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="EDMS_home.jsp">전자결재홈</a>
                                <a class="nav-link" href="EDMS_new.jsp">새결재진행</a>
                                <a class="nav-link" href="../EDMS/EDMS_Temporary_box.html">임시보관함</a>
                                <a class="nav-link" href="EDMS_wait.jsp">결재대기중</a>
                                <a class="nav-link" href="EDMS_ing.jsp">진행중문서</a>
                                <a class="nav-link" href="EDMS_end.jsp">완료문서</a>
                            </nav>
                        </div>
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapse_worktime"
                            aria-expanded="false" aria-controls="collapse_worktime">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            근태관리
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collapse_worktime" aria-labelledby="headingOne"
                            data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="../worktime/worktime_home.html">근태관리홈</a>
                                <a class="nav-link" href="../worktime/worktime_new.html">휴가계신청</a>
                                <a class="nav-link" href="../worktime/worktime_wait.html">승인대기중</a>
                                <a class="nav-link" href="../worktime/worktime_ing.html">진행중문서</a>
                                <a class="nav-link" href="../worktime/worktime_end.html">완료문서</a>
                                <a class="nav-link" href="../worktime/worktime_view.html">출퇴근현황</a>                            
                            </nav>
                         </div>
                        <a class="nav-link" href="../todo/todo.html">
                            <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                            ToDo+
                        </a>
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapse_calendar"
                            aria-expanded="false" aria-controls="collapse_calendar">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            일정
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collapse_calendar" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="../calendar/calendar_calendar.html">캘린더</a>
                                <a class="nav-link" href="../calendar/calendar_mycalendar.html">내 캘린더 관리</a>
                            </nav>
                        </div>
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapse_booking"
                            aria-expanded="false" aria-controls="collapse_booking">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            예약
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collapse_booking" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="../booking/booking_new.html">예약하기</a>
                                <a class="nav-link" href="../booking/booking_view.html">나의 예약 목록 </a>
                            </nav>
                        </div>
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapse_board"
                            aria-expanded="false" aria-controls="collapse_board">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            게시글
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collapse_board" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="../board/board_notice.html">공지게시판</a>
                                <a class="nav-link" href="../board/board_normal.html">일반게시판</a>
                                <a class="nav-link" href="../board/board_docu.html">자료실</a>
                            </nav>
                        </div>
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collaps_address"
                            aria-expanded="false" aria-controls="collapse_address">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            주소록
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collaps_address" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="../address/address_all.html">전사 주소록</a>
                                <a class="nav-link" href="../address/address_personal.html">개인 주소록</a>                                
                            </nav>
                        </div>
                        <a class="nav-link" href="../office_map/office_map.html">
                            <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                            조직도
                        </a>
                    </div>
                </div>
                <div class="sb-sidenav-footer">
                    <div class="small">Logged in as:</div>
                    Start Bootstrap
                </div>
            </nav>
        </div>
        <div id="layoutSidenav_content">
            <div class="content_box">
                임시보관함
            </div>

            <!-- 임시보관함 리스트 테이블 -->
            <div class="EDMS_tem_docu_list">
            <p>임시 저장된 문서</p>
            <button id="EDMS_tem_docu_del_btn"><i class="xi-trash"></i>삭제</button>
            <div class="EDMS_tem_docu_table_list">
            <table class="EDMS_tem_docu_table">
                <tr class="EDMS_tem_table_bg">
                    <td><input type="checkbox" name="EDMS_tem_checkAll" id="EDMS_tem_checkAll"></td>
                    <td>문서번호</td>
                    <td>기안일</td>
                    <td>결재양식</td>
                    <td>기안자</td>
                    <td style="width:40%">제목</td>
                    <td>첨부</td>
                </tr>
                <tr class="EDMS_tem_table_hover">
                    <td><input type="checkbox" name="EDMS_tem_checkbox" class="EDMS_tem_checkbox"></td>
                    <td>20203086</td>
                    <td>2021-12-10</td>
                    <td>품의서</td>
                    <td>김형준</td>
                    <td>교통비 신청 2</td>
                    <td><i class="xi-paper"></i></td>
                </tr>
                <tr class="EDMS_tem_table_hover">
                    <td><input type="checkbox" name="EDMS_tem_checkbox" class="EDMS_tem_checkbox"></td>
                    <td>20203075</td>
                    <td>2021-12-05</td>
                    <td>품의서</td>
                    <td>김형준</td>
                    <td>교통비 신청 </td>
                    <td></td>
                </tr>
            </table>
             </div>
              <!-- 페이지 넘버 -->
             <div class="EDMS_tem_list_number">
                <div>
                    <div class="EDMS_tem_list_n_menu">
                        <span class="EDMS_tem_disabled"><  이전</span>
                        <span class="EDMS_tem_current">1</span>
                        <a href="#?page=2">2</a>
                        <a href="#?page=3">3</a>
                        <span class="EDMS_tem_disabled">다음  ></span>                                
                    </div>                            
                </div>
            </div>
            </div>

                     </div>
                    </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
    <script src="../js/scripts.js"></script>
    <script src="/src/main/webapp/resources/js/EDMS/EDMS_Temporary_box.js"></script>
</body>

</html>