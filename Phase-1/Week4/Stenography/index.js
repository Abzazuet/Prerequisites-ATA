let image2show = null;
let image2hide = null;
let output = null;
let choppedImage = null;
let hiddenImage = null;
let can1 = document.getElementById("image2show");
let can2 = document.getElementById("image2hide");
let can3 = document.getElementById("output");

function uploadImage2show() {
    image2show = document.getElementById("original");
    image2show = new SimpleImage(image2show);
    image2show.drawTo(can1);
}
function uploadImage2hide() {
    image2hide = document.getElementById("hidden");
    image2hide = new SimpleImage(image2hide);
    image2hide.drawTo(can2);
    choppedImage = chop2hide(image2show);
}
function generateCombination() {
    hiddenImage = hideImage(image2hide);
    output = image2show;
    for (let pixel of choppedImage.values()) {
        let x = pixel.getX();
        let y = pixel.getY();
        if (x < 960) {
            if (y < 1200) {
                if (x > hiddenImage.getWidth() || y > hiddenImage.getHeight()) {
                    output.setRed(x, y, pixel.getRed());
                    output.setGreen(x, y, pixel.getGreen());
                    output.setBlue(x, y, pixel.getBlue());
                }
                else {
                    output.setRed(x, y, pixel.getRed() + hiddenImage.getRed(x, y));
                    output.setGreen(x, y, pixel.getGreen() + hiddenImage.getGreen(x, y));
                    output.setBlue(x, y, pixel.getBlue() + hiddenImage.getBlue(x, y));
                }
            }
        }

    }
    output.drawTo(can3);
}
function hideImage(image) {
    let width = image.getWidth();
    let height = image.getHeight();
    hiddenImage = new SimpleImage(width, height);
    for (let pixel of image.values()) {
        let x = pixel.getX();
        let y = pixel.getY();
        hiddenImage.setRed(x, y, Math.floor(pixel.getRed() % 16));
        hiddenImage.setGreen(x, y, Math.floor(pixel.getGreen() % 16));
        hiddenImage.setBlue(x, y, Math.floor(pixel.getBlue() % 16));
    }
    return hiddenImage;
}
function chop2hide(image) {
    let width = image.getWidth();
    let height = image.getHeight();
    let choppedImage = new SimpleImage(width, height);
    for (let pixel of image.values()) {
        let x = pixel.getX();
        let y = pixel.getY();
        choppedImage.setRed(x, y, Math.floor(pixel.getRed() / 16) * 16);
        choppedImage.setGreen(x, y, Math.floor(pixel.getGreen() / 16) * 16);
        choppedImage.setBlue(x, y, Math.floor(pixel.getBlue() / 16) * 16);
    }
    return choppedImage
}