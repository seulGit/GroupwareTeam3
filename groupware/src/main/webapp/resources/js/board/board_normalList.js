// 검색 ajax
let board_search_btn = document.querySelector("#board_search_btn");		 		// 검색버튼
let board_search_input = document.querySelector("#board_search_input");  		// input box
let board_search = document.querySelector("#board_search_select");		 		// 검색 옵션
let board_search_container = document.querySelector(".board_search_container"); // ajax 나오는 부분
let board_container = document.querySelector(".board_container");	
let board_title_view_count= document.querySelector(".board_title_view_count"); // 게시글 제목



//게시글 검색
board_search_btn.addEventListener("click", function(){
	 let keyword = board_search_input.value;
	 let board_search_option = board_search.value;
	 let board_keyword = {
			 keyword : keyword,
			 board_search : board_search_option
	 };
	 $.ajax({
		type:"POST",
		url:"/board_search",
		dataType:"text",
		contentType: "application/json",
		data : JSON.stringify(board_keyword),
		success : function(data){
			$(board_container).html(data);
			console.log(data);
		},
		error : function(data){
			console.log(data);
		}
	 });
});

//게시글 제목 클릭 시 조회수 증가
board_title_view_count.addEventListener("click", function(){
	  this.parentNode.submit(); 
});