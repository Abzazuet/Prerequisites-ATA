let image2show = null;
let image2hide = null;
let output = null;
let can1 = document.getElementById("image2show");
let can2 = document.getElementById("image2hide");
let can3 = document.getElementById("output");

function uploadImage2show(){
    image2show = document.getElementById("original");
    image2show = new SimpleImage(image2show);
    image2show.drawTo(can1);
}
function uploadImage2hide(){
    image2hide = document.getElementById("hidden");
    image2hide = new SimpleImage(image2hide);
    image2hide.drawTo(can2);
}
function generateCombination(){
    
}
