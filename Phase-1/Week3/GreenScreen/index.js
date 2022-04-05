let imageFG = null;
let imageBG = null;
let greenThreshold = 254;
let fgImage = document.getElementById("foregroundImage");
let bgImage = document.getElementById("backgroundImage");

function uploadFG() {
    let fileInput = document.getElementById("fInput");
    imageFG = new SimpleImage(fileInput);
    imageFG.drawTo(fgImage);
}
function uploadBG() {
    let fileInput = document.getElementById("bInput");
    imageBG = new SimpleImage(fileInput);
    imageBG.drawTo(bgImage);
}
function greenScreen() {
    if (imageFG == null || !imageFG.complete()) {
        alert("Foreground is not loaded");
        return;
    }
    if (imageBG == null || !imageBG.complete()) {
        alert("Background is not loaded");
        return;
    }
    clearCanvases();
    let output = new SimpleImage(imageFG.getWidth(), imageFG.getHeight());
    for (let pixel of imageFG.values()) {
        let x = pixel.getX();
        let y = pixel.getY();
        if (pixel.getGreen() > greenThreshold) {
            let bgPixel = imageBG.getPixel(x, y);
            output.setPixel(x, y, bgPixel);
        }
        else {
            output.setPixel(x, y, pixel);
        }
    }
    output.drawTo(fgImage);

}
function clearCanvases() {
    let ctx = fgImage.getContext("2d");
    let ctx2 = bgImage.getContext("2d");
    ctx.clearRect(0, 0, fgImage.width, fgImage.height);
    ctx2.clearRect(0, 0, bgImage.width, bgImage.height);
}