// 이은지 
let delete_btn = document.querySelectorAll(".delete_btn");		    		// 게시글 삭제 버튼
let board_comment_submit = document.querySelector("#board_comment_submit"); // 답글 버튼	 
let board_comment_input = document.querySelector("#board_comment_input");	// 답글 text 박스
let comment_modify_btn = document.querySelectorAll(".comment_modify_btn:hover"); // 댓글 수정 버튼
let comment_delete_btn = document.querySelectorAll(".comment_delete_btn:hover"); // 댓글 삭제 버튼


// 221006 김정치 등록 ---------------------------------------------------------------------
let board_list_btn = document.querySelector(".board_list_btn")      		// 목록보기 버튼
let board_td2 = document.querySelectorAll(".board_td2");         // board_category_subject 값 얻기위함
//------------------------------------------------------------------------------------

//김정치 등록 ----------------------------------------------------------------------------
//목록 클릭 시 해당 게시판으로 이동
board_list_btn.addEventListener("click", function(){
     if(board_td2[0].innerHTML == "일반게시판"){
        location.href = "/board_normal";
     } else if (board_td2[0].innerHTML == "공지게시판") {
        location.href = "/board_notice";
     }  else {
        location.href = "/board_docu";
     } 
});
// 이은지 -------------------------------------------------------------------------------
//게시글 삭제 버튼 클릭했을 때
for(let i=0; i<delete_btn.length; i++){
delete_btn[i].addEventListener("click", function(){
	  if(confirm("삭제하시겠습니까?")==true){
		this.parentNode.submit();
	  } else {
		 return false;
	  }
});
}



// 댓글 수정버튼 클릭 시 어떻게 해야하나

// 댓글 유효성 검사
board_comment_submit.addEventListener("click",function(){
	if(board_comment_input.value.length != 0 || board_comment_input.value.length != ""){
		alert("댓글이 입력되었습니다");
		this.parentNode.parentNode.submit();
		return true;
	} else {
		alert("댓글을 입력해주세요");
		return false;
	}
});


