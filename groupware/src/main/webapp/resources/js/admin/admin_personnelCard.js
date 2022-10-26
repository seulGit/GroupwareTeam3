// 카카오 주소 찾기 api

const zip_btn = document.querySelector(".zip_btn"); //주소검색 버튼
let address_one = document.querySelector(".address_one"); //주소
let address_two = document.querySelector(".address_two"); //상세주소

zip_btn.addEventListener('click', function () {
    new daum.Postcode({
        oncomplete: function (data) { //선택시 입력값 세팅
            address_one.value = data.address; // 주소 넣기
            address_two.focus(); //상세입력 포커싱
        }
    }).open();
});

//인사기록카드

let detail_name = document.querySelector('#detail_name');
let detail_gender_m = document.querySelector('#detail_gender_m');
let detail_gender_f = document.querySelector('#detail_gender_f');
let detail_department_CEO = document.querySelector('#detail_department_CEO');
let detail_department_sp = document.querySelector('#detail_department_sp');
let detail_department_bs = document.querySelector('#detail_department_bs');
let detail_department_hr = document.querySelector('#detail_department_hr');
let detail_department_sl = document.querySelector('#detail_department_sl');
let detail_department_mk = document.querySelector('#detail_department_mk');
let detail_department_it = document.querySelector('#detail_department_it');
let detail_num = document.querySelector('#detail_num');
let detail_joindate = document.querySelector('#detail_joindate');
let detail_phonenum = document.querySelector('#detail_phonenum');
let detail_email = document.querySelector('#detail_email');
let detail_address_one = document.querySelector('#detail_address_one');
let detail_address_two = document.querySelector('#detail_address_two');
let detail_auth = document.querySelector("#detail_auth");
let details_initPW = document.querySelector('.details_initPW'); //비번초기화 박스
let detail_initPW_btn = document.querySelector("#detail_initPW_btn"); //비번초기화버튼
let detail_pw = document.querySelector("#details_initPW");
let detail_deskTel = document.querySelector("#detail_deskTel");
let detail_birth = document.querySelector("#detail_birth");
let detail_leavedate = document.querySelector("#detail_leavedate");
let details_active_true = document.querySelector("#details_active_true");
let details_active_false = document.querySelector("#details_active_false");
let detail_position = document.querySelector("#detail_position");


$(function () {
    $('.xi-search').click(function () {
        let search_name = document.querySelector("#search_name").value;
        let search_department = document.querySelector("#search_department").value;
        let search_num = document.querySelector("#search_num").value;
        let search_joindate = document.querySelector("#search_joindate").value;
        let search_phone = document.querySelector("#search_phone").value;
        let search_mail = document.querySelector("#search_mail").value;


        //검색 부분
        let search_details = {
            emp_name: search_name,
            dept_name: search_department,
            emp_num: search_num,
            join_date: search_joindate,
            emp_phonenum: search_phone,
            emp_email: search_mail
        };

        $.ajax({
            type: "POST",
            url: "/admin/admin_personnelCard/search",
            dataType: "text",
            contentType: "application/json",
            data: JSON.stringify(search_details),
            success: function (data) {
                $('.result_table').html(data);

                let search_list_contents = document.querySelectorAll('.search_list_contents');

                for (let i = 0; i < search_list_contents.length; i++) {
                    search_list_contents[i].addEventListener('click', function () {
                        //이름
                        detail_name.value = this.children[0].textContent;
                        //성별
                        if (this.children[1].textContent == 'male') {
                            detail_gender_m.selected = true;
                        } else {
                            detail_gender_f.selected = true;
                        }
                        //부서
                        switch (this.children[2].textContent) {
                            case "CEO" :
                                detail_department_CEO.selected = true;
                                break;
                            case "전략기획팀" :
                                detail_department_sp.selected = true;
                                break;
                            case "경영지원팀" :
                                detail_department_bs.selected = true;
                                break;
                            case "인사팀" :
                                detail_department_hr.selected = true;
                                break;
                            case "영업팀" :
                                detail_department_sl.selected = true;
                                break;
                            case "마켓팅팀" :
                                detail_department_mk.selected = true;
                                break;
                            case "IT팀" :
                                detail_department_it.selected = true;
                                break;

                        }
                        detail_num.value = this.children[3].textContent;
                        detail_joindate.value = this.children[4].textContent;
                        detail_phonenum.value = this.children[5].textContent;
                        detail_email.value = this.children[6].textContent;
                        detail_address_one.value = this.children[7].value;
                        detail_address_two.value = this.children[8].value;
                        detail_auth.value = this.children[9].value;
                        // detail_emp_pw.value = this.children[8].value;
                        detail_deskTel.value = this.children[11].value;
                        detail_birth.value = this.children[12].value;
                        detail_leavedate.value = this.children[13].value;

                        if (this.children[14].value !== "0") {
                            details_active_true.selected = true;
                        } else {
                            details_active_false.selected = true;
                        }
                        detail_position.value = this.children[15].value;
                        detail_pw.value = this.children[17].value;
                    })
                }

            },
            error: function (data) {
                alert("오류가 발생했습니다. 페이지를 새로고침해주세요")
            }
        });
    })
})

