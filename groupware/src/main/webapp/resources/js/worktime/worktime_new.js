/*
 * 이은지 220920 
 * 제목/내용 빈값 체크 버튼 클릭 시 페이지 이동 
 * 220924 
 * 조직도 검색 버튼 클릭 후 모달 생성 ajax, 
 * 결재자 박스 innerHTML
 * 220927
 * ajax로 select박스 선택 시 폼 변경
 */

// 기안일 날짜 설정
let worktime_date = document.querySelector(".worktime_new_date");   // 기안일
let date = new Date(); // 날짜
let year = date.getFullYear();   // 해당 년도
let month = date.getMonth()+1;   // 해당 월
let day = date.getDate();        // 해당 일
worktime_date.append(year+'년 '+month+'월 '+day+'일');  

// 서류 빈 칸 확인
let worktime_approval = document.querySelector(".table_approval_info");  // 결재선 지정
let vacation_date = document.querySelector("#worktime_vacation_date");   // 휴가 기간	
let half = document.querySelector("#worktime_docu_half");				 // 휴가계 오전/오후
let place = document.querySelector("#worktime_docu_place");				 // 휴가계 행선지
let title = document.querySelector("#worktime_docu_title");              // 휴가계 서류 제목
let reason = document.querySelector("#worktime_docu_reason");		     // 휴가계 서류 사유
let ckeditor = document.querySelector("#ckeditor");						 // 에디터
let approval_btn = document.querySelector(".worktime_approval");         // 상신 버튼
let cancel_byn = document.querySelector(".worktime_cancel");             // 취소 버튼

// 모달 창
let worktime_dept_modal_btn = document.querySelector(".worktime_dept_modal_btn");   // 조직도 버튼
let worktime_modal_back = document.querySelector("#worktime_modal_back"); 			// 모달 뒷배경
let worktime_modal = document.querySelector("#worktime_modal");			  			// 모달창
let worktime_close_btn = document.querySelector(".xi-close-circle");      			// x아이콘

// ajax
let worktime_dept_btn = document.querySelectorAll('.worktime_dept_btn'); 			// 부서명
let worktime_deptList = document.querySelector('#worktime_modal_dept_people_info'); // 사원 정보 출력될 곳

let middle_btn = document.querySelector(".middle_btn");					// 중간결재자 버튼
let final_btn = document.querySelector(".final_btn");					// 최종결재자버튼
let middle_box = document.querySelector(".middle_box");					// 중간결재자 들어갈 박스
let final_box = document.querySelector(".final_box");					// 최종결재자 들어갈 박스

// 결재자 입력
let middle_name = document.querySelector(".middle_name");				// 중간결재자 이름
let final_name = document.querySelector(".final_name");					// 최종결재자 이름
let middle_approval = document.querySelector(".middle_approval");		// 중간결재자 직위
let final_approval = document.querySelector(".final_approval");			// 최종결재자 직위
let middle_dept = document.querySelector(".middle_dept");				// 중간결재자 부서
let fianl_dept = document.querySelector(".fianl_dept");					// 최종결재자 부서
let modal_submit_btn = document.querySelector(".modal_submit_btn");		// 모달 창의 확인 버튼

//휴가계 신청 체크박스 ajax
let type_select = document.querySelector("#type_select"); 				// 휴가계종류																			// 선택
let table_box_thr = document.querySelector(".table_box_thr");			// ajax가 생길 공간

// 부서명 선택 모달 창의 검색 버튼
let dept_search_btn = document.querySelector("#dept_search_btn");		// 검색버튼
let dept_search_input = document.querySelector("#dept_search_input");	// input box
let dept_type_select = document.querySelector("#dept_type_select");		// 검색 옵션



// 서류 작성
// 상신 버튼 클릭 시 빈 값 체크
// 조건을 주기 위해 전역변수 선언
let worktime = 0;

