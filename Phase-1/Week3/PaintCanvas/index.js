let canvas = document.getElementById("canvas");
let ctx = canvas.getContext("2d");
let width = document.getElementById("width");
let height = document.getElementById("height");
let isPainting = false;
let color = document.getElementById("colorPicker").value;
let radius = document.getElementById("brushSize").value;
let output = document.getElementById("sizeOutput");
function setWidth() {
    canvas.width = width.value;
}
function setHeight() {
    canvas.height = height.value;
}
function changeColor() {
    color = document.getElementById("colorPicker").value;
}
function clearCanvas() {
    ctx.clearRect(0, 0, canvas.width, canvas.height);
}
function changeBrushSize() {
    output.value = radius;
    radius = document.getElementById("brushSize").value;
}
function startPaint() {
    isPainting = true;
}
function endPaint() {
    isPainting = false;
}
function doPaint(x, y) {
    if (isPainting) {
        ctx.beginPath();
        ctx.arc(x, y, radius, 0, Math.PI * 2, true);
        ctx.fillStyle = color;
        ctx.fill();
    }
}


