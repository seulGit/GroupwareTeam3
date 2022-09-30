/** 220904 이은지
 * 체크박스 전체 선택 / 해제 기능
 */

const checkboxes = document.querySelectorAll('.EDMS_tem_checkbox'); // 체크박스 생성
const selectAll = document.querySelector("#EDMS_tem_checkAll"); // 전체 체크박스 생성

// 체크박스 전체 선택 / 해제
  selectAll.addEventListener('click',function(){
    if(selectAll.checked==true){
      for(let i=0; i<checkboxes.length; i++){
        checkboxes[i].checked = true;
      }
    } else if (selectAll.checked==false){
      for(let i=0; i<checkboxes.length; i++){
        checkboxes[i].checked = false;
      }
    }
  });

// 체크박스 하나 해제 시 전체선택 체크박스 해제

  for(let i=0; i<checkboxes.length; i++){
    checkboxes[i].addEventListener("click",function(){
      const checked = document.querySelectorAll(".EDMS_tem_checkbox:checked");
      if(checkboxes.length == checked.length){
        selectAll.checked = true;
      } else {
        selectAll.checked = false;
      }
    })
  }



// 삭제 버튼 클릭 시 선택된 게시물 삭제 알림창
EDMS_tem_docu_del_btn.addEventListener("click",function(){
  const checked = document.querySelectorAll(".EDMS_tem_checkbox:checked");
  if(checked.length>=1){
    confirm("선택한 문서를 삭제하겠습니까?");
  } else if (checked.length==0){
    alert("선택된 문서가 없습니다");
  }
})