//연차일경우
let vacation = function(){
approval_btn.addEventListener("click", function(e){
	
	
	
	if(middle_name.innerText == "" || middle_name.innerText == null){
		alert("결재자를 선택해주세요");
		e.preventDefault();
		middle_name.focus();
	  
    } else if(vacation_date.value == "" || vacation_date.value == null){
    	alert("휴가기간을 선택해주세요");
    	e.preventDefault();
    	
	}else if(reason.value == "" || reason.value == null){
        alert("사유를 작성해주세요");
        e.preventDefault();
        reason.focus();
    	      
    }else if(CKEDITOR.instances.ckeditor.getData() == '' || CKEDITOR.instances.ckeditor.getData()==''){
    	alert("내용을 작성해주세요");
    	e.preventDefault();
    	CKEDITOR.instances.ckeditor.getData().focus();
    	
    } else {
        alert("상신 전송되었습니다.");
        return true;
    }

});
}

// 반차일경우
let halfway = function(){
	approval_btn.addEventListener("click", function(e){

		if(middle_name.innerText == "" || middle_name.innerText == null){
			alert("결재자를 선택해주세요");
			e.preventDefault();
			middle_name.focus();
		  
	   }  else if(reason.value == "" || reason.value == null){
	        alert("사유를 작성해주세요");
	        e.preventDefault();
	        reason.focus();
	    
		} else if(title.value == "" || title.value == null){
	        alert("제목을 작성해주세요");
	        e.preventDefault();
	        title.focus();
	        
		} else if(half.value == "" || half.value == null){
	    	alert("오전/오후 반차를 작성해주세요");
	    	e.preventDefault();
	    	half.focus();
	    	
	    } else if(place.value == "" || place.value == null){
	    	alert("행선지를 작성해주세요");
	    	e.preventDefault();
	    	place.focus();
	    	      
	    }else if(CKEDITOR.instances.ckeditor.getData() == '' || CKEDITOR.instances.ckeditor.getData()==''){
	    	alert("내용을 작성해주세요");
	    	e.preventDefault();
	    	CKEDITOR.instances.ckeditor.getData().focus();
	    	
	    } else {
	        alert("상신 전송되었습니다.");
	        e.preventDefault();
	        return true;
	    }

	});
}


//휴가계 종류 선택할 때마다 form 변경
function worktime_docu_ajax(docu){
	$.ajax({
		type:"POST",
		url:"/worktime_" + docu,
		dataType:"text",
		success: function(data){
			$(table_box_thr).html(data); // 기존 html이 사라지고 그 위에 생김
			
			// 기안 부서
			let table_size = document.querySelector(".table_size");
		    
			// 기안일 
			let worktime_new_date = document.querySelector(".worktime_new_date");
			let date = new Date(); // 날짜
			let year = date.getFullYear();   // 해당 년도
			let month = date.getMonth()+1;   // 해당 월
			let day = date.getDate();        // 해당 일
			worktime_new_date.append(year+'년 '+month+'월 '+day+'일');
			if(worktime==1){
				vacation();
			} else if (worktime==2){
				halfway();
			}
		},
		error : function(data){
			console.log(data);
		}
	});
};

	// 휴가계 종류 선택할 때마다 ajax 변경
    type_select.addEventListener("change", function(){
			if(type_select.value == 'vacation'){
				worktime_docu_ajax("vacation");	
				worktime=1;
			} else if(type_select.value == 'halfway'){
				worktime_docu_ajax("halfway");
				worktime=2;
			} else if(type_select.value == 'sick_leave'){
				worktime_docu_ajax("sick_leave");
				worktime=3;
			} else if(type_select.value == 'early_departure'){
				worktime_docu_ajax("early_departure");
				worktime=4;
			} else if(type_select.value == 'business_trip'){
				worktime_docu_ajax("business_trip");
				worktime=5;
			} 
	});





// 취소 버튼 클릭 시 근태관리 홈으로 돌아감
cancel_byn.addEventListener("click", function(){
    if(confirm("작성을 취소하겠습니까?")){ 
        location.href=("/worktime");  
        // 확인 클릭 시 true라면 페이지 이동
    } else {
       // 취소 클릭 시 화면 그대로
    };  
});

