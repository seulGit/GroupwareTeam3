const type_select = document.querySelector("#type_select");
const EDMS_docu = document.querySelector(".EDMS_docu");

function draft_ajax(docu_category) {
    $.ajax({
        url: docu_category,
        type: "POST",
        dataType: "text",
        contentType: "application/json",
        success: function (data) {
            EDMS_docu.innerHTML = data;
            ClassicEditor.create(document.querySelector('#editor'))
                .then(editor => {
                    window.editor = editor;
                })
            // 기안일
            const drafting_date = document.querySelector(".drafting_date");
            let date = new Date().toISOString()
            drafting_date.append(date.slice(0, 10));

            const EDMS_approval = document.querySelector(".EDMS_approval");

            EDMS_approval.addEventListener("click", function () {
                // 문서 제목
                const EDMS_title = document.querySelector(".EDMS_title");
                // 긴급 버튼
                const EDMS_new_impor = document.querySelector("#EDMS_new_impor");
                console.dir(editor.getData());
                console.log(EDMS_title.value);
                console.log(EDMS_new_impor.checked);
            })
        }
    })
}

type_select.addEventListener("change", function () {
    if (type_select.value == "general") {
        draft_ajax("general");
    } else if (type_select.value == "money") {
        draft_ajax("money");
    } else if (type_select.value == "certificate") {
        draft_ajax("certificate");
    }
})

const btn_bg_first = document.querySelector("#btn_bg_first");
const btn_bg_second = document.querySelector("#btn_bg_second");
const approver_modal = document.querySelector(".approver_modal");
const approver_emp_list_table = document.querySelector(".approver_emp_list_table");
const first_approver_name = document.querySelector("#first_approver_name");
const second_approver_name = document.querySelector("#second_approver_name");
const first_approver_dept = document.querySelector("#first_approver_dept");
const second_approver_dept = document.querySelector("#second_approver_dept");
const first_approver_position = document.querySelector("#first_approver_position");
const second_approver_position = document.querySelector("#second_approver_position");
const approver_reset_btn = document.querySelector("#approver_reset_btn");

let flag;
let select_count = 0;
btn_bg_first.addEventListener("click", function () {
    approver_modal.style.display = "block";
    flag = true;
})
btn_bg_second.addEventListener("click", function () {
    approver_modal.style.display = "block";
    flag = false;
})

approver_reset_btn.addEventListener("click", function (e) {
    console.dir(first_approver_dept);
    first_approver_name.textContent = null;
    first_approver_dept.childNodes[1].remove();
    first_approver_position.textContent = null;
    
    second_approver_name.textContent = null;
    second_approver_dept.childNodes[1].remove();
    second_approver_position.textContent = null;
    
    btn_bg_first.style.display = "block";
    btn_bg_second.style.display = "block";
    approver_reset_btn.style.display = "none";
})

approver_modal.addEventListener("click", function (e) {
    if (e.target.className == "approver_modal") {
        approver_modal.style.display = "none";
    }
})


// 중간결재자, 최종결재자 선택 시
approver_emp_list_table.addEventListener("click", function (e) {

    // 선택한 태그이름이 TD일 경우만
    if (e.target.tagName == "TD") {

        //flag가
        if (flag) {
            first_approver_name.append(e.target.parentNode.children[0].textContent);
            first_approver_dept.append(e.target.parentNode.children[1].textContent);
            first_approver_position.append(e.target.parentNode.children[2].textContent)

            btn_bg_first.style.display = "none";
            select_count_check();
        } else {
            second_approver_name.append(e.target.parentNode.children[0].textContent);
            second_approver_dept.append(e.target.parentNode.children[1].textContent);
            second_approver_position.append(e.target.parentNode.children[2].textContent);

            btn_bg_second.style.display = "none";
            select_count_check();
        }
        approver_modal.style.display = "none";
    }

})

function select_count_check(){
    select_count++;
    if(select_count == 2){
        approver_reset_btn.style.display = "block";
        select_count = 0;
    }
}