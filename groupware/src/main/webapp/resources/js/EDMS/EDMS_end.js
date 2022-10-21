const EDMS_end_list_n_menu = document.querySelector(".EDMS_end_list_n_menu");

let list_length = 222;
// 페이징 처리
let address = location.href;

// 페이지의 시작은 1부터
const crt_page = address.slice(57, address.indexOf("&crt_block"));
// 블럭의 시작은 0부터
let crt_block = address.slice(address.indexOf("crt_block") + 10);

// 문서의 갯수가 10 미만일 경우
if (list_length > 10) {
    // 문서의 갯수를 10으로 쪼갠 후 올림 처리 (한 페이지에 문서가 10개씩 노출되기 때문)
    let total_page = (Math.ceil(list_length / 10));
    // 총 페이지가 1 이상일 경우
    if (total_page != 1) {
        // 현재 페이지가 1이 아닐 경우
        if (crt_page != 1) {
            // 이전 버튼을 생성
            const EDMS_pre_btn = document.createElement("a");
            EDMS_pre_btn.setAttribute("class", "EDMS_end_disabled");

            // 현재 페이지가 블럭의 첫 번째일 경우
            if(crt_page % 10 == 1){
                // 페이지와 블럭을 각각 1씩 줄인다
                EDMS_pre_btn.setAttribute("href",
                    `/EDMS/end?emp_num=${address.slice(39, 47)}&crt_page=${parseInt(crt_page) - 1}&crt_block=${parseInt(crt_block) - 1}`)
            } else{
                EDMS_pre_btn.setAttribute("href",
                    `/EDMS/end?emp_num=${address.slice(39, 47)}&crt_page=${parseInt(crt_page) - 1}&crt_block=${crt_block}`)
            }
            EDMS_pre_btn.innerText = "< 이전";
            EDMS_end_list_n_menu.append(EDMS_pre_btn);
        }
        // 1 ~ 10, 11 ~ 20, ... 총 10개의 버튼을 생성하기 위한 for 문
        // crt_block == 0 일 경우 0 * 10 == 0 / 1, 2, 3, ... 9, 10 생성
        // crt_block == 4 일 경우 4 * 10 == 40 / 41, 42, 43, ... 49, 50 생성
        for (let i = crt_block * 10; i < total_page; i++) {
            // crt_block * 10 부터 10개만 추출하기 위한 if 문
            // 0 나누기 10의 나머지는 0 (참) && 0은 0 * 10의 결과값과 같지 않다(거짓)
            // 7 나누기 10의 나머지는 7 (거짓) && 7은 0 * 10의 결과값과 같지 않다(참)
            // 10 나누기 10의 나머지는 10 (참) && 10은 0 * 10의 결과값과 같지 않다(참)
            if(i % 10 == 0 && i != crt_block * 10){
                break;
            }
            // 페이지 버튼 생성
            const page_btn = document.createElement("a");
            // for문은 0부터 시작하므로 i + 1
            // 0 + 1 == 1, 1 + 1 == 2, 2 + 1 == 3, ... 9 + 1 == 10
            page_btn.innerText = i + 1;
            // 현재 페이지와 i + 1의 값이 같지 않다면 a요소에 주소 맵핑
            if (crt_page != i + 1) {
                page_btn.setAttribute("href", `/EDMS/end?emp_num=${address.slice(39, 47)}&crt_page=${i + 1}&crt_block=${crt_block}`);
            } else { // 현재 페이지와 i + 1의 값이 같다면 현재 페이지를 뜻하는 클래스 추가 후 주소 속성 삭제
                page_btn.classList = "EDMS_end_current";
                page_btn.removeAttribute("href");
            }
            EDMS_end_list_n_menu.append(page_btn);
        }
        // 현재 페이지의 숫자가 전체 페이지의 갯수와 같지 않다면
        if (total_page != crt_page) {
            // 요소 생성
            const EDMS_next_btn = document.createElement("a");
            EDMS_next_btn.setAttribute("class", "EDMS_end_disabled");
            if (crt_page % 10 == 0) {
                EDMS_next_btn.setAttribute("href",
                    `/EDMS/end?emp_num=${address.slice(39, 47)}&crt_page=${parseInt(crt_page) + 1}&crt_block=${parseInt(crt_block) + 1}`)
            } else {
                EDMS_next_btn.setAttribute("href",
                    `/EDMS/end?emp_num=${address.slice(39, 47)}&crt_page=${parseInt(crt_page) + 1}&crt_block=${crt_block}`)
            }
            EDMS_next_btn.innerText = "다음 >";
            EDMS_end_list_n_menu.append(EDMS_next_btn);
        }
    }
}