window.addEventListener("DOMContentLoaded", () => {
    document.querySelectorAll("[data-cms-editor]").forEach(element => {
        element.addEventListener("mouseover", element_mouseover);
        element.addEventListener("mouseout", element_mouseout);
    })
})
window.addEventListener("message", function (event) {
    console.log('parent calling the child method')
})

const element_mouseover = (event) => {
    if (!event.target.getAttribute('data-cms-editor')) {
        return;
    }
    event.target.classList.add("cms-ui-selected");
}
const element_mouseout = (event) => {  
    event.target.classList.remove("cms-ui-selected");
}