//권한조회
$(function () {
    $('.xi-search').click(function () {
        let search_num = document.querySelector("#search_num").value;
        let search_name = document.querySelector("#search_name").value;
        let search_department = document.querySelector("#search_department").value;

        let authority_EDMS = document.querySelector(".authority_EDMS");
        let authority_worktime = document.querySelector(".authority_worktime");
        let authority_booking = document.querySelector(".authority_booking");
        let authority_board = document.querySelector(".authority_board");
        let authority_personnelCard = document.querySelector(".authority_personnelCard");
        let authority_loginHistory = document.querySelector(".authority_loginHistory");
        let authority_authority = document.querySelector(".authority_authority");


        //검색 부분
        let search_details = {
            emp_name: search_name,
            emp_num: search_num,
            dept_name: search_department,
            // authority_EDMS: authority_EDMS,
            // authority_worktime: authority_worktime,
            // authority_booking: authority_booking,
            // authority_board: authority_board,
            // authority_personnelCard: authority_personnelCard,
            // authority_loginHistory: authority_loginHistory,
            // authority_authority: authority_authority
        };

        console.log(search_details);

        $.ajax({
            type: "POST",
            url: "/admin/admin_authority/search",
            dataType: "text",
            contentType: "application/json",
            data: JSON.stringify(search_details),
            success: function (data) {
                $('.result_table').html(data);


                //배열과 객체 만들어서 담기
                let search_list_contents = document.querySelectorAll('.search_list_contents');
                console.log(search_list_contents);


                let btn_modify = document.querySelector('.btn_save');

                btn_modify.addEventListener('click', function(){

                    for(let i=0; i<search_list_contents.length; i++) {
                        let authority_array = [];
                        let authority_EDMS = 0;
                        let authority_worktime = 0;
                        let authority_booking = 0;
                        let authority_board = 0;
                        let authority_personnelCard = 0;
                        let authority_loginHistory = 0;
                        let authority_authority = 0;
                        let emp_num = search_list_contents[i].children[2].textContent;

                        if(search_list_contents[i].children[6].children[0].checked) {
                            authority_EDMS = 1;
                        }
                        if(search_list_contents[i].children[7].children[0].checked) {
                            authority_worktime = 1;
                        }
                        if(search_list_contents[i].children[8].children[0].checked) {
                            authority_booking = 1;
                        }
                        if(search_list_contents[i].children[9].children[0].checked) {
                            authority_board = 1;
                        }
                        if(search_list_contents[i].children[10].children[0].checked) {
                            authority_personnelCard = 1;
                        }
                        if(search_list_contents[i].children[11].children[0].checked) {
                            authority_loginHistory = 1;
                        }
                        if(search_list_contents[i].children[12].children[0].checked) {
                            authority_authority = 1;
                        }

                        authority_array.push(emp_num);
                        authority_array.push(authority_EDMS);
                        authority_array.push(authority_worktime);
                        authority_array.push(authority_booking);
                        authority_array.push(authority_board);
                        authority_array.push(authority_personnelCard);
                        authority_array.push(authority_loginHistory);
                        authority_array.push(authority_authority);

                        //배열넘길때 쓰는 형식
                        $.ajax({
                            type : "POST",
                            traditional : true,
                            url : "/admin/admin_authority/modify",
                            async: false, //동기
                            data: {authority_array:authority_array},
                            success : function(data) {
                            },
                            error : function(data) {
                                console.log(data);
                            }
                        });
                    }
                    alert("수정 완료");

                })


                // let search_list_contents = document.querySelectorAll('.search_list_contents');

                //
                // console.log(authority_EDMS.value);
                //
                // for (let i = 0; i < search_list_contents.length; i++) {
                //     if(search_list_contents[i].document.querySelector(".authority_EDMS").value == '1'){
                //         search_list_contents[i].children[6].checked = true;
                //     }
                // }

            },
            error: function (error) {
                alert("오류가 발생했습니다. 페이지를 새로고침해주세요")
                console.log(error)
            }
        });
    })
})


//첫번째 체크박스 기능 (목록 선택)


const all_check_btn = document.querySelector('.all_check_btn'); //최상단 체크박스

//최상단체크박스(전체선택) 체크&체크해제시 전체목록 체크&체크해제 기능
all_check_btn.addEventListener('click', function () { //최상단 체크박스
    let check_btn = document.querySelectorAll('.check_btn'); //목록 내 체크박스들

    // 클릭 시(체크되면)
    if (all_check_btn.checked != true) { //최상단 체크박스가 체크되어있는 경우
        for (let i = 0; i < check_btn.length; i++) { //for문(목록 내 체크박스들이 복수이기때문에)
            check_btn[i].checked = false; //목록 내 체크박스들이 모두 체크 해제된다
        }
    } else { //최상단 체크박스가 체크해제되어있는 경우
        for (let i = 0; i < check_btn.length; i++) {
            check_btn[i].checked = true; //목록 내 체크박스들이 모두 체크된다
        }
    }
});


//수정버튼클릭
//로컬스토리지에 id에 해당하는 체크여부 저장되고
//search_list_contents[i] 에 있는 checkbox[0]이 눌려있으면
//해당하는 id로 접속시
//intro jsp 에 관리자메뉴-전자결재관리 display none

