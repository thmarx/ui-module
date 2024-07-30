function attachToolbarToElement(element) {
    const toolbar = document.createElement('div');
    toolbar.classList.add('toolbar');

    const buttons = [
        { className: 'icon-a', label: 'A' },
        { className: 'icon-b', label: 'B' },
        { className: 'icon-c', label: 'C' }
    ];

    buttons.forEach(btn => {
        const button = document.createElement('button');
        button.classList.add('toolbar-button', btn.className);
        button.setAttribute('aria-label', btn.label); // Accessibility
        toolbar.appendChild(button);
    });

    element.style.position = 'relative'; // Ensure the element is positioned relatively
    element.appendChild(toolbar);
}

function attachPageToolbar () {
    const toolbar = document.createElement('div');
    toolbar.classList.add('toolbar');

    const buttons = [
        { className: 'icon-a', label: 'A' },
        { className: 'icon-b', label: 'B' },
        { className: 'icon-c', label: 'C' }
    ];

    buttons.forEach(btn => {
        const button = document.createElement('button');
        button.classList.add('toolbar-button', btn.className);
        button.setAttribute('aria-label', btn.label); // Accessibility
        toolbar.appendChild(button);
    });

    document.getElementById("page").appendChild(toolbar);
}

document.addEventListener('DOMContentLoaded', () => {
    const elements = document.querySelectorAll('body > div')
    elements.forEach(element => attachToolbarToElement(element))
    attachPageToolbar()
});
