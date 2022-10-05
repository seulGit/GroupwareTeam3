/*
 * 220928 ~ 이은지
   ck에디터 추가
   221004 게시판 유효성 검사
 * 221005 취소버튼 클릭 시 화면 이동
 * 
 */

// 게시판 글 쓰기 
let board_select = document.querySelector("#board_select");	   		// 게시판 선택
let board_title = document.querySelector("#board_title");	   		// 게시판 제목
let board_text = document.querySelector("#ckeditor"); 		   		// 게시판 내용
let board_submit_btn = document.querySelector(".board_submit_btn"); // 게시판 작성 완료 버튼
let board_cancel_btn = document.querySelector(".board_cancel_btn"); // 게시판 작성 취소 버튼


// ck editor
  CKEDITOR.replace('ckeditor', {
	  // 너비설정
	  width: '1505',
	  height: '459'
  });
  
//게시판 유효성 검사
  board_submit_btn.addEventListener("click", function(e){
  	if(board_select.value == null || board_select.value == ""){
  		alert("게시판  카테고리를 선택해주세요");
  		 e.preventDefault();
  	}else if(board_title.value == null || board_title.value == ""){
  		alert("게시판 제목을 입력해주세요");
  		 e.preventDefault();
  	} else {
  		alert("게시글이 작성되었습니다");
  	}
  });

  // 게시글 작성 시 취소 버튼 클릭했을 때 
  board_cancel_btn.addEventListener("click", function(){
  	if(confirm("작성 취소하시겠습니까?")==true){
  		 location.href="/board_normal";
  	}
  });  