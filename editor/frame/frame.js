import { frametalk } from "./frametalk.js";

frametalk.on('hello', (event, data) => {
    console.log(data); // output: {foo: 'bar'}
});

document.addEventListener("DOMContentLoaded", () => {
    const parent_window = window.parent;
    document.getElementById("frame_send").addEventListener("click", () => {
        frametalk.request(parent_window, 'getStatus')
            .then((res) => {
                console.log(res) // output: {status: 'OK'}
            })
    })
})