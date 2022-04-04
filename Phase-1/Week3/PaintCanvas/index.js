let canvas = document.getElementById("canvas");
let ctx = canvas.getContext("2d");
let width = document.getElementById("width");
let height = document.getElementById("height");


function setWidth(){
    canvas.width = width.value;
    console.log(canvas.width)
}
function setHeight(){
    canvas.height = height.value;
    console.log(canvas.height)
}
