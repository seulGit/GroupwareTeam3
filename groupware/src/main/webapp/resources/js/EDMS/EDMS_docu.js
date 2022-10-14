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
