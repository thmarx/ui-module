const STATE = {
    selected: false
}

window.addEventListener("DOMContentLoaded", () => {
    /*
    document.querySelectorAll("[data-cms-editor]").forEach(element => {
        element.addEventListener("mouseover", element_mouseover);
        element.addEventListener("mouseout", element_mouseout);
    })
        */

    const containers = document.querySelectorAll('[data-cms-editor]');

    containers.forEach(container => {
        const toolbar = container.querySelector('.toolbar');

        container.addEventListener('mouseover', () => {
            toolbar.style.display = 'block';
        });

        container.addEventListener('mouseleave', (event) => {
            if (!event.relatedTarget || !container.contains(event.relatedTarget)) {
                toolbar.style.display = 'none';
            }
        });

        toolbar.addEventListener('mouseleave', (event) => {
            if (!event.relatedTarget || !container.contains(event.relatedTarget)) {
                toolbar.style.display = 'none';
            }
        });
    });

})
function edit (event) {
    console.log(event)
    var $editor = event.target.closest('[data-cms-editor]');
    if ($editor) {
        console.log($editor.dataset.cmsElement)
    }
}
window.addEventListener("message", function (event) {
    console.log('parent calling the child method', event.data)
    if (event.data.type === "selectElements") {
        STATE.selected = !STATE.selected

        document.querySelectorAll("[data-cms-editor]").forEach(element => {
            if (STATE.selected) {
                element.classList.add("cms-ui-selected");
            } else {
                element.classList.remove("cms-ui-selected");
            }
        })
    }
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

