/*
 * 이은지
 * 220912
 * + 클릭 시 모달 생성 
 * 버튼 클릭 시 빈 값 확인
 * 220925 
 * todo 글 작성 후 ajax로 보여지기
 * 220926 
 * todo 버튼 위치 수정
 * 220927
 * todo 삭제 기능 
 * 220928 
 * todo 수정 모달창 값 가져오기
 * 아이콘 클릭 시 수정 모달창 이벤트 방지
 * */

// 모달
let todo_back = document.querySelector(".todo_modal_back"); // 모달 뒷배경
let todo_modal = document.querySelectorAll(".todo_modal");	// 모달
let todo_add = document.querySelector(".todo_add");			// create todo 버튼
let todo_save = document.querySelector(".todo_save"); 		// 모달 창의 저장버튼
let todo_cancel = document.querySelector(".todo_cancel");   // 모달 창의 취소버튼
let todo_modify = document.querySelector(".todo_modify"); 	// 모달 창의 수정버튼

// 빈 값 확인
let todo_title = document.querySelector("#todo_modal_title");  // todo 제목
let todo_text = document.querySelector("#todo_modal_text");    // todo 내용
let todo_write = document.querySelector(".my_board_list");     // todo가 들어갈 공간

// 아이콘
let star = document.querySelectorAll(".xi-star-o"); 			// 별 아이콘
let x_icon = document.querySelectorAll(".xi-close-min"); 		// x 아이콘

// 수정 모달창
let my_board_modal = document.querySelectorAll(".my_content_box");  // 모달창

// create todo 버튼 클릭 시 모달 창 보이기
todo_add.addEventListener("click", function(){
    todo_back.style.display="block";
});

// 취소버튼 클릭 시 모달 창 사라지기
todo_cancel.addEventListener("click", function(){
     todo_back.style.display="none";
     todo_save.style.display='block';
		todo_modify.style.display="none";
		todo_title.value='';
		todo_text.value='';
});

// 저장 버튼 클릭 시 내용이 없을 경우 alert창 뜨기
todo_save.addEventListener("click", function(e){
     if(todo_title.value== null || todo_title.value==""){
        alert("제목을 입력하세요");
 	   e.preventDefault();
     } else if(todo_text.value== null || todo_text.value==""){
        alert("내용을 입력하세요");
 	   e.preventDefault();
     }
});


// 별 아이콘 클릭 시 색깔 별로 바뀜
for(let i=0; i<star.length; i++){
    let y_star = true; // 토글

star[i].addEventListener("click", function(){
    if(y_star == true){
    star[i].className="xi-star";
    y_star = !y_star;
    event.stopImmediatePropagation(); 
    // 별 아이콘 클릭 시 수정모달창도 함께 나와 상위 이벤트 전파 방지

    } else if(y_star == false){
        star[i].className="xi-star-o";
        y_star = !y_star;
        event.stopImmediatePropagation();
  }
});
}
// input hidden
let todoDelete = document.querySelectorAll(".todoDelete");

// x 아이콘 클릭 시 삭제할 것인지 물어보기
for(let i=0; i<x_icon.length; i++){
	x_icon[i].addEventListener("click", function(){
		if(confirm("삭제하겠습니까?") == true){
			
		this.parentNode.submit();
	
			// X 아이콘 클릭 시 수정모달창도 함께 나와 상위 이벤트 전파 방지
		 event.stopImmediatePropagation();
		} else{
	     event.stopImmediatePropagation();
		}
		});
}


// 저장 버튼 클릭 후 ajax를 이용해 todo 생성
let my_board = document.querySelector(".my_board_box_list");
todo_save.addEventListener("click", function(){

	let todo_board = {
			todo_title : todo_title.value,
			todo_contents : todo_text.value,
			emp_num : emp_num
	}; 
	
	$.ajax({
		type : "POST",
		url : "/todo_list",
		dataType : "text",
		contentType : "application/json",
		data : JSON.stringify(todo_board),
		success : function(data){
			alert("todo가 생성되었습니다.")
			$(todo_write).prepend(data);
			todo_back.style.display="none";
			todo_title.value='';
			todo_text.value='';
			// ajax로 todo 생성 후 js가 잘 되지 않아 새로고침하였음
			location.reload();
		},
		error : function(data){
			// 코드 수정 후 새로고침 후 무한로딩 걸려서 방지하는 코드 추가
			if(data.readyState == 0 || data.status==0){
				return;
			}
			
			
		}
	});
});


let todo_num = 0;
//todo 클릭 시 수정 모달 창이 생기며 input값 가져옴
	for(let i=0; i<my_board_modal.length; i++){
	my_board_modal[i].addEventListener("click", function(input){
		todo_back.style.display="block";
		// 모달 클릭 시 버튼이 수정버튼으로 변경
		todo_save.style.display='none';
		todo_modify.style.display="block";
		todo_title.value=this.children[0].children[1].textContent;
		todo_text.value=this.children[0].children[2].textContent;
		todo_num = this.children[2].children[1].value;
	});
	}
	
		
// 수정 버튼 클릭 시 ajax로 수정된 내용으로 변경됨 
	todo_modify.addEventListener("click", function(){
		let todo_board = {
				todo_title : todo_title.value,
				todo_contents : todo_text.value,
				emp_num : emp_num,
				todo_num : todo_num
		};
		console.log(todo_board);
		$.ajax({
			type : "POST",
			url : "/todo_modify",
			dataType : "text",
			contentType : "application/json",
			data : JSON.stringify(todo_board),
			success : function(data){
				alert("todo가 수정되었습니다.")
				todo_back.style.display="none";
				todo_title.value='';
				todo_text.value='';
				// ajax로 todo 생성 후 js가 잘 되지 않아 새로고침하였음
				location.reload();
				todo_modify_num.parentNode.submit();
			},
			error : function(data){
				// 코드 수정 후 새로고침 후 무한로딩 걸려서 방지하는 코드 추가
				if(data.readyState == 0 || data.status==0){
					return;
				}			
			}
		});
	});
	

