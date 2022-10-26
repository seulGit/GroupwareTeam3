window.onload = function () {
    // 에디터 사용
    ClassicEditor
        .create(document.querySelector('#editor'))
        .then(editor => {
            const toolbarElement = editor.ui.view.toolbar.element;
            editor.on( 'change:isReadOnly', ( evt, propertyName, isReadOnly ) => {
                    toolbarElement.style.display = 'none';
            } );
            editor.enableReadOnlyMode( 'my-feature-id' );
        })
        .catch(error => {
            console.log(error);
        });
}

if(EDMS_docu_category){
    const EDMS_remove = document.querySelector(".EDMS_remove");
} else{
    const EDMS_approval = document.querySelector(".EDMS_approval");
    const EDMS_cancel = document.querySelector(".EDMS_cancel");
}


const print = document.querySelector(".xi-print");
const EDMS_print = document.querySelector("#EDMS_print");

print.addEventListener("click", function(){
    window.print();
})
function beforePrint() {
    boxes = document.body.innerHTML;
    document.body.innerHTML = EDMS_print.innerHTML;
}
function afterPrint() {
    document.body.innerHTML = boxes;
}
window.onbeforeprint = beforePrint;
window.onafterprint = afterPrint;