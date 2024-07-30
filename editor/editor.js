
window.addEventListener("DOMContentLoaded", () => {
    document.getElementById("test_message").addEventListener("click", () => {
        var data = {
            type: "selectElements"
        }
        document.getElementById("content_frame").contentWindow.postMessage(data, "*")
    })

    document.getElementById("editPageAction").addEventListener("click", () => {
        const editPageModal = new bootstrap.Modal('#editPageModal', {})
        editPageModal.show()
    })

    document.getElementById("content_frame").addEventListener("load", () => {
        var loc = new URL(document.getElementById("content_frame").contentWindow.location.href)
        console.log(loc.pathname)
    })

    require.config({ paths: { vs: 'https://cdn.jsdelivr.net/npm/monaco-editor@0.50.0/min/vs' } });
    require(['vs/editor/editor.main'], function () {
        window.codeEditor = monaco.editor.create(document.getElementById('editorContainer'), {
            value: "",
            language: 'markdown',
            automaticLayout: true
        });
    });
})

window.addEventListener("message", function (event) {
    console.log('child calling the child method', event);
});