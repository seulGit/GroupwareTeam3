<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<body class="sb-nav-fixed">
    <nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
        <!-- Navbar Brand-->
        <c:if test="${sessionScope.auth_code == 'normal'}">
        <a class="navbar-brand ps-3" href="../main">JaeHee</a>
        </c:if>
        <c:if test="${sessionScope.auth_code == 'admin'}">
        <a class="navbar-brand ps-3" href="../main_admin">JaeHee</a>
        </c:if>
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
                    <li><a class="dropdown-item" href="/">Logout</a></li>
                </ul>
            </li>
        </ul>
    </nav>
    <div id="layoutSidenav">
        <div id="layoutSidenav_nav">
            <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                <div class="sb-sidenav-menu">
                    <div class="nav">
                        <c:if test="${sessionScope.auth_code == 'normal'}">
                            <a class="nav-link" href="../main">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Home
                            </a>
                        </c:if>
                        <c:if test="${sessionScope.auth_code == 'admin'}">
                            <a class="nav-link" href="../main_admin">
                                <div class="sb-nav-link-icon"><i class="fas fa-tachometer-alt"></i></div>
                                Home
                            </a>
                        </c:if>
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                            data-bs-target="#collapse_message" aria-expanded="false" aria-controls="collapse_message">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            	쪽지
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collapse_message" aria-labelledby="headingOne"
                            data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="../message/write">쪽지쓰기</a>
                                <a class="nav-link" href="../message/message_receive">받은쪽지함</a>
                                <a class="nav-link" href="../message/message_send">보낸쪽지함</a>
                                <a class="nav-link" href="../message/message_important">중요쪽지함</a>
                                <a class="nav-link" href="../message/message_temp">임시보관함</a>
                            </nav>
                        </div>
                        <c:if test="${sessionScope.auth_code eq 'normal'}">
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseEDMS"
                            aria-expanded="false" aria-controls="collapseEDMS">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            	전자결재
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collapseEDMS" aria-labelledby="headingOne"
                            data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="../EDMS/home?emp_num=${sessionScope.emp_num}">전자결재홈</a>
                                <a class="nav-link" href="../EDMS/new">새결재진행</a>
                                <a class="nav-link" href="../EDMS/Temporary_box?emp_num=${sessionScope.emp_num}">임시보관함</a>
                                <a class="nav-link" href="../EDMS/wait?emp_num=${sessionScope.emp_num}&crt_page=1&crt_block=0">결재대기중</a>
                                <a class="nav-link" href="../EDMS/ing?emp_num=${sessionScope.emp_num}&crt_page=1&crt_block=0">진행중문서</a>
                                <a class="nav-link" href="../EDMS/end?emp_num=${sessionScope.emp_num}&crt_page=1&crt_block=0">완료문서</a>
                            </nav>
                        </div>


                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                            data-bs-target="#collapse_worktime" aria-expanded="false" aria-controls="collapse_worktime">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            	근태관리
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collapse_worktime" aria-labelledby="headingOne"
                            data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="/worktime">근태관리홈</a>
                                <a class="nav-link" href="/vacation_new">연차신청하기</a>
                                <a class="nav-link" href="/vacation_wait">승인대기중</a>
                                <a class="nav-link" href="/vacation_ing">진행중문서</a>
                                <a class="nav-link" href="/vacation_end">완료문서</a>
                                <a class="nav-link" href="/worktime_view">출퇴근현황</a>
                            </nav>
                        </div>
                        <a class="nav-link" href="/todo">
                            <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                            	ToDo+
                        </a>
                        <a class="nav-link collapsed" href="/calendar" >
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                              	 일정
                        </a>
                    	<a class="nav-link collapsed" href="/booking">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                           	    예약
                        </a>
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                            data-bs-target="#collapse_board" aria-expanded="false" aria-controls="collapse_board">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            	게시글
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collapse_board" aria-labelledby="headingOne"
                            data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                            	<a class="nav-link" href="/board_write">게시글작성</a>
                                <a class="nav-link" href="/board_notice">공지게시판</a>
                                <a class="nav-link" href="/board_normal">일반게시판</a>
                                <a class="nav-link" href="/board_docu">자료실</a>
                            </nav>
                        </div>
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse"
                            data-bs-target="#collaps_address" aria-expanded="false" aria-controls="collapse_address">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            	주소록
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collaps_address" aria-labelledby="headingOne"
                            data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="/address_all">전사 주소록</a>
                                <a class="nav-link" href="/address_personal">개인 주소록</a>
                            </nav>
                        </div>
						</c:if>

                        <c:if test="${sessionScope.auth_code eq 'admin'}">
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseEDMS"
                           aria-expanded="false" aria-controls="collapseEDMS">
                            <div class="sb-nav-link-icon"><i class="fas fa-columns"></i></div>
                            관리자메뉴
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="collapseEDMS" aria-labelledby="headingOne"
                             data-bs-parent="#sidenavAccordion">
                            <nav class="sb-sidenav-menu-nested nav">
                                <c:if test="${sessionScope.authority_EDMS eq 1}">
                                <a class="nav-link" href="/admin/admin_EDMS">전자결재관리</a>
                                </c:if>
                                <c:if test="${sessionScope.authority_worktime eq 1}">
                                <a class="nav-link" href="/admin/admin_worktime">근태관리</a>
                                </c:if>
                                <c:if test="${sessionScope.authority_booking eq 1}">
                                <a class="nav-link" href="/admin/admin_booking">예약관리</a>
                                </c:if>
                                <c:if test="${sessionScope.authority_board eq 1}">
                                <a class="nav-link" href="/board_notice">게시글관리</a>
                                </c:if>
                                <c:if test="${sessionScope.authority_personnelCard eq 1}">
                                <a class="nav-link" href="/admin/admin_personnelCard">인사기록카드</a>
                                </c:if>
                                <c:if test="${sessionScope.authority_loginHistory eq 1}">
                                <a class="nav-link" href="/admin/admin_loginHistory">접속내역확인</a>
                                </c:if>
                                <c:if test="${sessionScope.authority_authority eq 1}">
                                <a class="nav-link" href="/admin/admin_authority">권한관리</a>
                                </c:if>
                            </nav>
                          </div>
                            </c:if>
                        <a class="nav-link" href="" id="officeMapClick">
                            <div class="sb-nav-link-icon"><i class="fas fa-table"></i></div>
                            	조직도
                        </a>
                    </div>
                </div>
                <div class="sb-sidenav-footer">
                    <div class="small">Logged in as:</div>
                    ${sessionScope.emp_name} ${sessionScope.position_grade}
                </div>
            </nav>
        </div>

         <div class="office_map_sidenav">

                    <div class="office_map_sidenav_box">
                        <div class="office_map_group"><i class="xi-angle-right-min"></i>JH그룹</div>
                        <div class="office_map_group_employee">
                            <div>
                            <div class="office_map_ceo">김정치 사장</div>
                        </div>
                            <div class="office_map_strategic_planning"><i class="xi-angle-right-min"></i>전략기획팀</div>
                            <div class="office_map_strategic_planning_team">

                                <div>백진주 부장</div>
                                <div>박예솔 사원</div>
                            </div>

                            <div class="office_map_management_support"><i class="xi-angle-right-min"></i>경영지원팀</div>
                            <div class="office_map_management_support_team">
                                <div>오슬기 부장</div>
                                <div>서승혁 대리</div>

                            </div>

                            <div class="office_map_hr"><i class="xi-angle-right-min"></i>인사팀</div>
                            <div class="office_map_hr_team">
                                <div>이은지 부장</div>
                                <div>이승재 인턴</div>

                            </div>

                            <div class="office_map_sales"><i class="xi-angle-right-min"></i>영업팀</div>
                            <div class="office_map_sales_team">
                                <div>성선규 부장</div>

                            </div>

                            <div class="office_map_marketing"><i class="xi-angle-right-min"></i>마케팅팀</div>
                            <div class="office_map_marketing_team">
                                <div>노현 부장</div>

                            </div>

                            <div class="office_map_it"><i class="xi-angle-right-min"></i>IT팀</div>
                            <div class="office_map_it_team">
                                <div>김형준 팀장</div>
                                <div>양광모 차장</div>
                            </div>

                        </div>
                    </div>

            </div>
        
