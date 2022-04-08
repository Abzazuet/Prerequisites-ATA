let image = null;
let greyImage = null;
let redImage = null;
let rainbowImage = null;
let blurImage = null;
let can = document.getElementById("canvas");
let dimensions = document.getElementById("imageDimension");
function uploadImage() {
    image = document.getElementById("fInput");
    image = new SimpleImage(image);
    image.drawTo(can);
    dimensions.innerHTML = `Press greyscale to know length`;
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
    dimensions.innerHTML = `${image.width}x${image.height}`;
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
        let avg = (pixel.getRed() + pixel.getBlue() + pixel.getGreen()) / 3
        if (y < (height / 7)) {
            // red #ff0000 
            if (avg < 128) {
                rainbowImage.setRed(x, y, 2 * avg);
                rainbowImage.setBlue(x, y, 0);
                rainbowImage.setGreen(x, y, 0);
            } else {
                rainbowImage.setRed(x, y, 255);
                rainbowImage.setBlue(x, y, 2 * avg - 255);
                rainbowImage.setGreen(x, y, 2 * avg - 255);
            }
        }
        else if (y < (height / 7) * 2) {
            //  orange #ffa500 
            if (avg < 128) {
                rainbowImage.setRed(x, y, 2 * avg);
                rainbowImage.setBlue(x, y, 0);
                rainbowImage.setGreen(x, y, .8 * avg);
            } else {
                rainbowImage.setRed(x, y, 255);
                rainbowImage.setBlue(x, y, 2 * avg - 255);
                rainbowImage.setGreen(x, y, 1.2 * avg - 51);
            }
        }
        else if (y < (height / 7) * 3) {
            // yellow #ffff00 
            if (avg < 128) {
                rainbowImage.setRed(x, y, 2 * avg);
                rainbowImage.setBlue(x, y, 0);
                rainbowImage.setGreen(x, y, 2 * avg);
            } else {
                rainbowImage.setRed(x, y, 255);
                rainbowImage.setBlue(x, y, 2 * avg - 255);
                rainbowImage.setGreen(x, y, 255);
            }
        }
        else if (y < (height / 7) * 4) {
            //green #008000 
            if (avg < 128) {
                rainbowImage.setRed(x, y, 0);
                rainbowImage.setGreen(x, y, 2 * avg);
                rainbowImage.setBlue(x, y, 0);
            } else {
                rainbowImage.setRed(x, y, 2 * avg - 255);
                rainbowImage.setGreen(x, y, 255);
                rainbowImage.setBlue(x, y, 2 * avg - 255);

            }
        }
        else if (y < (height / 7) * 5) {
            //blue #0000ff 
            if (avg < 128) {
                rainbowImage.setRed(x, y, 0);
                rainbowImage.setGreen(x, y, 0);
                rainbowImage.setBlue(x, y, 2 * avg);
            } else {
                rainbowImage.setRed(x, y, 2 * avg - 255);
                rainbowImage.setGreen(x, y, 2 * avg - 255);
                rainbowImage.setBlue(x, y, 255);
            }
        }
        else if (y < (height / 7) * 6) {
            //  indigo #4b0082 
            if (avg < 128) {
                rainbowImage.setRed(x, y, 0.8 * avg);
                rainbowImage.setGreen(x, y, 0);
                rainbowImage.setBlue(x, y, 2 * avg);
            } else {
                rainbowImage.setRed(x, y, 1.2 * avg - 51);
                rainbowImage.setGreen(x, y, 2 * avg - 255);
                rainbowImage.setBlue(x, y, 255);
            }
        }
        else {
            // violet #ee82ee 
            if (avg < 128) {
                rainbowImage.setRed(x, y, 1.6 * avg);
                rainbowImage.setGreen(x, y, 0);
                rainbowImage.setBlue(x, y, 1.6 * avg);
            } else {
                rainbowImage.setRed(x, y, .4 * avg + 153);
                rainbowImage.setGreen(x, y, 2 * avg - 255);
                rainbowImage.setBlue(x, y, .4 * avg + 153);
            }
        }
    }
    rainbowImage.drawTo(can);


}
function filterBlur() {
    blurImage = new SimpleImage(image.getWidth(), image.getHeight());
    for (let pixel of image.values()) {
        let x = pixel.getX();
        let y = pixel.getY();
        let width = image.getWidth();
        let height = image.getHeight();
        let random = Math.random();
        if (random < .5) {
            blurImage.setGreen(x, y, pixel.getGreen());
            blurImage.setRed(x, y, pixel.getRed());
            blurImage.setBlue(x, y, pixel.getBlue());
        }
        else {
            let randomX = x + Math.random() * 10 - 5;
            let randomY = y + Math.random() * 10 - 5;
            if (randomX < 0 || randomY < 0 || randomX > width || randomY > height) {
                blurImage.setGreen(x, y, pixel.getGreen());
                blurImage.setRed(x, y, pixel.getRed());
                blurImage.setBlue(x, y, pixel.getBlue());
            }
            else {
                blurImage.setGreen(x, y, image.getGreen(randomX, randomY));
                blurImage.setRed(x, y, image.getRed(randomX, randomY));
                blurImage.setBlue(x, y, image.getBlue(randomX, randomY));
            }
        }
    }
    blurImage.drawTo(can);
}
function filterReset() {
    image.drawTo(can);
}