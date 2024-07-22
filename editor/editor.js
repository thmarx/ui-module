window.addEventListener("DOMContentLoaded", () => {
    document.getElementById("test_message").addEventListener("click", () => {
        document.getElementById("content_frame").contentWindow.postMessage("test", "*");
    })
})

window.addEventListener("message", function (event) {
    console.log('child calling the child method');
});