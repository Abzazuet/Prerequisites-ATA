let dd1 = document.getElementById("div1");
let ctx = dd1.getContext("2d");
let dd2 = document.getElementById("div2");
let ctx2 = dd2.getContext("2d");
function doRed() {
    ctx.clearRect(0, 0, dd1.width, dd1.height);
    dd1.style.backgroundColor = "red";
    ctx.fillStyle = "yellow";
    ctx.fillRect(10, 10, 40, 40);
    ctx.fillRect(60, 10, 40, 40);
    ctx.font = ("15px Arial");
    ctx.fillStyle = "black";
    ctx.fillText("Hello", 30, 30);

}
function doBlue() {
    ctx.clearRect(0, 0, dd1.width, dd1.height);
    dd1.style.backgroundColor = "blue";
    ctx.fillStyle = "yellow";
    ctx.fillRect(10, 10, 40, 40);
    ctx.fillRect(60, 10, 40, 40);

    ctx.font = ("15px Arial");
    ctx.fillStyle = "black";
    ctx.fillText("Hello", 10, 30);
}
function doGreen(){
    ctx2.clearRect(0, 0, dd2.width, dd2.height);
    dd2.style.backgroundColor="green";
}
function pickColor(){
    let pickedColor = document.getElementById("pickColor");
    let value = pickedColor.value;
    dd2.style.backgroundColor = value;
}
function doSquare() {
    let sizeInput = document.getElementById("slider");
    let size = sizeInput.value;
    ctx2.clearRect(0, 0, dd2.width, dd2.height);

    ctx2.fillStyle = "yellow";
    ctx2.fillRect(10, 10, size, size);
}
