let dd1 = document.getElementById("div1");
let ctx = dd1.getContext("2d");

function doRed() {
    ctx.clearRect(0, 0, dd1.width,dd1.height);
    dd1.style.backgroundColor = "red";
    ctx.fillStyle = "yellow";
    ctx.fillRect(10, 10, 40, 40);
    ctx.fillRect(60, 10, 40, 40);
    ctx.font = ("15px Arial");
    ctx.fillStyle = "black";
    ctx.fillText("Hello", 30, 30);

}
function doBlue() {
    ctx.clearRect(0, 0, dd1.width,dd1.height);
    dd1.style.backgroundColor = "blue";
    ctx.fillStyle = "yellow";
    ctx.fillRect(10, 10, 40, 40);
    ctx.fillRect(60, 10, 40, 40);
    
    ctx.font = ("15px Arial");
    ctx.fillStyle = "black";
    ctx.fillText("Hello", 10, 30);
}
