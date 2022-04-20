import edu.duke.*;
import java.io.*;

public class GrayScaleConverter {
    public ImageResource makeGray(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pixel : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen()) / 3;
            pixel.setRed(average);
            pixel.setBlue(average);
            pixel.setGreen(average);
        }
        return outImage;
    }

    public void testGray() {
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }

    public void doSave(String method) {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            ImageResource image = null;
            String newName = null;
            if (method == "gray") {
                image = makeGray(new ImageResource(f));
                String name = f.getName();
                newName = "gray_" + name;
            }
            else {
                image = makeInverse(new ImageResource(f));
                String name = f.getName();
                newName = "inverse_" + name;
            }

            image.setFileName(newName);
            image.save();
        }
    }

    public ImageResource makeInverse(ImageResource inImage) {
        ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
        for (Pixel pixel : outImage.pixels()) {
            Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
            int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen()) / 3;
            pixel.setRed(255 - average);
            pixel.setBlue(255 - average);
            pixel.setGreen(255 - average);
        }
        return outImage;
    }

    public void testInverse() {
        ImageResource ir = new ImageResource();
        ImageResource inverse = makeInverse(ir);
        inverse.draw();
    }

    public static void main(String[] args) {
        GrayScaleConverter gray = new GrayScaleConverter();
        gray.doSave("gray");
    }
}
