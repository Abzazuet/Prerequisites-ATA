let image = null;
let greyImage = null;
let redImage = null;
let rainbowImage = null;
let can = document.getElementById("canvas");
function uploadImage() {
    image = document.getElementById("fInput");
    image = new SimpleImage(image);
    image.drawTo(can);
    changeImageDimension();
}
function changeImageDimension() {
    let width = image.getWidth();
    let height = image.getHeight();
}
function filterGrey() {
    greyImage = new SimpleImage(image.getWidth(), image.getHeight());
    for (let pixel of image.values()) {
        let avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
        let x = pixel.getX();
        let y = pixel.getY();
        greyImage.setGreen(x, y, avg);
        greyImage.setRed(x, y, avg);
        greyImage.setBlue(x, y, avg);
    }
    greyImage.drawTo(can);
}
function filterRed() {
    redImage = new SimpleImage(image.getWidth(), image.getHeight());
    for (let pixel of image.values()) {
        let x = pixel.getX();
        let y = pixel.getY();
        let avg = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
        if (avg < 128) {
            redImage.setRed(x, y, avg * 2);
            redImage.setGreen(x, y, 0);
            redImage.setBlue(x, y, 0);
        }
        else {
            redImage.setRed(x, y, 255);
            redImage.setGreen(x, y, avg * 2 - 255);
            redImage.setBlue(x, y, avg * 2 - 255);
        }
    }
    redImage.drawTo(can);
}
function filterRainbow() {
    rainbowImage = new SimpleImage(image.getWidth(), image.getHeight());
    let height = rainbowImage.getHeight();
    for (let pixel of image.values()) {
        let x = pixel.getX();
        let y = pixel.getY();
        if (y < (height / 7)) {
            // red #ff0000 
            rainbowImage.setRed(x, y, 255);
            rainbowImage.setBlue(x, y, pixel.getBlue());
            rainbowImage.setGreen(x, y, pixel.getGreen());

        }
        else if (y < (height / 7) * 2) {
            //  orange #ffa500 
            rainbowImage.setRed(x, y, 255);
            rainbowImage.setBlue(x, y, pixel.getBlue());
            rainbowImage.setGreen(x, y, 165);
        }
        else if (y < (height / 7) * 3) {
            // yellow #ffff00 
            rainbowImage.setRed(x, y, 255);
            rainbowImage.setBlue(x, y, pixel.getBlue());
            rainbowImage.setGreen(x, y, 255);
        }
        else if (y < (height / 7) * 4) {
            //green #008000 
            rainbowImage.setRed(x, y, pixel.getRed());
            rainbowImage.setBlue(x, y, pixel.getBlue());
            rainbowImage.setGreen(x, y, 255);
        }
        else if (y < (height / 7) * 5) {
            //blue #0000ff 
            rainbowImage.setRed(x, y, pixel.getRed());
            rainbowImage.setBlue(x, y, 255);
            rainbowImage.setGreen(x, y, pixel.getGreen());
        }
        else if (y < (height / 7) * 6) {
            //  indigo #4b0082 
            rainbowImage.setRed(x, y, 75 + pixel.getRed());
            rainbowImage.setBlue(x, y, 130 + pixel.getBlue());
            rainbowImage.setGreen(x, y, pixel.getGreen());
        }
        else {
            // violet #ee82ee 
            rainbowImage.setRed(x, y, 238);
            rainbowImage.setBlue(x, y, 238);
            rainbowImage.setGreen(x, y, pixel.getGreen());
        }
    }
    rainbowImage.drawTo(can);


}
function filterReset() {
    image.drawTo(can);
}