//비밀번호 초기화
detail_initPW_btn.addEventListener('click', function () {
    if(detail_pw.value == null || detail_pw.value == "") {
        alert("사원을 선택해주세요.");
    } else {
        detail_pw.value = "Zz1!";
        document.querySelector("#details_initCheck").value=0;
        alert("초기화 완료. 수정 버튼을 눌러야 반영됩니다.")
    }
});


//내용 수정


$(function () {
    $('.btn_modify').click(function () {
        let detail_name = document.querySelector("#detail_name").value;
        let detail_gender = document.querySelector(".detail_gender").value;
        let detail_birth = document.querySelector("#detail_birth").value;
        let dept_name_select = document.querySelector(".dept_name_select").value;
        let detail_position = document.querySelector("#detail_position").value;
        let detail_deskTel = document.querySelector("#detail_deskTel").value;
        let detail_phonenum = document.querySelector("#detail_phonenum").value;
        let detail_email = document.querySelector("#detail_email").value;
        let detail_address_one = document.querySelector("#detail_address_one").value;
        let detail_address_two = document.querySelector("#detail_address_two").value;
        let detail_num = document.querySelector("#detail_num").value;
        let detail_auth = document.querySelector("#detail_auth").value;
        let details_active = document.querySelector("#details_active").value;
        let detail_joindate = document.querySelector("#detail_joindate").value;
        let detail_leavedate = document.querySelector("#detail_leavedate").value;
        let detail_pw = document.querySelector("#details_initPW").value;
        let search_name = document.querySelector("#search_name").value;
        let search_department = document.querySelector("#search_department").value;
        let search_num = document.querySelector("#search_num").value;
        let search_joindate = document.querySelector("#search_joindate").value;
        let search_phone = document.querySelector("#search_phone").value;
        let search_mail = document.querySelector("#search_mail").value;
        let init_check = document.querySelector("#details_initCheck").value;

        let result_details = {
            emp_name: detail_name,
            emp_gender: detail_gender,
            emp_birth: detail_birth,
            dept_code: dept_name_select,
            position_grade: detail_position,
            emp_desk_num: detail_deskTel,
            emp_phonenum: detail_phonenum,
            emp_email: detail_email,
            emp_address: detail_address_one,
            emp_address2: detail_address_two,
            emp_num: detail_num,
            auth_code: detail_auth,
            emp_active: details_active,
            join_date: detail_joindate,
            leave_date: detail_leavedate,
            emp_pw: detail_pw,
            s_emp_name: search_name,
            s_dept_name: search_department,
            s_emp_num: search_num,
            s_join_date: search_joindate,
            s_emp_phonenum: search_phone,
            s_emp_email: search_mail,
            init_check: init_check
        };

        $.ajax({
            type: "POST",
            url: "/admin/admin_personnelCard/modify",
            dataType: "text",
            data: result_details,
            success: function (data) {
                $('.result_table').html(data);

                let search_list_contents = document.querySelectorAll('.search_list_contents');

                for (let i = 0; i < search_list_contents.length; i++) {
                    search_list_contents[i].addEventListener('click', function () {
                        //이름
                        document.querySelector("#detail_name").value = this.children[0].textContent;
                        //성별
                        if (this.children[1].textContent == 'male') {
                            detail_gender_m.selected = true;
                        } else {
                            detail_gender_f.selected = true;
                        }
                        //부서
                        switch (this.children[2].textContent) {
                            case "CEO" :
                                detail_department_CEO.selected = true;
                                break;
                            case "전략기획팀" :
                                detail_department_sp.selected = true;
                                break;
                            case "경영지원팀" :
                                detail_department_bs.selected = true;
                                break;
                            case "인사팀" :
                                detail_department_hr.selected = true;
                                break;
                            case "영업팀" :
                                detail_department_sl.selected = true;
                                break;
                            case "마켓팅팀" :
                                detail_department_mk.selected = true;
                                break;
                            case "IT팀" :
                                detail_department_it.selected = true;
                                break;

                        }
                        document.querySelector("#detail_num").value = this.children[3].textContent;
                        document.querySelector("#detail_joindate").value = this.children[4].textContent;
                        document.querySelector("#detail_phonenum").value = this.children[5].textContent;
                        document.querySelector("#detail_email").value = this.children[6].textContent;
                        document.querySelector("#detail_address_one").value = this.children[7].value;
                        document.querySelector("#detail_address_two").value = this.children[8].value;
                        document.querySelector("#detail_auth").value = this.children[9].value;
                        document.querySelector("#detail_deskTel").value = this.children[11].value;
                        document.querySelector("#detail_birth").value = this.children[12].value;
                        document.querySelector("#detail_leavedate").value = this.children[13].value;

                        if (this.children[14].value !== "0") {
                            details_active_true.selected = true;
                        } else {
                            details_active_false.selected = true;
                        }
                        document.querySelector("#detail_position").value = this.children[15].value;
                        document.querySelector("#details_initCheck").value = 1;
                    })
                }

            },
            error: function (error) {
                console.log(error);
            }

        });
    });
});



