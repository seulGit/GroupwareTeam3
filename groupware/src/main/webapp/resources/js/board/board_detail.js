let delete_btn = document.querySelectorAll(".delete_btn");		    // 게시글 삭제 버튼

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