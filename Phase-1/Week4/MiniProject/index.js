let image = null;
let can = document.getElementById("canvas");
function uploadImage(){
    image = document.getElementById("fInput");
    image = new SimpleImage(image);
    image.drawTo(can);
    changeImageDimension();
}
function changeImageDimension () {
    let width = image.width;
    let height = image.height;
    console.log(width, height, image);
}