//내용 삭제

$(function () {
    $('.btn_delete').click(function () {
        let detail_name = document.querySelector("#detail_name").value;
        let detail_gender = document.querySelector(".detail_gender").value;
        let detail_birth = document.querySelector("#detail_birth").value;
        let dept_name_select = document.querySelector(".dept_name_select").value;
        let detail_position = document.querySelector("#detail_position").value;
        let detail_deskTel = document.querySelector("#detail_deskTel").value;
        let detail_phonenum = document.querySelector("#detail_phonenum").value;
        let detail_email = document.querySelector("#detail_email").value;
        let detail_address_one = document.querySelector("#detail_address_one").value;
        let detail_address_two = document.querySelector("#detail_address_two").value;
        let detail_num = document.querySelector("#detail_num").value;
        let detail_auth = document.querySelector("#detail_auth").value;
        let details_active = document.querySelector("#details_active").value;
        let detail_joindate = document.querySelector("#detail_joindate").value;
        let detail_leavedate = document.querySelector("#detail_leavedate").value;

        let search_name = document.querySelector("#search_name").value;
        let search_department = document.querySelector("#search_department").value;
        let search_num = document.querySelector("#search_num").value;
        let search_joindate = document.querySelector("#search_joindate").value;
        let search_phone = document.querySelector("#search_phone").value;
        let search_mail = document.querySelector("#search_mail").value;

        let result_details = {
            emp_num: detail_num,
            s_emp_name: search_name,
            s_dept_name: search_department,
            s_emp_num: search_num,
            s_join_date: search_joindate,
            s_emp_phonenum: search_phone,
            s_emp_email: search_mail
        };

        $.ajax({
            type: "POST",
            url: "/admin/admin_personnelCard/delete",
            dataType: "text",
            data: result_details,
            success: function (data) {
                $('.result_table').html(data);

                document.querySelector("#detail_name").value = '';
                document.querySelector("#detail_num").value = '';
                document.querySelector("#detail_joindate").value = '';
                document.querySelector("#detail_phonenum").value = '';
                document.querySelector("#detail_email").value = '';
                document.querySelector("#detail_address_one").value = '';
                document.querySelector("#detail_address_two").value = '';
                document.querySelector("#detail_auth").value = '';
                // detail_emp_pw.value = this.children[8].value;
                document.querySelector("#detail_deskTel").value = '';
                document.querySelector("#detail_birth").value = '';
                document.querySelector("#detail_leavedate").value = '';
                document.querySelector("#detail_position").value = '';


                let search_list_contents = document.querySelectorAll('.search_list_contents');

                for (let i = 0; i < search_list_contents.length; i++) {
                    search_list_contents[i].addEventListener('click', function () {
                        //이름
                        document.querySelector("#detail_name").value = this.children[0].textContent;
                        //성별
                        if (this.children[1].textContent == 'male') {
                            detail_gender_m.selected = true;
                        } else {
                            detail_gender_f.selected = true;
                        }
                        //부서
                        switch (this.children[2].textContent) {
                            case "CEO" :
                                detail_department_CEO.selected = true;
                                break;
                            case "전략기획팀" :
                                detail_department_sp.selected = true;
                                break;
                            case "경영지원팀" :
                                detail_department_bs.selected = true;
                                break;
                            case "인사팀" :
                                detail_department_hr.selected = true;
                                break;
                            case "영업팀" :
                                detail_department_sl.selected = true;
                                break;
                            case "마켓팅팀" :
                                detail_department_mk.selected = true;
                                break;
                            case "IT팀" :
                                detail_department_it.selected = true;
                                break;

                        }
                        document.querySelector("#detail_num").value = this.children[3].textContent;
                        document.querySelector("#detail_joindate").value = this.children[4].textContent;
                        document.querySelector("#detail_phonenum").value = this.children[5].textContent;
                        document.querySelector("#detail_email").value = this.children[6].textContent;
                        document.querySelector("#detail_address_one").value = this.children[7].value;
                        document.querySelector("#detail_address_two").value = this.children[8].value;
                        document.querySelector("#detail_auth").value = this.children[9].value;
                        // detail_emp_pw.value = this.children[8].value;
                        document.querySelector("#detail_deskTel").value = this.children[11].value;
                        document.querySelector("#detail_birth").value = this.children[12].value;
                        document.querySelector("#detail_leavedate").value = this.children[13].value;

                        if (this.children[14].value !== "0") {
                            details_active_true.selected = true;
                        } else {
                            details_active_false.selected = true;
                        }
                        document.querySelector("#detail_position").value = this.children[15].value;
                    })
                }

            },
            error: function (error) {
                console.log(error);
            }

        });
    });
});