// 모달
// 버튼 클릭 시 모달 창 보여지며 스크롤 방지
worktime_dept_modal_btn.addEventListener("click", function(){
	worktime_modal_back.style.display="block";
	worktime_modal.style.display="block";
	document.body.classList.add("stop_scroll");
});
// x아이콘 누를 시 모달 창 사라짐
worktime_close_btn.addEventListener("click", function(){
	worktime_modal_back.style.display="none";
	worktime_modal.style.display="none";
	document.body.classList.remove("stop_scroll");
});

// 휴가신청 페이지 들어오자마자 스크롤 방지가 되어 스크롤 방지 효과 사라질 수 있도록 선언하였음
document.body.classList.remove("stop_scroll");


// 부서명 클릭 시 ajax
// dept 정보 불러옴
for(let i=0; i<worktime_dept_btn.length; i++){
	worktime_dept_btn[i].addEventListener("click",function(){
		let get_name = this.innerText
		let dept_name = {
				dept_name : get_name
		      };
		$.ajax({
	         type : "POST",
	         url : "/worktime_dept",
	         dataType : "text",
	         contentType : "application/json",
	         data : JSON.stringify(dept_name),
	         success : function(data) {
	            $(worktime_deptList).html(data);
	         },
	         error : function(data) {
	            console.log(data);
	         }
	      });
	})
}


// 부서명 검색
dept_search_btn.addEventListener("click",function(){
	let keyword = dept_search_input.value;
	let dept_type_search_option = dept_type_select.value;
	let dept_keyword = {
			keyword : keyword,
			search_option : dept_type_search_option
	      };
	$.ajax({
         type : "POST",
         url : "/worktime_deptSearch",
         dataType : "text",
         contentType : "application/json",
         data : JSON.stringify(dept_keyword),
         success : function(data) {
        	 $(worktime_deptList).html(data);
         },
         error : function(data) {
            console.log(data);
         }
      });
})


// 중간결재자 버튼 누르면 모달 중간결재자 박스 안에 이름 나옴
middle_btn.addEventListener("click", function(){	
	let dept_info = document.getElementsByName("dept_info");
	for(let i=0; i<dept_info.length; i++){
		if(dept_info[i].checked){
			middle_box.children[0].textContent=dept_info[i].parentNode.nextElementSibling.textContent;
			middle_box.children[1].textContent=dept_info[i].parentNode.nextElementSibling.nextElementSibling.textContent;
			middle_box.children[2].textContent=dept_info[i].parentNode.nextElementSibling.nextElementSibling.nextElementSibling.textContent;
		}	
	}
});

// 모달 저장버튼 클릭 시 결재선 지정에 결재자 입력
modal_submit_btn.addEventListener("click", function(){
	
	if(middle_box.innerText != '' && final_box.innerText != ''){
	middle_name.textContent=middle_box.children[0].textContent;
	middle_approval.textContent=middle_box.children[1].textContent;
	middle_dept.textContent=middle_box.children[2].textContent;
	final_name.textContent=final_box.children[0].textContent;
	final_approval.textContent=final_box.children[1].textContent;
	fianl_dept.textContent=final_box.children[2].textContent;
	worktime_modal_back.style.display="none";
	worktime_modal.style.display="none";
	document.body.classList.remove("stop_scroll");
	
	} else if( middle_box.innerText == ''){
		alert("중간결재자를 선택하세요");
		// 조건이 맞지 않으면 스크롤 방지
		document.body.classList.add("stop_scroll");
	} else if(final_box.innerText == ''){
		alert("최종결재자를 선택하세요");
		// 조건이 맞지 않으면 스크롤 방지
		document.body.classList.add("stop_scroll");
	}
		
});

// 최종결재자 버튼 누르면 모달 최종결재자 박스 안에 이름 나옴
final_btn.addEventListener("click", function(){
	let dept_info = document.getElementsByName("dept_info");
	for(let i=0; i<dept_info.length; i++){
		if(dept_info[i].checked){
			final_box.children[0].textContent=dept_info[i].parentNode.nextElementSibling.textContent;
			final_box.children[1].textContent=dept_info[i].parentNode.nextElementSibling.nextElementSibling.textContent;
			final_box.children[2].textContent=dept_info[i].parentNode.nextElementSibling.nextElementSibling.nextElementSibling.textContent;
		}
	}
});







