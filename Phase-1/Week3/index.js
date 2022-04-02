function doRed() {
    let dd1 = document.getElementById("div1");
    dd1.className = "redback"
    let ctx = dd1.getContext("2d");
    ctx.fillStyle = "yellow";
    ctx.fillRect(10, 10, 60, 60);
    ctx.fillRect(80, 10, 60, 60);

    ctx.fillStyle = "black";
    ctx.font = "20px Arial";
    ctx.fillText = ("Hello", 0, 0);
}
function doBlue() {
    let dd1 = document.getElementById("div1");
    dd1.className = "blueback";
    let ctx = dd1.getContext("2d");
    ctx.fillStyle = "yellow";
    ctx.fillRect(10, 10, 60, 60);
    ctx.fillRect(80, 10, 60, 60);

    ctx.font = "20000px Arial";
    ctx.fillText = ("Hello", 0, 0);
}
