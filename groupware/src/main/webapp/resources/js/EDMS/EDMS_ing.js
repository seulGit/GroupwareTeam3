const EDMS_ing_list_n_menu = document.querySelector(".EDMS_ing_list_n_menu");

// 페이징 처리
let address = location.href;

const crt_page = address.slice(57, address.indexOf("&crt_block"));
let crt_block = address.slice(address.indexOf("crt_block") + 10);

if (list_length > 10) {
    let total_page = (Math.ceil(list_length / 10));
    if (total_page != 1) {
        if (crt_page != 1) {
            const EDMS_pre_btn = document.createElement("a");
            EDMS_pre_btn.setAttribute("class", "EDMS_ing_disabled");
            if(crt_page % 10 == 1){
                EDMS_pre_btn.setAttribute("href", `/EDMS/ing?emp_num=${address.slice(39, 47)}&crt_page=${parseInt(crt_page) - 1}&crt_block=${parseInt(crt_block) - 1}`)
            } else{
                EDMS_pre_btn.setAttribute("href", `/EDMS/ing?emp_num=${address.slice(39, 47)}&crt_page=${parseInt(crt_page) - 1}&crt_block=${crt_block}`)
            }
            EDMS_pre_btn.innerText = "< 이전";
            EDMS_ing_list_n_menu.append(EDMS_pre_btn);
        }
        for (let i = crt_block * 10; i < total_page; i++) {
            if(i % 10 == 0 && i != crt_block * 10){
                break;
            }
            const page_btn = document.createElement("a");
            page_btn.innerText = i + 1;
            if (crt_page != i + 1) {
                page_btn.setAttribute("href", `/EDMS/ing?emp_num=${address.slice(39, 47)}&crt_page=${i + 1}&crt_block=${crt_block}`);
            } else {
                page_btn.classList = "EDMS_ing_current";
                page_btn.removeAttribute("href");
            }
            EDMS_ing_list_n_menu.append(page_btn);
        }
        if (total_page != crt_page) {
            const EDMS_next_btn = document.createElement("a");
            EDMS_next_btn.setAttribute("class", "EDMS_ing_disabled");
            if (crt_page % 10 == 0) {
                EDMS_next_btn.setAttribute("href", `/EDMS/ing?emp_num=${address.slice(39, 47)}&crt_page=${parseInt(crt_page) + 1}&crt_block=${parseInt(crt_block) + 1}`)
            } else {
                EDMS_next_btn.setAttribute("href", `/EDMS/ing?emp_num=${address.slice(39, 47)}&crt_page=${parseInt(crt_page) + 1}&crt_block=${crt_block}`)
            }
            EDMS_next_btn.innerText = "다음 >";
            EDMS_ing_list_n_menu.append(EDMS_next_btn);
        }
    }
}