//초성 검색 ajax
function ajax_call(first, second) {
	$.ajax({
		url : 'ajaxChosung',
		type : 'POST',
		data : {
			'first_consonant' : first,
			'second_consonant' : second
		},
		dataType : 'text',
		success : function(data) {
			console.log(data)

			const address_all_list = document
					.querySelector('.address_all_list')
			address_all_list.innerHTML = data; // address_all_list.jsp 내용이
												// 담겨있음
		},
		error : function(data) {
			console.log(data)
		}

	})
}
const address_all_search_consonant = document
		.querySelector(".address_all_search_consonant");
address_all_search_consonant.addEventListener('click', function(e) {
	e.preventDefault() // 이벤트 처리 막음
	if (e.target.className != "address_all_search_consonant") { // 선택한요소의 클래스
																// 이름이 해당 거시기랑
																// 다른거
		if (e.target.textContent == 'ㄱ') {
			ajax_call('가', '나')
		} else if (e.target.textContent == 'ㄴ') {
			ajax_call('나', '다')
		} else if (e.target.textContent == 'ㄷ') {
			ajax_call('다', '라')
		} else if (e.target.textContent == 'ㄹ') {
			ajax_call('라', '마')
		} else if (e.target.textContent == 'ㅁ') {
			ajax_call('마', '바')
		} else if (e.target.textContent == 'ㅂ') {
			ajax_call('바', '사')
		} else if (e.target.textContent == 'ㅅ') {
			ajax_call('사', '아')
		} else if (e.target.textContent == 'ㅇ') {
			ajax_call('아', '자')
		} else if (e.target.textContent == 'ㅈ') {
			ajax_call('자', '차')
		} else if (e.target.textContent == 'ㅊ') {
			ajax_call('차', '카')
		} else if (e.target.textContent == 'ㅋ') {
			ajax_call('카', '타')
		} else if (e.target.textContent == 'ㅌ') {
			ajax_call('타', '파')
		} else if (e.target.textContent == 'ㅍ') {
			ajax_call('파', '하')
		} else if (e.target.textContent == 'ㅎ') {
			ajax_call('하', '힣')
		} else if (e.target.textContent == 'a-z') {
			ajax_call('a', 'z')
		}
	}

})

//초성 검색 중 전체 부분 ajax
function ajax_whole(first, second) {
	$.ajax({
		url : 'ajaxChosungAll', 
		type : 'POST',
		data : {
			'first_consonant' : first,
			'second_consonant' : second
		},
		dataType : 'text',
		success : function(data) {
			console.log(data)
			const address_all_list = document
					.querySelector('.address_all_list')
			address_all_list.innerHTML = data; 
												
		},
		error : function(data) {
			console.log(data)
		}

	})
}
const address_all_search_consonant1 = document
		.querySelector(".address_all_search_consonant");
address_all_search_consonant1.addEventListener('click', function(e) {
	e.preventDefault()
	if (e.target.className != "address_all_search_consonant") {
		if (e.target.textContent == '전체') {
			ajax_whole('a', '힣');
		}
	}
})

//검색 ajax
const search_emo = document.querySelector(".xi-search");
search_emo.addEventListener('click', function() {
	
const keyword_search = document.querySelector(".keyword_search");

	$.ajax({
		url : 'ajaxSearch',
		type : 'POST',
		data : {
			'keyword' : keyword_search.value // 매퍼에 들어가는 키 , address_all.jsp에 있는 input 클래스(value)
			
		},
		dataType : 'text',
		success : function(data) {
			console.log(data)
			const address_all_list = document
					.querySelector('.address_all_list')
			address_all_list.innerHTML = data; 
												
		},
		error : function(data) {
			console.log(data)
		}

	})
		
	
})
