import { frametalk } from "./frametalk.js";

frametalk.replyOn('getStatus', (event) => {
    return {status: 'OK'};
  });

document.addEventListener("DOMContentLoaded", () => {
    const child_frame = document.getElementById("child_frame").contentWindow;
    document.getElementById("send").addEventListener("click", () => {
        frametalk.send(child_frame, 'hello', {foo: 'bar'})
    })
})