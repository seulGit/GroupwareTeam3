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


//사원등록
$(function () {
    $('.btn_register').click(function () {
        let register_name = document.querySelector("#detail_name").value;
        let register_gender = document.querySelector(".detail_gender").value;
        let register_birth = document.querySelector("#detail_birth").value;
        let dept_name_select = document.querySelector(".dept_name_select").value;
        let register_position = document.querySelector("#detail_position").value;
        let register_deskTel = document.querySelector("#detail_deskTel").value;
        let register_phonenum = document.querySelector("#detail_phonenum").value;
        let register_email = document.querySelector("#detail_email").value;
        let register_address_one = document.querySelector("#detail_address_one").value;
        let register_address_two = document.querySelector("#detail_address_two").value;
        let register_num = document.querySelector("#detail_num").value;
        let register_auth = document.querySelector("#detail_auth").value;
        let register_active = document.querySelector("#details_active").value;
        let register_joindate = document.querySelector("#detail_joindate").value;
        let register_leavedate = document.querySelector("#detail_leavedate").value;
        let register_pw = document.querySelector("#details_initPW").value;

        let register_details = {
            emp_name: register_name,
            emp_gender: register_gender,
            emp_birth: register_birth,
            dept_code: dept_name_select,
            position_grade: register_position,
            emp_desk_num: register_deskTel,
            emp_phonenum: register_phonenum,
            emp_email: register_email,
            emp_address: register_address_one,
            emp_address2: register_address_two,
            emp_num: register_num,
            auth_code: register_auth,
            emp_active: register_active,
            join_date: register_joindate,
            leave_date: register_leavedate,
            emp_pw: register_pw
        };


        console.log(register_details);

        $.ajax({
            type: "POST",
            url: "/admin/admin_personnelCardRegister",
            dataType: "text",
            data: register_details,
            success: function (data) {

                console.log(data);

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
            },
            error: function (error) {
                alert("오류발생. 사원번호 중복여부와 올바른 형식으로 입력했는지 확인하세요.")
            }
        });
    });
});


