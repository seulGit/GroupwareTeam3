const category_input = document.querySelector('.address_personal_input_box');
const category_add = document.querySelector('.address_personal_category_add');

category_add.addEventListener('click', function(){
    category_input.style.display = 'block'
    
})








//const categoryAddBtn = document.querySelector(".xi-check");
//categoryAddBtn.addEventListener('click',function(){
//	
//	$.ajax({
//		url : 'ajaxCategory',
//		type : 'POST',
//		data : {
//			'searchCategory' : address_personal_category_input.value, 
//		},
//		dataType : 'text',
//		success : function(categoryData) {
//			console.log(categoryData)
//			const address_personal_category_list = document
//					.querySelector('.address_personal_category_list')
//			address_personal_category_list.innerHTML = categoryData; 
//												
//		},
//		error : function(categoryData) {
//			console.log(categoryData)
//		}
//
//	})
//		
//	
//})