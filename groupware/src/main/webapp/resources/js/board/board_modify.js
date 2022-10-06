let board_cancel_btn = document.querySelector(".board_cancel_btn"); // 게시판 작성 취소 버튼

//ck editor
CKEDITOR.replace('ckeditor', {
	  // 너비설정
	  width: '1505',
	  height: '459'
});


//게시글 작성 시 취소 버튼 클릭했을 때 
board_cancel_btn.addEventListener("click", function(){
	if(confirm("작성 취소하시겠습니까?")==true){
		 location.href="/board_normal";
	}
}); 